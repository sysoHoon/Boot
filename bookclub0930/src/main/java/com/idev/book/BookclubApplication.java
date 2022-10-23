package com.idev.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookclubApplication.class, args);
	}

}

// 실행 url:        http://localhost:8081/book/      입니다.
// 주의 application.properties 파일의 데이터베이스 username과 password 확인하세요.