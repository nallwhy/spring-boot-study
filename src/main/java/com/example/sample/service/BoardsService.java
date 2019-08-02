package com.example.sample.service;

import java.util.List;

import com.example.sample.boards.BoardDto;

public interface BoardsService {
  List<BoardDto> listBoards() throws Exception;
  BoardDto getBoard(long id) throws Exception;
  void createBoard(BoardDto board) throws Exception;
}