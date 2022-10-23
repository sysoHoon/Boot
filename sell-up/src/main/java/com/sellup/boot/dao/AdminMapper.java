package com.sellup.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sellup.boot.dto.Admin;
import com.sellup.boot.dto.PageDto;

@Repository
@Mapper
public interface AdminMapper {
	List<Admin> selectALl(PageDto dto);
	List<Admin> getPagelist(PageDto dto);
	int getCount();
	Admin detail(int admin_board_id);
	int insert(Admin dto);
	int update(Admin dto);
	int searchCount(PageDto dto);
	List<Admin> searchList(PageDto dto);
}
