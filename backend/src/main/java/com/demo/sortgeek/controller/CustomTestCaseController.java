package com.demo.sortgeek.controller;

import com.demo.sortgeek.domain.dto.request.CustomTestCaseCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.CustomTestCaseUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.CustomTestCaseResponseDTO;
import com.demo.sortgeek.service.CustomTestCaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/api/testcase")
@AllArgsConstructor
public class CustomTestCaseController {

    private final CustomTestCaseService customTestCaseService;

    @PostMapping
    public ResponseEntity<CustomTestCaseResponseDTO> postTestCase(@RequestBody CustomTestCaseCreateRequestDTO customTestCaseCreateRequestDTO) {
        CustomTestCaseResponseDTO createdCustomTestCase = customTestCaseService.createCustomTestCase(customTestCaseCreateRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomTestCase);
    }

    @GetMapping
    public ResponseEntity<List<CustomTestCaseResponseDTO>> getTestCase(){

        List<CustomTestCaseResponseDTO> createdCustomTestCase = customTestCaseService.findAllCustomTestCasesByMemberId();

        return ResponseEntity.status(HttpStatus.OK).body(createdCustomTestCase);
    }

    @PutMapping
    public ResponseEntity<CustomTestCaseResponseDTO> updateTestCase(@RequestBody CustomTestCaseUpdateRequestDTO customTestCaseUpdateRequestDTO) {
        CustomTestCaseResponseDTO updatedUser = null;
        try {
            updatedUser = customTestCaseService.updateCustomTestCase(customTestCaseUpdateRequestDTO);
        } catch (AccessDeniedException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/{testCaseId}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long testCaseId){
        customTestCaseService.deleteCustomTestCaseByTestCaseId(testCaseId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
