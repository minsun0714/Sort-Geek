package com.demo.sortgeek.service;

import com.demo.sortgeek.domain.dto.request.CommentCreateRequestDTO;
import com.demo.sortgeek.domain.dto.response.CommentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Override
    public CommentResponseDTO createComment(CommentCreateRequestDTO commentCreateRequestDTO) {
        return null;
    }

    @Override
    public CommentResponseDTO updateComment(String newContent, Long codeId) {
        return null;
    }

    @Override
    public List<CommentResponseDTO> findAllCommentsByCodeId(Long codeId) {
        return List.of();
    }

    @Override
    public Boolean deleteCommentByCommentId(Long commentId) {
        return null;
    }
}
