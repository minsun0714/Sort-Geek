package com.demo.sortgeek.repository;

import com.demo.sortgeek.domain.Dislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DislikeRepository extends JpaRepository<Dislike, Long> {
    boolean existsByMemberMemberIdAndRegisteredCodeCodeId(Long memberId, Long codeId); // 유저가 특정 코드에 싫어요 눌렀는지 확인
}
