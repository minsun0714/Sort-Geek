package com.demo.sortgeek.domain.dto.request;

import com.demo.sortgeek.domain.enums.LANGUAGE;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolvingCodeCreateRequestDTO {
    private String code;
    private LANGUAGE language;
}