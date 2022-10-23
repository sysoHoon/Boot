package com.idev.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idev.boot.dao.MemberMapper;
import com.idev.boot.dto.Member;

@Controller
public class ProfileController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private MemberMapper dao;
	public ProfileController(MemberMapper dao) {
		this.dao = dao;
	}
	

}
