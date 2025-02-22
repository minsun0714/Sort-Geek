package com.demo.sortgeek.repository;

import com.demo.sortgeek.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginId(String loginId); // 유저 ID로 조회

    Boolean existsByLoginId(String loginId);

    Boolean deleteByLoginId(String loginId);
}
