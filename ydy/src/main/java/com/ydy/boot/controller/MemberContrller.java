package com.ydy.boot.controller;

import java.util.List;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ydy.boot.dao.MemberMapper;
import com.ydy.boot.dto.Member;

@Controller
@RequestMapping(value = "member/")
@SessionAttributes({"member"})
public class MemberContrller {
	private static final Logger logger = LoggerFactory.getLogger(MemberContrller.class);
	
	private MemberMapper dao;
	
	public MemberContrller(MemberMapper dao) {
		this.dao = dao;
	}

	// 회원가입
	@GetMapping("join.do")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("join.do")
	public String join(Member member, RedirectAttributes rttr) {
		logger.info("회원가입 정보 : {}", member);
		if(dao.addMember(member)==1)
			rttr.addFlashAttribute("alterm","회원가입이 완료 되었습니다.");
		else
			rttr.addFlashAttribute("alterm","회원가입에 문제가 있습니다.");
		return "redirect:/";
	}
	
	// 회원목록
	@GetMapping("list.do")
	public String list(Model model) {
		List<Member> list = dao.selectAll();
		model.addAttribute("list",list);
		return "member/list";
	}
	
	// 회원정보 수정
	@GetMapping("update.do")
	public String update() {
		return "memeber/update";
	}
	
	@PostMapping("save.do")
	public String save(Member member, Model model, RedirectAttributes rttr) {
		if(dao.updateMember(member)==1)
			rttr.addFlashAttribute("alterm","회원정보 수정이 완료 되었습니다.");
		model.addAttribute("member",member);
		return "redirect:update.do";
	}
	
	@GetMapping("idCheck.do")
	public String idCheck(String email, Model model) {
		logger.info("중복 확인 이메일 : {}", email);
		String msg;
		if(dao.checkEmail(email)==0)
			msg = "사용 가능한 이메일입니다.";
		else
			msg = "이미 사용중인 이메일입니다.";
		model.addAttribute("msg",msg);
		model.addAttribute("email",email);
		return "member/idCheck";
	}
	
	@GetMapping("passw.do")
	public String passw() {
		return "member/passw";
	}
	
	@PostMapping("passw.do")
	public String changePassw(@RequestParam Map<String, String> map, RedirectAttributes rttr) {
		logger.info("비밀번호 변경 파라미터 : {}", map);
		if(dao.changePassw(map)==1)
			logger.info("비밀번호 변경 완료");
		else
			logger.info("현재 비밀번호와 다릅니다.");
		return "redirect:update.do";
	}
}