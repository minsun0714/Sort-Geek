package com.demo.sortgeek.security.service;

import com.demo.sortgeek.security.JwtToken;

public interface AuthService {
    JwtToken authenticateAndGenerateToken(String memberId, String password);

    JwtToken refreshAccessToken(String refreshToken);
}
