package com.demo.sortgeek.domain.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponseDTO {
    private Long likeId;
    private Long codeId;
    private Long memberId;
}