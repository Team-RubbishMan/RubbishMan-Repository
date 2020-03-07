package com.ljl.C71S3TljlHotelManagementSystem.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Bill;
import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Indent;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomType;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Staff;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BillBiz;
import com.ljl.C71S3TljlHotelManagementSystem.biz.CheckInDetailBiz;
import com.ljl.C71S3TljlHotelManagementSystem.biz.IndentBiz;
import com.ljl.C71S3TljlHotelManagementSystem.biz.UserBiz;
import com.ljl.C71S3TljlHotelManagementSystem.dao.BillMapper;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

@Controller
public class BillAction {
	
	@Resource
	private BillBiz billBiz;
	/**
	 * 打开查看账单页面
	 * @return
	 */
	@GetMapping("/back/billmanagement.html")
	public String bill() {
		return "back/billmanagement";
	}
	
	@RequestMapping("/back/loadBillInfo")
	@ResponseBody
	public PageInfo<Bill> loadBill(@RequestParam(defaultValue = "5") Integer limit,
			@RequestParam(defaultValue = "1") Integer pageNumber) {
		PageInfo<Bill> loadBillInfo = billBiz.loadBillInfo( pageNumber,limit);
		return loadBillInfo;
	}
}