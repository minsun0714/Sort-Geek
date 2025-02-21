package com.demo.sortgeek.domain.dto.response;

import com.demo.sortgeek.domain.enums.LANGUAGE;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolvingCodeResponseDTO {
    private Long solvingCodeId;
    private String code;
    private LANGUAGE language;
    private Boolean isPositiveSortingOnly;
    private LocalDateTime createdAt;
}
