package com.sparta.week02_hw.repository;

import com.sparta.week02_hw.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 내림차순 정렬 코드
    List<Board> findAllByOrderByCreatedAtDesc();

    // id And password 로 검색
    Board findByIdAndPassword(Long id, String password);

}
