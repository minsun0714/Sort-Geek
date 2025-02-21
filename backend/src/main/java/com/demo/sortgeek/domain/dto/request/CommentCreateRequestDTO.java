package com.demo.sortgeek.domain.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateRequestDTO {
    private Long codeId;
    private Long parentId;  // 대댓글일 경우 부모 댓글 ID
    private String content;
}