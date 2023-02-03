package com.mong.mmbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.dto.BoardDeleteDto;
import com.mong.mmbs.dto.BoardDto;
import com.mong.mmbs.entity.Board;
import com.mong.mmbs.service.BoardService;

import lombok.RequiredArgsConstructor;


@RestController
public class BoardController {

    @Autowired BoardService boardService;

    @GetMapping("/api/board-list")
    public WrapperClass board_list(){
        List<Board> boardList = boardService.findBoards();
        List<BoardDto> boardDtoList = boardList.stream().map(b -> new BoardDto(b)).collect(Collectors.toList());
        return new WrapperClass(boardDtoList);
    }
    @GetMapping("/api/board-detail/{boardId}")
    public WrapperClass board_detail(@PathVariable("boardId") Long boardId){
        Board board = boardService.findOne(boardId);
        BoardDto boardDto = new BoardDto(board);
        return new WrapperClass(boardDto);
    }
    @PostMapping("/api/create-board")
    public ResponseEntity create_board(@RequestBody BoardDto boardDto){
        System.out.println("create_board/boardDto = " + boardDto);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED; // 201 잘 생성되었음을 의미
        try{
            Board board = new Board(
                    boardDto.getId(),
                    boardDto.getTitle(),
                    boardDto.getContent()
            );
            boardService.create(board);
        } catch (Exception exception){
            status = HttpStatus.BAD_REQUEST; // 400 에러
            System.out.println("create_board/exception = " + exception);
        }
        return new ResponseEntity(body, headers, status);
    }

    @PutMapping("/api/update-board")
    public ResponseEntity update_board(@RequestBody BoardDto boardDto){
        System.out.println("update_board/boardDto = " + boardDto);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.NO_CONTENT; // 204 -> 수정이 정상적으로 완료됬음을 의미
        try{
            boardService.update(boardDto.getId(), boardDto.getTitle(), boardDto.getContent());
        } catch (Exception exception){
            status = HttpStatus.BAD_REQUEST; // 400 에러
            System.out.println("update_board/exception = " + exception);
        }
        return new ResponseEntity(body, headers, status);
    }

    @DeleteMapping("/api/delete-board")
    public ResponseEntity delete_board(@RequestBody BoardDeleteDto boardDeleteDto){
        System.out.println("delete_board/boardDeleteDto = " + boardDeleteDto);
        HttpHeaders headers = new HttpHeaders();
        Map<String, String> body = new HashMap<>();
        HttpStatus status = HttpStatus.NO_CONTENT; // 204
        try{
            Board board = boardService.findOne(boardDeleteDto.getId());
            boardService.delete(board);
        } catch (Exception exception){
            status = HttpStatus.BAD_REQUEST;
            System.out.println("delete_board/exception = " + exception);
        }
        return new ResponseEntity(body, headers, status);
    }
}

