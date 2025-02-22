package com.demo.sortgeek.service;


import com.demo.sortgeek.DTOmapper.CustomTestCaseMapper;
import com.demo.sortgeek.domain.CustomTestCase;
import com.demo.sortgeek.domain.Member;
import com.demo.sortgeek.domain.dto.request.CustomTestCaseCreateRequestDTO;
import com.demo.sortgeek.domain.dto.request.CustomTestCaseUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.CustomTestCaseResponseDTO;
import com.demo.sortgeek.repository.CustomTestCaseRepository;
import com.demo.sortgeek.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.demo.sortgeek.DTOmapper.CustomTestCaseMapper.toCustomTestCaseResponseDTO;
import static com.demo.sortgeek.security.utils.SecurityUtil.getAuthenticatedMemberId;

@Service
@AllArgsConstructor
public class CustomTestCaseServiceImpl implements CustomTestCaseService {
    private final CustomTestCaseRepository customTestCaseRepository;
    private final MemberRepository memberRepository;

    @Override
    public CustomTestCaseResponseDTO createCustomTestCase(CustomTestCaseCreateRequestDTO customTestCaseRequestDTO) {
        Long memberId = getAuthenticatedMemberId();
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        CustomTestCase customTestCase = CustomTestCase.builder()
                .member(member)
                .build();

        customTestCase.setTestInput(customTestCaseRequestDTO.getTestInput()); // JSON 변환 후 저장

        customTestCaseRepository.save(customTestCase);

        return toCustomTestCaseResponseDTO(customTestCase);
    }

    @Override
    @Transactional
    public CustomTestCaseResponseDTO updateCustomTestCase(CustomTestCaseUpdateRequestDTO customTestCaseUpdateRequestDTO) {
        CustomTestCase customTestCase = customTestCaseRepository.findById(customTestCaseUpdateRequestDTO.getTestCaseId())
                .orElseThrow(() -> new EntityNotFoundException("테스트케이스를 찾을 수 없습니다."));

        customTestCase.setTestInput(customTestCaseUpdateRequestDTO.getTestInput());

        return toCustomTestCaseResponseDTO(customTestCase);
    }

    @Override
    public List<CustomTestCaseResponseDTO> findAllCustomTestCasesByMemberId() {
        Long memberId = getAuthenticatedMemberId();
        List<CustomTestCase> customTestCaseList = customTestCaseRepository.findByMemberMemberId(memberId);
        return customTestCaseList.isEmpty()
                ? Collections.emptyList()
                : customTestCaseList.stream()
                .map(CustomTestCaseMapper::toCustomTestCaseResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomTestCaseByTestCaseId(Long testCaseId) {
        customTestCaseRepository.findById(testCaseId)
                .orElseThrow(() -> new EntityNotFoundException("테스트케이스를 찾을 수 없습니다."));

        customTestCaseRepository.deleteById(testCaseId);
    }
}
