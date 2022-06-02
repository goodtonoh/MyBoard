package com.sparta.week02_hw.service;

import com.sparta.week02_hw.models.Board;
import com.sparta.week02_hw.repository.BoardRepository;
import com.sparta.week02_hw.dto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BoardService {

    // public final BoardService boardService;
    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {

//        Board board = boardRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
//        );

        // 입력된 비밀번호를 비교하여 동일할 때만 수정 및 업데이트
        Board board = boardRepository.findByIdAndPassword(id, requestDto.getPassword());
//         System.out.println(requestDto);
//         System.out.println(requestDto.getPassword());
        if (Objects.equals(requestDto, requestDto.getPassword())) {
            board.update(requestDto);
            return id;
        }
        else {
            boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
        );
        }
        board.update(requestDto);
        return id;
    }

    @Transactional
    public Long delete(Long id, BoardRequestDto requestDto) {

        // 입력된 비밀번호를 비교하여 동일할 때만 삭제 및 업데이트
        Board board = boardRepository.findByIdAndPassword(id, requestDto.getPassword());
        if (Objects.equals(requestDto, requestDto.getPassword())) {
            board.update(requestDto);
            return id;
        }
        else {
            boardRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("해당 id가 존재하지 않습니다.")
            );
        }
        board.update(requestDto);
        return id;
    }

}
