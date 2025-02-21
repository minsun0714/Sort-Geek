package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.CommentCreateRequestDTO;
import com.demo.sortgeek.domain.dto.response.CommentResponseDTO;

import java.util.List;

public interface CommentService {
    CommentResponseDTO createComment(CommentCreateRequestDTO commentCreateRequestDTO);

    CommentResponseDTO updateComment(String newContent, Long codeId);

    List<CommentResponseDTO> findAllCommentsByCodeId(Long codeId);

    Boolean deleteCommentByCommentId(Long commentId);
}
