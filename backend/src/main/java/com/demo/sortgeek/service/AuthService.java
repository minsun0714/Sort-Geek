package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.response.JwtTokenDTO;

public interface AuthService {
    JwtTokenDTO authenticateAndGenerateToken(String memberId, String password);

    JwtTokenDTO refreshAccessToken(String refreshToken);
}
