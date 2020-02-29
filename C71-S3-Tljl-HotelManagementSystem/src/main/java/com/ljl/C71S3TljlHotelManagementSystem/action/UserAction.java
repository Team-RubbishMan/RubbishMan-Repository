package com.ljl.C71S3TljlHotelManagementSystem.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAction {
	@GetMapping("front/signIn.html")
	public String SignIn() {
		return "front/signIn";
	}
}
