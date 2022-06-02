package com.sparta.week02_hw.repository;

import com.sparta.week02_hw.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllById(@Param("id") Long id);

    Comment findAll(Long commentId);


}
