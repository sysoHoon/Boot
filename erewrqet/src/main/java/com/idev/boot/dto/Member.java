package com.idev.boot.dto;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
		private String id;
		private String pw;
		private int age;
		private String name;
		private String nickname;      
		private String birth;
		private String addr;
		private String gender;
		private String profile_file;
		private int cash;
		
		private MultipartFile pics;
}
