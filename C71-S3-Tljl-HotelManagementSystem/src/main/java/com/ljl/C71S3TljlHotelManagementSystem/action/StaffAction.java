package com.ljl.C71S3TljlHotelManagementSystem.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Staff;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.StaffBiz;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

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
	@ResponseBody
	public Result dologin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		//清空session内容
		request.getSession().invalidate();
		try {
			// 获取staffBiz中已登录的职员信息
			Staff objStaff = staffBiz.loginStaff(username, password);
			System.out.println("objStaff" + objStaff);
			request.getSession().setAttribute("objStaff", objStaff);
			return new Result(1,"登录成功！",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2,e.getMessage(),username);
		}catch (Exception e) {
			return new Result(0,"系统繁忙，请稍后再试！",null);
		}
		
	}
}
