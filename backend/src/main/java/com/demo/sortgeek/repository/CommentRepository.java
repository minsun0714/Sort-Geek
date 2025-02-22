package com.demo.sortgeek.repository;

import com.demo.sortgeek.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRegisteredCodeCodeId(Long codeId); // 특정 코드에 달린 댓글 조회

    List<Comment> findByParentCommentCommentId(Long parentId); // 대댓글 조회
}
