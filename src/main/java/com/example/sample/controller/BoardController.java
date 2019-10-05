package com.example.sample.controller;

import java.util.List;

import com.example.sample.boards.BoardDto;
import com.example.sample.service.BoardsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/boards")
public class BoardController {

  private BoardsService boardsService;

  public BoardController(@Autowired BoardsService boardsService) {
    this.boardsService = boardsService;
  }

  @GetMapping("")
  public ModelAndView index() throws Exception {
    log.debug("index called");

    ModelAndView mv = new ModelAndView("boards/index");

    List<BoardDto> list = boardsService.listBoards();
    mv.addObject("list", list);

    return mv;
  }

  @GetMapping("/{id}")
  public ModelAndView show(@PathVariable("id") long id) throws Exception {
    ModelAndView mv = new ModelAndView("boards/show");

    BoardDto board = boardsService.getBoard(id);
    mv.addObject("board", board);

    return mv;
  }

  @GetMapping("/new")
  public String newPage() {
    return "boards/new";
  }

  @PostMapping("")
  public String create(BoardDto board) throws Exception {
    boardsService.createBoard(board);

    return "redirect:/boards";
  }

}