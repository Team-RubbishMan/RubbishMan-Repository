package com.ljl.C71S3TljlHotelManagementSystem.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Staff;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.StaffBiz;

@Controller
public class StaffAction {

	@Resource
	private StaffBiz staffBiz;

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

	@PostMapping("/back/dologin")
	public ModelAndView dologin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			// 获取staffBiz中已登录的职员信息
			Staff objStaff = staffBiz.loginStaff(username, password);
			System.out.println("objStaff" + objStaff);
			request.getSession().setAttribute("objStaff", objStaff);
		} catch (BizException e1) {
			e1.printStackTrace();
		}
		try {
			staffBiz.loginStaff(username, password);
			return new ModelAndView("redirect:/back/frame.html");
		} catch (BizException e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/back/login.html");
		}
	}
}
