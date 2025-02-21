package com.demo.sortgeek.domain.dto.response;

import com.demo.sortgeek.domain.enums.ROLE;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDTO {
    private Long memberId;
    private String loginId;
    private String profileImg;
    private ROLE role;
    private LocalDateTime createdAt;
}
