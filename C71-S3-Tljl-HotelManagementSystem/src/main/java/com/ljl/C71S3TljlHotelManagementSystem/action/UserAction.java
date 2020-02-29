package com.ljl.C71S3TljlHotelManagementSystem.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAction {
	/**
	 * 打开，登录，注册，忘记密码页面
	 * @author 刘子源
	 * @return
	 */
	@GetMapping("front/signIn.html")
	public String SignIn() {
		return "front/signIn";
	}
}
