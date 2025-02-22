package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.SolvingCodeUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.SolvingCodeResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SolvingCodeServiceImpl implements SolvingCodeService{
    @Override
    public SolvingCodeResponseDTO executeSolvingCode(SolvingCodeUpdateRequestDTO solvingCodeUpdateRequestDTO) {

        return null;
    }

    @Override
    public Optional<SolvingCodeResponseDTO> findSolvingCode() {
        return Optional.empty();
    }

    @Override
    public Boolean togglePositiveSortOnly() {
        return null;
    }
}
