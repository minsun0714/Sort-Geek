package com.demo.sortgeek.domain.dto.request;

import com.demo.sortgeek.domain.enums.LANGUAGE;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolvingCodeUpdateRequestDTO {
    private String code; // 실행할 코드
    private LANGUAGE language; // 사용 언어
    private Boolean isPositiveSortingOnly; // 양수 정렬 제한 여부
}
