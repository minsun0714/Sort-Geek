package com.demo.sortgeek.domain.dto.response;

import java.util.List;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomTestCaseResponseDTO {
    private Long testCaseId;  // 테스트 케이스 ID
    private List<Integer> testInput;  // 테스트 입력 데이터
}
