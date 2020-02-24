package com.ljl.C71S3TljlHotelManagementSystem.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodAction {
	@GetMapping("back/foodmanagement.html")
	public String foodManagement() {
		return "back/foodmanagement.html";
	}
}
