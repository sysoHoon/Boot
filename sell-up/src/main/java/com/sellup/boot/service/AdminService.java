package com.sellup.boot.service;

import java.util.List;

import com.sellup.boot.dto.Admin;
import com.sellup.boot.dto.PageDto;

public interface AdminService {
	List<Admin> selectAll(PageDto dto);
	List<Admin> getPagelist(PageDto dto);
	int getCount();
	Admin getBoardOne(int admin_board_id);
	int insert(Admin dto);
	int update(Admin dto);
	int searchCount(PageDto dto);
	List<Admin> searchList(PageDto dto);
}