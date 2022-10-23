package com.idev.boot.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idev.boot.dao.ReportMapper;
import com.idev.boot.dto.Report;
import com.idev.boot.dto.SnsMember;
import com.idev.boot.dto.TimelineBoard;
import com.idev.boot.dto.Member;
import com.idev.boot.dto.PageDto;
import com.idev.boot.service.ReportService;


@Controller
@RequestMapping("/community")
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	private ReportMapper dao;
	public ReportController(ReportMapper dao) {
		this.dao = dao;
	}
	
	@Autowired
	private ReportService service;
	@RequestMapping(value="report", method = RequestMethod.POST)
	public String insert(String filename, Report dto, Model model, RedirectAttributes rdattr,@RequestParam(defaultValue = "1") int page) {
		dto.setFilename(filename);
		dao.insert(dto);
		rdattr.addFlashAttribute("alertm","신고가 접수되었습니다.");
		return "redirect:rlist";
	}
	
	@RequestMapping(value="rlist", method = RequestMethod.GET)
	public String insert(String id, PageDto param, Model model, HttpServletRequest request, HttpSession session) {
		session = request.getSession();		
		Member member = (Member)session.getAttribute("member");
		List<Report> list = dao.selectReport(member.getId());
		int totalCount; int pageSize=10;
		if(param==null) param=new PageDto();
		if(param.getPage()==0) param.setPage(1) ;
		
		
		PageDto pageDto;

		totalCount=service.searchCount(param);   
		pageDto=new PageDto(param.getPage(), pageSize, totalCount, param.getField(), param.getFindText());
		logger.info("pageDto : " + pageDto);
		Map<String,Object> map = new HashMap<String,Object>();    
		map.put("page", pageDto);			
		map.put("list",list);				
		model.addAllAttributes(map);
		return "community/rlist";
	}
	
	@RequestMapping("/rdetail")     
	public String detail(Report dto, int admin_board_id, String field, Model model) { 
	
		model.addAttribute("bean",dao.getOne(admin_board_id));
		model.addAttribute("cr","\n" );
		model.addAttribute("field",field);

		return "community/rdetail";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam Map<String,Object> param,Model model) {
		dao.rDelete(Integer.parseInt((String)param.get("admin_board_id")));
		//model.addAttribute("page", page);
		model.addAllAttributes(param);
		return "redirect:rlist";
	}
}
