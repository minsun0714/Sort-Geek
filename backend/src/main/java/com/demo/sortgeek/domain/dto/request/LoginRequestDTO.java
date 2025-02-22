package com.demo.sortgeek.domain.dto.request;

import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    private String loginId;
    private String password;
}
