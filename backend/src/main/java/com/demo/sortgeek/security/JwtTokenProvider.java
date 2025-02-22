package com.demo.sortgeek.security;

import com.demo.sortgeek.domain.Member;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import io.jsonwebtoken.*;

@Slf4j
@Component
public class JwtTokenProvider {
    private final Key key;

    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public JwtToken generateToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(",")); // 권한을 문자열로 결합

        if (authentication.getName() == null){
            throw new RuntimeException("memberId가 없습니다.");
        }
        long now = System.currentTimeMillis();
        Date accessTokenExpiresIn = new Date(now + 900 * 1000); // 15분


        System.out.println(authorities + " " + authentication.getName());

        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("role", authorities) // 권한 정보를 추가
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        Date refreshTokenExpiresIn = new Date(now + 3600 * 1000 * 24); // 24시간
        String refreshToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("role", authorities) // 권한 정보를 추가
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return JwtToken.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    // 쿠키에서 Refresh Token을 가져오는 메서드
    public String getRefreshTokenFromCookie(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("refreshToken".equals(cookie.getName())) {
                    String refreshToken = cookie.getValue();
                    if (extractUserId(refreshToken) == null){
                        throw new RuntimeException("서브  정보가 없는 리프레시 토큰");
                    }
                    return cookie.getValue();
                }
            }
        }
        throw new RuntimeException("리프레시 토큰이 쿠키에 존재하지 않습니다.");
    }

    // 토큰에서 Authentication 객체 가져오기
    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);

        if (claims.get("role") == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        // 권한 정보를 처리
        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("role").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // Member 객체 생성
        String memberId = claims.getSubject();
        Member principal = new Member();
        principal.setLoginId(memberId);
        principal.setRoles(authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    // 토큰 유효성 검사 메서드
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    // 토큰에서 Claims 파싱
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    // 토큰에서 사용자 ID를 추출하는 메서드
    public String extractUserId(String token) {
        Claims claims = parseClaims(token);
        return claims.get("sub", String.class);
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}