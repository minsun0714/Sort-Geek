package com.demo.sortgeek.repository;

import com.demo.sortgeek.domain.RegisteredCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisteredCodeRepository extends JpaRepository<RegisteredCode, Long> {
    Page<RegisteredCode> findAll(Pageable pageable);

    Page<RegisteredCode> findByMemberId(Long memberId, Pageable pageable);
}
