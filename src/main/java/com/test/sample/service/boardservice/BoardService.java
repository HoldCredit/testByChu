package com.test.sample.service.boardservice;

import com.test.sample.dto.boarddto.BoardInfoDto;
import com.test.sample.dto.boarddto.UpdateBoardDto;
import com.test.sample.dto.boarddto.postBoardDto;

import java.util.List;

public interface BoardService {

    // 게시판 목록 조회
    List<BoardInfoDto> findAllBoard();

    // 게시판 등록
    BoardInfoDto postBoard(postBoardDto dto);

    // 게시판 하나 조회
    BoardInfoDto findBoardOne(Long id);

    // 게시판 수정
    BoardInfoDto updateBoard(Long id, UpdateBoardDto dto);

    // 게시판 삭제
    void deleteBoard(Long id);

}
