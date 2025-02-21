package com.demo.sortgeek.repository;

import com.demo.sortgeek.domain.CustomTestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomTestCaseRepository extends JpaRepository<CustomTestCase, Long> {
    List<CustomTestCase> findByMemberId(Long memberId); // 특정 유저가 만든 테스트케이스 조회
}
