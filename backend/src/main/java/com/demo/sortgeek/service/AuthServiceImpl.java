package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.response.JwtTokenDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Override
    public JwtTokenDTO authenticateAndGenerateToken(String memberId, String password) { return null; }

    @Override
    public JwtTokenDTO refreshAccessToken(String refreshToken) {
        return null;
    }
}
