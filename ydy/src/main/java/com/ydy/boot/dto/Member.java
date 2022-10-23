package com.ydy.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int mno;
	private String name;
	private String password;
	private String email;
	private String gender;
	private int age;
	private String hobby;
	private String addr;
}
