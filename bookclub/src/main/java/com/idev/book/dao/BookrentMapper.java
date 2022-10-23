package com.idev.book.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.idev.book.dto.BookDto;
import com.idev.book.dto.BookMember;
import com.idev.book.dto.BookRentDto;


@Mapper
public interface BookrentMapper {
	List<BookDto> selectBooks();
	List<BookRentDto> getRentList();
	int insertRent(BookRentDto dto);
	BookMember getMember(int i);
	BookDto getBook(String s);
	BookRentDto rentByBcode(BookRentDto dto);
	BookRentDto rentByMemidx(int i);
	int countRents();
	int updateDelays();
	String bcodes();
	

}
