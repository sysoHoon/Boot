package com.idev.boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.idev.boot.interceptor.LoginInterceptor;
import com.idev.boot.interceptor.UserInterceptor;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
	private String urlPath="/uploads/**";
	private String location = "file:///Users/parksanghoon/Desktop/psh_std/upload/";   //반드시 경로 마지막 /필요함
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(urlPath)
				.addResourceLocations(location);
	}
	
	@Override		// 인터셉터 동작 추가
	public void addInterceptors(InterceptorRegistry registry) {
		// 적용할 url 패턴
		List<String> patterns= Arrays.asList("/community/*","/member/*","/admin/*");		// community, member로 시작하는 url에 인터셉터를 적용함
		// 인터셉터 제외 url 목록
		List<String> excludes=Arrays.asList("/community/list","/member/join","/member/list","header","/community/rdetail",
				"/community/delete","/community/rlist","/member/register","/member/auth","/member/registerer","/admin/lock","/admin/open");
		registry.addInterceptor(new LoginInterceptor())		// 인터셉터 적용
		.addPathPatterns(patterns).excludePathPatterns(excludes);
		// 적용할 패턴						제외할 패턴
		
		registry.addInterceptor(new UserInterceptor())		// UserInterceptor 적용
		.addPathPatterns(Arrays.asList("/member/join"));
	}
	
}
