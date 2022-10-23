package com.idev.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idev.book.dto.BookRentDto;
import com.idev.book.mapper.BookrentMapper;


@Controller
@RequestMapping("book/")
public class BookClubController {
	private static final Logger logger = LoggerFactory.getLogger(BookClubController.class);
	private final BookrentMapper mapper;
	
	public BookClubController(BookrentMapper mapper) {
		this.mapper=mapper;
	}
	
	//홈
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	//전체 도서 목록조회 화면으로
	@RequestMapping("list")
	public String list(Model model) {
		logger.info(mapper.selectBooks().toString());
		model.addAttribute("list",mapper.selectBooks());
		return "book/bookList";
	}

	
	@RequestMapping("rent")
	public String rent(Model model) {
		model.addAttribute("bclist",mapper.bcodes());
		return "book/bookRent";
	}	

		
	
}
