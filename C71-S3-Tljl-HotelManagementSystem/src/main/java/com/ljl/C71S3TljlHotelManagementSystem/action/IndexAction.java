package com.ljl.C71S3TljlHotelManagementSystem.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ljl.C71S3TljlHotelManagementSystem.dao.RoomTypeMapper;

@Controller
public class IndexAction {
	@Resource
	private RoomTypeMapper roomTypeMapper;

	@GetMapping("front/index.html")
	public String GotoIndex(Model model) {
		model.addAttribute("roomType", roomTypeMapper.selectByExample(null));
		return "front/index";
	}
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
	@GetMapping("front/contact.html")
	public String GotoContact() {
		return "front/contact";
	}
	@GetMapping("front/map.html")
	public String GotoMap() {
		return "front/map";
	}
}
