package com.sparta.week02_hw.service;

import com.sparta.week02_hw.models.Comment;
import com.sparta.week02_hw.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    // 게시글에 코멘트 등록
    public void addC(Comment comment) {
        commentRepository.save(comment);
    }

    // 게시글의 모든 코멘트 리스트
    public List<Comment> findAll(Long id) {
        return commentRepository.findAllById(id);
    }

    // 게시글 코멘트 삭제
    public void deleteC(Long commentId) {
        commentRepository.deleteById(commentId);
    }


}
