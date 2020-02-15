package com.ljl.C71S3TljlHotelManagementSystem.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffAction {
	@GetMapping("/back/login.html")
	public String login() {
		return "back/login";
	}
	@GetMapping("/back/frame.html")
	public String frame() {
		return "back/frame";
	}
	@GetMapping("/back/signup.html")
	public String signup() {
		return "/back/signup";
	}
	//
	@PostMapping("/back/dologin")
	public ModelAndView dologin(@RequestParam("email")String name,@RequestParam("password")String password) {
		System.out.println("用户名："+name+"====");
		System.out.println("密码"+password+"----");
		return new ModelAndView("redirect:/back/frame.html");
	}
}
