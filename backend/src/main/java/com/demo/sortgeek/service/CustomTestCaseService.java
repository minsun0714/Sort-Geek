package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.CustomTestCaseCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.CustomTestCaseUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.CustomTestCaseResponseDTO;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface CustomTestCaseService {
    CustomTestCaseResponseDTO createCustomTestCase(CustomTestCaseCreateRequestDTO customTestCaseRequestDTO);

    CustomTestCaseResponseDTO updateCustomTestCase(CustomTestCaseUpdateRequestDTO customTestCaseUpdateRequestDTO) throws AccessDeniedException;

    List<CustomTestCaseResponseDTO> findAllCustomTestCasesByMemberId();

    void deleteCustomTestCaseByTestCaseId(Long testCaseId);
}
