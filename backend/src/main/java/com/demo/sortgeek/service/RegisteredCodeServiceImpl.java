package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.RegisteredCodeCreateRequestDTO;
import com.demo.sortgeek.domain.dto.response.RegisteredCodeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class RegisteredCodeServiceImpl implements RegisteredCodeService{
    @Override
    public RegisteredCodeResponseDTO createRegisteredCode(RegisteredCodeCreateRequestDTO registeredCodeCreateRequestDTO) {
        return null;
    }

    @Override
    public Page<RegisteredCodeResponseDTO> findAllRegisteredCodes() {
        return null;
    }

    @Override
    public RegisteredCodeResponseDTO approveRegisteredCode(Long codeId) {
        return null;
    }

    @Override
    public RegisteredCodeResponseDTO denyRegisteredCode(Long codeId) {
        return null;
    }

    @Override
    public Page<RegisteredCodeResponseDTO> findAllApprovedRegisteredCodes() {
        return null;
    }

    @Override
    public Page<RegisteredCodeResponseDTO> findAllRegisteredCodesByMemberId() {
        return null;
    }

    @Override
    public Boolean deleteRegisteredCode() {
        return null;
    }
}
