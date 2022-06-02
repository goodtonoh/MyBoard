package com.sparta.week02_hw.controller;

import com.sparta.week02_hw.models.Board;
import com.sparta.week02_hw.repository.BoardRepository;
import com.sparta.week02_hw.dto.BoardRequestDto;
import com.sparta.week02_hw.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    public final BoardService boardService;
    public final BoardRepository boardRepository;
    // CRUD
    // 생성
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {

        Board board = new Board(requestDto);
        return boardRepository.save(board);

        // return board;
    }

    // 조회
    @GetMapping("/api/boards")
    public List<Board> readBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    // 수정
    @PutMapping("api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }

    // 삭제
    @DeleteMapping("api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }


}
