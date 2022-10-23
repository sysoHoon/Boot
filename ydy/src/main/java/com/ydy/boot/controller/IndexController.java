package com.ydy.boot.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ydy.boot.dao.MemberMapper;
import com.ydy.boot.dto.Member;

@Controller
@SessionAttributes({"member"})
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private MemberMapper dao;
	
	public IndexController(MemberMapper dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value ="ajax")
	public String ajax() {
		return "member/ajaxTest";
	}
	
	@GetMapping("login.do")
	public String login() {
		return "login";
	}
	
	@PostMapping("login.do")
	public String loginProc(Member member, @RequestParam Map<String, String> map, RedirectAttributes rttr, Model model) {
		logger.info("[My]" + map);
		String url;
		if(dao.login(map) != null) {
			model.addAttribute("member", member);
			rttr.addFlashAttribute("alertm","로그인 성공");
			url = "/";
		}else {
			rttr.addFlashAttribute("alertm","로그인 정보를 확인하세요.");
			url = "login.do";
		}
		return "redirect:" + url;
	}
	
	@GetMapping("logout.do")
	public String logout(SessionStatus status	) {
		status.setComplete();
		return "redirect:/";
	}
}
