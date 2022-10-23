package com.ydy.boot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ydy.boot.dto.Member;

@Mapper
public interface MemberMapper {
	List<Member> selectAll();
	Member getOne(int mno);
	Member login(Map<String, String> map);
	int changePassw(Map<String, String> map);
	int checkEmail(String email);
	int addMember(Member member);
	int updateMember(Member member);
	int delete(int mno);
}
