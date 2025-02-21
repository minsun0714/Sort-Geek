package com.demo.sortgeek.domain.dto.response;

import com.demo.sortgeek.domain.enums.LANGUAGE;
import com.demo.sortgeek.domain.enums.STATUS;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredCodeResponseDTO {
    private Long codeId;
    private String code;
    private LANGUAGE language;
    private STATUS status;
    private Long likeCount;
    private Long dislikeCount;
    private Long commentCount;
    private LocalDateTime createdAt;
}