package com.idev.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.idev.book.dto.BookDto;
import com.idev.book.dto.BookMember;
import com.idev.book.dto.BookRentDto;

@Mapper
public interface BookrentMapper {
//	전체 도서 목록을 조회
	List<BookDto> selectBooks();
	List<String> bcodes();
}
