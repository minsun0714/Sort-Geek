package com.demo.sortgeek.DTOmapper;

import com.demo.sortgeek.domain.CustomTestCase;
import com.demo.sortgeek.domain.dto.response.CustomTestCaseResponseDTO;

public class CustomTestCaseMapper {
    public static CustomTestCaseResponseDTO toCustomTestCaseResponseDTO(CustomTestCase customTestCase){
        return CustomTestCaseResponseDTO.builder()
                .testCaseId(customTestCase.getTestCaseId())
                .testInput(customTestCase.getTestInput())
                .build();
    }
}
