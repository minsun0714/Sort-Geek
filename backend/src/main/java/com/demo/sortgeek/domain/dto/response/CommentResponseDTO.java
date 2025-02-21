package com.demo.sortgeek.domain.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {
    private Long commentId;
    private Long codeId;
    private Long parentId;
    private String content;
    private LocalDateTime createdAt;
}
