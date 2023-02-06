package com.mong.mmbs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.entity.Board;
import com.mong.mmbs.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
public class BoardService {

    @Autowired BoardRepository boardRepository; // Auto wired로 스프링 빈에 등록

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }
    public Board findOne(Long boardId){
        return boardRepository.findById(boardId).orElseThrow(NullPointerException::new);
    }
    @Transactional
    public void create(Board board) {
        boardRepository.save(board);
    }

    @Transactional
    public void update(Long id, String title, String content){
        Board board = boardRepository.findById(id).orElseThrow(NullPointerException::new);
        board.setTitle(title);
        board.setContent(content);
    }
    @Transactional
    public void delete(Board board) {
        boardRepository.delete(board);
    }
}
