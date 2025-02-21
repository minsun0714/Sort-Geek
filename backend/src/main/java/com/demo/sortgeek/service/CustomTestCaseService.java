package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.CustomTestCaseCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.CustomTestCaseUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.CustomTestCaseResponseDTO;

import java.util.List;

public interface CustomTestCaseService {
    CustomTestCaseResponseDTO createCustomTestCase(CustomTestCaseCreateRequestDTO customTestCaseRequestDTO);

    CustomTestCaseResponseDTO updateCustomTestCase(CustomTestCaseUpdateRequestDTO customTestCaseUpdateRequestDTO);

    List<CustomTestCaseResponseDTO> findAllCustomTestCasesByMemberId();

    Boolean deleteCustomTestCaseByTestCaseId(Long testCaseId);
}
