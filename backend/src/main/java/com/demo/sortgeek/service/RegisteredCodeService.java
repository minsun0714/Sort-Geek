package com.demo.sortgeek.service;


import com.demo.sortgeek.domain.dto.request.RegisteredCodeCreateRequestDTO;
import com.demo.sortgeek.domain.dto.response.RegisteredCodeResponseDTO;
import org.springframework.data.domain.Page;

public interface RegisteredCodeService {
    RegisteredCodeResponseDTO createRegisteredCode(RegisteredCodeCreateRequestDTO registeredCodeCreateRequestDTO);

    // 관리자 페이지에서 사용
    Page<RegisteredCodeResponseDTO> findAllRegisteredCodes();

    RegisteredCodeResponseDTO approveRegisteredCode(Long codeId);

    RegisteredCodeResponseDTO denyRegisteredCode(Long codeId);

    // 전체 게시물 페이지에서 사용
    Page<RegisteredCodeResponseDTO> findAllApprovedRegisteredCodes();

    Page<RegisteredCodeResponseDTO> findAllRegisteredCodesByMemberId();

    Boolean deleteRegisteredCode();
}
