package com.idev.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookMember {
	int mem_idx;
	String name;
	String email;
	String tel;
	String password;
}
