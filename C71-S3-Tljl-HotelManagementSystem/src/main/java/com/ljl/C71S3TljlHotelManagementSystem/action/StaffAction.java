package com.ljl.C71S3TljlHotelManagementSystem.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffAction {
	@GetMapping("/back/login.html")
	public String login() {
		return "back/login";
	}
}
