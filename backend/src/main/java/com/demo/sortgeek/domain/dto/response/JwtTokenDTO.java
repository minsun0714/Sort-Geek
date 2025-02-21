package com.demo.sortgeek.domain.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtTokenDTO {
    private String grantType;
    private String accessToken;
}