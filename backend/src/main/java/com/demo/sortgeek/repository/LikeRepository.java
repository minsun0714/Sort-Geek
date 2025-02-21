package com.demo.sortgeek.repository;

import com.demo.sortgeek.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByMemberIdAndRegisteredCodeId(Long memberId, Long registeredCodeId); // 유저가 특정 코드에 좋아요 눌렀는지 확인
}
