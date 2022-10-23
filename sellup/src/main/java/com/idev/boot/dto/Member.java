package com.idev.boot.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	
	private String id;
	private String pw;
	private String name;
	private int age;
	private String nickname;
	private String birth;
	private String addr;
	private String gender;
	private String profile_file;
	private int cash;
	private int authority;
	
	private List<MultipartFile> pics;
	
}