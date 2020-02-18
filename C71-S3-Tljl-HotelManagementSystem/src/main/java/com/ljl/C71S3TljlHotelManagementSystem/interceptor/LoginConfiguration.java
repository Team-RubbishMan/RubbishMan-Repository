package com.ljl.C71S3TljlHotelManagementSystem.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 生成拦截器
		LoginInterceptor objLoginInterceptor = new LoginInterceptor();
		// 将拦截器注册
		InterceptorRegistration objLoginRegistry = registry.addInterceptor(objLoginInterceptor);
		// 添加拦截路径
		objLoginRegistry.addPathPatterns("/back/**.html");
		// 排除路径
		objLoginRegistry.excludePathPatterns("/back/login.html");
		objLoginRegistry.excludePathPatterns("/back/signup.html");
		objLoginRegistry.excludePathPatterns("/back/forgetpassword.html");
		
		
		// 排除资源请求
		//objLoginRegistry.excludePathPatterns("/back/**");

		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
