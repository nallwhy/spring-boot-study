package com.example.sample.boards.mapper;

import java.util.List;

import com.example.sample.boards.BoardDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
  List<BoardDto> list() throws Exception;
  void create(BoardDto board) throws Exception;
}
