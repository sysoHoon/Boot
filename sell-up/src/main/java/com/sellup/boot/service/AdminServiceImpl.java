package com.sellup.boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sellup.boot.dao.AdminMapper;
import com.sellup.boot.dto.Admin;
import com.sellup.boot.dto.PageDto;

@Service
public class AdminServiceImpl implements AdminService {
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminMapper dao;
	
	
	@Override
	public List<Admin> selectAll(PageDto dto){
		return dao.selectALl(dto);
	}
	
	@Override
	public int insert(Admin dto) {
		logger.info("insert..........");
		return dao.insert(dto);
	}
	
	@Override
	public Admin getBoardOne(int admin_board_id) {
		return dao.detail(admin_board_id);
	}
	
	@Override
	public int getCount() {
		return dao.getCount();
	}
	
	@Override
	public List<Admin> getPagelist(PageDto dto){
		return dao.getPagelist(dto);
	}
	
	@Override
	public int update(Admin dto) {
		return dao.update(dto);
	}
	
	@Override
	public int searchCount(PageDto dto) {
		return dao.searchCount(dto);
	}
	
	@Override
	public List<Admin> searchList(PageDto dto) {
		return dao.searchList(dto);
	}
	
}
