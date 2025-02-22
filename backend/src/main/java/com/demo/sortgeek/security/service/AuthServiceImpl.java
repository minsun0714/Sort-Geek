package com.demo.sortgeek.security.service;

import com.demo.sortgeek.domain.Member;
import com.demo.sortgeek.repository.MemberRepository;
import com.demo.sortgeek.security.JwtToken;
import com.demo.sortgeek.security.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public JwtToken authenticateAndGenerateToken(String loginId, String password) {
//        Long memberId = memberRepository.findByLoginId(loginId)
//                .map(Member::getMemberId)
//                .orElseThrow(() -> new IllegalArgumentException("Member not found: " + loginId));
//
//        System.out.println(memberId);
        // 유저 인증 처리
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginId, password)
        );
        System.out.println(authentication);

        // 인증에 성공하면 토큰 생성
        return jwtTokenProvider.generateToken(authentication);
    }

    @Transactional
    @Override
    public JwtToken refreshAccessToken(String refreshToken) {

        if (jwtTokenProvider.validateToken(refreshToken)) {
            Authentication authentication = jwtTokenProvider.getAuthentication(refreshToken);
            return jwtTokenProvider.generateToken(authentication);
        }
        return null;
    }
}
