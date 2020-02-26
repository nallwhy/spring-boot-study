package com.example.sample.controller.api;

import com.example.sample.boards.BoardDto;
import com.example.sample.service.BoardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "api/boardController")
@RequestMapping("/api/boards")
public class BoardController {
	private BoardsService boardsService;

	public BoardController(@Autowired BoardsService boardsService) {
		this.boardsService = boardsService;
	}

	@GetMapping("")
	public List<BoardDto> list() throws Exception {
		return boardsService.listBoards();
	}

	@GetMapping("/{id}")
	public BoardDto get(@PathVariable("id") long id) throws Exception {
		return boardsService.getBoard(id);
	}

	@PostMapping("")
	public void create(@RequestBody BoardDto boardDto) throws Exception {
		boardsService.createBoard(boardDto);
	}
}
