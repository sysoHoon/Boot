package com.sellup.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sellup.boot.dto.Admin;
import com.sellup.boot.dto.PageDto;
import com.sellup.boot.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService service;
	
	@RequestMapping(value= {"/","/list"})
	public String pageList(PageDto param, Model model) {
		List<Admin> list;
		int totalCount; int pageSize=10;
		if(param==null) param = new PageDto();
		if(param.getPage()==0) param.setPage(1);
		
		PageDto pageDto;
		
		totalCount = service.searchCount(param);
		pageDto = new PageDto(param.getPage(), pageSize, totalCount, param.getField(), param.getFindText());
		list = service.searchList(pageDto);
		logger.info("pageDto : " + pageDto);
		Map<String, Object> map = new HashMap<>();
		map.put("page", pageDto);
		map.put("list", list);
		model.addAttribute(map);
		
		return "admin/list";
	}
	
	@RequestMapping("/detail")     
	public String detail(int admin_board_id, int page,String field, String findText, Model model) {
		model.addAttribute("bean", service.getBoardOne(admin_board_id));
		model.addAttribute("field",field);
		model.addAttribute("findText",findText);
		
		return "admin/detail";
	}

	@RequestMapping(value="/insert")
	public void insert(@RequestParam(defaultValue = "1") int page,Model model) {
		
		model.addAttribute("page", page);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@ModelAttribute Admin admin) {   
		service.insert(admin);
		return "redirect:list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(@RequestParam Map<String, String> param,Model model) {
		model.addAttribute("bean", service.getBoardOne(Integer.parseInt(param.get("admin_board_id"))));
		model.addAllAttributes(param);
		logger.info(param.toString());			
	}
	
	//수정 내용 저장
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String save2(Admin admin, int idx, int page,String field,String findText,Model model) {
		service.update(admin);
		
		model.addAttribute("admin", admin.getAdmin_board_id());
		model.addAttribute("page", page);
		model.addAttribute("field",field);
		model.addAttribute("findText", findText);
		return "redirect:detail";   
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleErr(HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", request.getRequestURL());   //애트리뷰트 저장
		mav.setViewName("/error/error");
		return mav;
	}
}
