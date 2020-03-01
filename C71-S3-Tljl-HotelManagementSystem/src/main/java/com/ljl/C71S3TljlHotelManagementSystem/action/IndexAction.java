package com.ljl.C71S3TljlHotelManagementSystem.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexAction {
	
	@GetMapping("front/about.html")
	public String GotoAbout() {
		return "front/about";
	}
	@GetMapping("front/gallery.html")
	public String GotoGallery() {
		return "front/gallery";
	}
	@GetMapping("front/services.html")
	public String GotoServices() {
		return "front/services";
	}
}
