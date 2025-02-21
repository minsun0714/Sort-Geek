package com.demo.sortgeek.repository;

import com.demo.sortgeek.domain.SolvingCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolvingCodeRepository extends JpaRepository<SolvingCode, Long> {
    List<SolvingCode> findByMemberId(Long memberId); // 특정 유저가 제출한 코드 조회
}
