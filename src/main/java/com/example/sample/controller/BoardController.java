package com.example.sample.controller;

import java.util.List;

import com.example.sample.boards.BoardDto;
import com.example.sample.service.BoardsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
  @Autowired
  private BoardsService BoardsService;

  @RequestMapping("/boards")
  public ModelAndView index() throws Exception {
    ModelAndView mv = new ModelAndView("/boards/index");

    List<BoardDto> list = BoardsService.listBoards();
    mv.addObject("list", list);

    return mv;
  }
}