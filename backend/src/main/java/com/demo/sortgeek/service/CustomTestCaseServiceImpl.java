package com.demo.sortgeek.service;


import com.demo.sortgeek.domain.dto.request.CustomTestCaseCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.CustomTestCaseUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.CustomTestCaseResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomTestCaseServiceImpl implements CustomTestCaseService {
    @Override
    public CustomTestCaseResponseDTO createCustomTestCase(CustomTestCaseCreateRequestDTO customTestCaseRequestDTO) {
        return null;
    }

    @Override
    public CustomTestCaseResponseDTO updateCustomTestCase(CustomTestCaseUpdateRequestDTO customTestCaseUpdateRequestDTO) {
        return null;
    }

    @Override
    public List<CustomTestCaseResponseDTO> findAllCustomTestCasesByMemberId() {
        return List.of();
    }

    @Override
    public Boolean deleteCustomTestCaseByTestCaseId(Long testCaseId) {
        return null;
    }
}
