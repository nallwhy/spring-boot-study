package com.example.sample.controller;

import java.util.List;

import com.example.sample.boards.BoardDto;
import com.example.sample.service.BoardsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/boards")
public class BoardController {
  @Autowired
  private BoardsService boardsService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ModelAndView index() throws Exception {
    ModelAndView mv = new ModelAndView("/boards/index");

    List<BoardDto> list = boardsService.listBoards();
    mv.addObject("list", list);

    return mv;
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String new_page() throws Exception {
    return "/boards/new";
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public String create(BoardDto board) throws Exception {
    boardsService.createBoard(board);

    return "redirect:/boards";
  }

}