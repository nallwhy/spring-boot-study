package com.example.sample.service;

import java.util.List;

import com.example.sample.boards.BoardDto;
import com.example.sample.boards.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardsServiceImpl implements BoardsService {
  @Autowired
  private BoardMapper boardMapper;

  @Override
  public List<BoardDto> listBoards() throws Exception {
    return boardMapper.listBoards();
  }

  @Override
  public void createBoard(BoardDto board) throws Exception {
    boardMapper.createBoard(board);
  } 
}