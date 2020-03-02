package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Food;
import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodType;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Order;
import com.ljl.C71S3TljlHotelManagementSystem.biz.OrderBiz;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

@Controller
public class OrderAction {
	
	@Resource
	private OrderBiz orderBiz;
	
	@GetMapping("/back/ordermanagement.html")
	public String order() {
		return "back/ordermanagement";
	}
	
	@RequestMapping("/back/loadOrderInfo")
	@ResponseBody
	public PageInfo<Order> loadOrder(@RequestParam(defaultValue = "5") Integer limit,
			@RequestParam(defaultValue = "1") Integer pageNumber) {
		PageInfo<Order> loadOrderInfo = orderBiz.loadOrderInfo(1, 5);
		return loadOrderInfo;
	}

}
