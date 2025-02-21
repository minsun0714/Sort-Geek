package com.demo.sortgeek.repository;

import com.demo.sortgeek.domain.RegisteredCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegisteredCodeRepository extends JpaRepository<RegisteredCode, Long> {
    List<RegisteredCode> findByMemberId(Long memberId); // 특정 유저가 등록한 코드 조회
}
