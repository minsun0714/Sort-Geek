package com.demo.sortgeek.controller;

import com.demo.sortgeek.domain.dto.request.LoginRequestDTO;
import com.demo.sortgeek.domain.dto.response.JwtTokenDTO;
import com.demo.sortgeek.security.JwtToken;
import com.demo.sortgeek.security.JwtTokenProvider;
import com.demo.sortgeek.security.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.sortgeek.security.utils.CookieUtils.setRefreshTokenCookie;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;
    // 로그인 엔드포인트
    @PostMapping("/login")
    public ResponseEntity<JwtTokenDTO> login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        // 유저 인증 처리
        // 인증에 성공하면 토큰 생성
        System.out.println(loginRequestDTO);
        JwtToken jwtToken = authService.authenticateAndGenerateToken(loginRequestDTO.getLoginId(), loginRequestDTO.getPassword());
        System.out.println(jwtToken);
        setRefreshTokenCookie(response, jwtToken.getRefreshToken());

        return ResponseEntity.ok(new JwtTokenDTO("Bearer", jwtToken.getAccessToken()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtTokenDTO> refresh(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = jwtTokenProvider.getRefreshTokenFromCookie(request);
        // Refresh Token을 검증하고 새로운 Access Token 발급
        if (jwtTokenProvider.validateToken(refreshToken)) {
            JwtToken newToken = authService.refreshAccessToken(refreshToken);

            setRefreshTokenCookie(response, newToken.getRefreshToken());

            return ResponseEntity.ok(new JwtTokenDTO("Bearer", newToken.getAccessToken()));
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // 유효하지 않은 Refresh Token
        }
    }
}
