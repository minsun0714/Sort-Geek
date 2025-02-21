package com.demo.sortgeek.domain.dto.request;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomTestCaseUpdateRequestDTO {
    private List<Long> testInput;
}
