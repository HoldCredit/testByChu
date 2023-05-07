package com.test.sample.controller;

import com.test.sample.dto.boarddto.BoardInfoDto;
import com.test.sample.dto.boarddto.UpdateBoardDto;
import com.test.sample.dto.boarddto.postBoardDto;
import com.test.sample.service.boardservice.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시판 목록 조회
    @GetMapping
    public ResponseEntity<List<BoardInfoDto>> findAllBoard() {
        List<BoardInfoDto> boards = boardService.findAllBoard();
        return new ResponseEntity<>(boards, OK);
    }

    // 게시판 등록
    @PostMapping
    public ResponseEntity<BoardInfoDto> postBoard(@RequestBody @Valid postBoardDto dto) {
        BoardInfoDto boardInfoDto = boardService.postBoard(dto);
        return new ResponseEntity<>(boardInfoDto, OK);
    }

    // 게시판 하나 조회 /board{id}
    @GetMapping("/{id}")
    public ResponseEntity<BoardInfoDto> findBoardOne(@PathVariable Long id) {
        BoardInfoDto boardInfoDto = boardService.findBoardOne(id);
        return new ResponseEntity<>(boardInfoDto, OK);
    }

    // 게시판 수정 /board/{id}
    @PostMapping("/{id}")
    public ResponseEntity<BoardInfoDto> updateBoard(@PathVariable Long id, @RequestBody @Valid UpdateBoardDto dto) {
        BoardInfoDto boardInfoDto = boardService.updateBoard(id, dto);
        return new ResponseEntity<>(boardInfoDto, OK);
    }

    // 게시판 삭제 /board/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
