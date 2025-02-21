package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.SolvingCodeUpdateRequestDTO;
import com.demo.sortgeek.domain.dto.response.SolvingCodeResponseDTO;

import java.util.Optional;

public interface SolvingCodeService {
    SolvingCodeResponseDTO executeSolvingCode(SolvingCodeUpdateRequestDTO solvingCodeUpdateRequestDTO);

    Optional<SolvingCodeResponseDTO> findSolvingCode();

    Boolean togglePositiveSortOnly();
}