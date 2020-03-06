package com.ljl.C71S3TljlHotelManagementSystem.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.biz.ReserveBiz;

@Controller
public class ReserveAction {
	@Resource
	ReserveBiz reserveBiz;
	@GetMapping("back/reservemanagement.html")
	public String reserveManangement() {
		return "back/reservemanagement";
	}
	@PostMapping("back/loadReserveInfoTable")
	@ResponseBody
	public PageInfo<Reserve> loadReserveInfoTable( @RequestParam(defaultValue = "5")int limit,@RequestParam(defaultValue = "1")int pageNumber) {
		PageInfo<Reserve> loadReserveInfo = reserveBiz.loadReserveInfo(limit,pageNumber);
		System.out.println(loadReserveInfo);
		return loadReserveInfo;
	}
	@PostMapping("back/loadReserveInfoById")
	@ResponseBody
	public Reserve loadReserveInfoById(int id) {
		Reserve loadReserveInfoById = reserveBiz.loadReserveInfoById(id);
		System.out.println(loadReserveInfoById);
		return loadReserveInfoById;
	}
}

