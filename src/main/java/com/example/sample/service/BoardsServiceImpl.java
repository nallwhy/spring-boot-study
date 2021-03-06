package com.example.sample.service;

import java.util.List;

import com.example.sample.boards.BoardDto;
import com.example.sample.boards.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardsServiceImpl implements BoardsService {

  private BoardMapper boardMapper;

  public BoardsServiceImpl(@Autowired BoardMapper boardMapper) {
    this.boardMapper = boardMapper;
  }

  @Override
  public List<BoardDto> listBoards() throws Exception {
    return boardMapper.list();
  }

  @Override
  public BoardDto getBoard(long id) throws Exception {
    boardMapper.updateHitCount(id);

    return boardMapper.get(id);
  }

  @Override
  public void createBoard(BoardDto board) throws Exception {
    boardMapper.create(board);
  }
}