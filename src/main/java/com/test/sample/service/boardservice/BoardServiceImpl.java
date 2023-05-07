package com.test.sample.service.boardservice;

import com.test.sample.domain.Board;
import com.test.sample.dto.boarddto.BoardInfoDto;
import com.test.sample.dto.boarddto.UpdateBoardDto;
import com.test.sample.dto.boarddto.postBoardDto;
import com.test.sample.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    // 게시판 목록 조회
    @Override
    public List<BoardInfoDto> findAllBoard() {
        List<Board> boards = boardRepository.findAll();
        List<BoardInfoDto> boardInfoDtos = boards.stream()
                .map(board -> new BoardInfoDto(
                        board.getId(), board.getTitle(), board.getContent(), board.getUser(), board.getLastModifiedDate()))
                .collect(Collectors.toList());
        return boardInfoDtos;
    }

    // 게시판 등록
    @Override
    @Transactional
    public BoardInfoDto postBoard(postBoardDto dto) {
        Board board = new Board(dto.getTitle(), dto.getContent(), dto.getUser());
        boardRepository.save(board);
        return new BoardInfoDto(board.getId(),board.getTitle(),board.getTitle(),board.getUser(),board.getLastModifiedDate());
    }

    // 게시판 하나 조회
    @Override
    public BoardInfoDto findBoardOne(Long id) {
        Board board = boardRepository.findById(id).get();
        return new BoardInfoDto(board.getId(), board.getTitle(), board.getTitle(), board.getUser(), board.getLastModifiedDate());
    }

    // 게시판 수정
    @Override
    @Transactional
    public BoardInfoDto updateBoard(Long id, UpdateBoardDto dto) {
        Board board = boardRepository.findById(id).get();
        board.updateBoard(dto);
        return new BoardInfoDto(board.getId(), board.getTitle(), board.getTitle(), board.getUser(), board.getLastModifiedDate());
    }

    // 게시판 삭제
    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
