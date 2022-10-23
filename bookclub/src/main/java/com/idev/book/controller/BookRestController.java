package com.idev.book.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idev.book.dto.BookDto;
import com.idev.book.dto.BookMember;
import com.idev.book.dto.BookRentDto;
import com.idev.book.dao.BookrentMapper;

@RestController
public class BookRestController {
	private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);
	
	private BookrentMapper mapper;
	public BookRestController(BookrentMapper mapper) {
		this.mapper=mapper;
	}
	
	@ResponseBody
	@RequestMapping(value="/bookrent/{mem_idx}",method=RequestMethod.GET
			,produces = "application/json;charset=utf-8")
	public String bookrent(@PathVariable int mem_idx) throws JsonProcessingException {
		int result=0;
		

		BookMember member = mapper.getMember(mem_idx);
		BookRentDto vo = mapper.rentByMemidx(mem_idx);
		// 회원여부 확인 : 회원이 아니면 -1    
		if(member == null) result=-1;
		else if(vo==null) result=1;      // 회원의 도서 대여 여부 확인 : 대여중이 아니면 1
		
		//문제 : 완성하기
		ObjectMapper objmapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		result = mapper.insertRent(vo);
		map.put("result", result);
		
		
//		try {
//			json_result = objmapper.writeValueAsString(map);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return objmapper.writeValueAsString(map);
	}
}
