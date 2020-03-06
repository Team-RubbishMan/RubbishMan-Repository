package com.ljl.C71S3TljlHotelManagementSystem.action;


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
public class IndentAction {
	
	@Resource
	private IndentBiz indentBiz;
	
	@Resource
	private BillBiz billbiz;
	
	@Resource
	private CheckInDetailBiz checkInDetailBiz;
	
	@Resource
	private UserBiz userBiz;
	
	//创建对象
	private Bill bill;
	/**
	 * 打开订单管理页面
	 * @return
	 */
	@GetMapping("/back/ordermanagement.html")
	public String order() {
		return "back/ordermanagement";
	}
	/**
	 * 加载所有订单详情
	 * @param limit
	 * @param pageNumber
	 * @return
	 */
	@RequestMapping("/back/loadOrderInfo")
	@ResponseBody
	public PageInfo<Indent> loadOrder(@RequestParam(defaultValue = "5") Integer limit,
			@RequestParam(defaultValue = "1") Integer pageNumber) {
		PageInfo<Indent> loadOrderInfo = indentBiz.loadOrderInfo( pageNumber,limit);
		return loadOrderInfo;
	}
	/**
	 * 加载子表详情
	 * @param indentId   订单号
	 * @return
	 */
	@PostMapping("back/loadCheckInDetailInfoByIndentId")
	@ResponseBody
	public List<CheckInDetail> loadCheckInDetailInfoByIndentId(
			@RequestParam("indentId")Integer indentId ) {
		return indentBiz.selectCheckInDetailInfoByIndentId(indentId);
	}
	/**
	 * 查询获取账单详细信息
	 * @param indentId 订单号
	 * @param request   
	 * @param response
	 * @return
	 */
	@RequestMapping("/back/checkAccount")
	@ResponseBody
	public Result checkAccount(Integer indentId,HttpServletRequest request, HttpServletResponse response) {
		System.out.println("indentId+++==+++++++"+indentId);
		
		//获取的该行信息
		Indent objIndent=indentBiz.selectAll(indentId);
		List<CheckInDetail> lstDetail=indentBiz.selectCheckInDetailInfoByIndentId(indentId);
		//获取入住总天数
		int totalDays=indentBiz.calculateTime(lstDetail);
		int roomTypeId=lstDetail.get(0).getRoomTypeId();
		RoomType objRoomType = indentBiz.selectRoomType(roomTypeId);
		Double deposit = objRoomType.getDeposit();
		Double amount = objRoomType.getAmount();
		//获取订单中房间数
		int roomNumber = lstDetail.size();
		//住房应付金额
		Double totalAmountRoom = totalDays*roomNumber*amount;
		//已付定金
		Double totalDeposit = roomNumber*deposit;
		//结算后退款或再付
		Double refundOrPay =totalAmountRoom -objIndent.getConsumptionAmount();
		//获取登录职员的id
		Staff objStaff=(Staff) request.getSession().getAttribute("objStaff");
		Integer iStaffId = objStaff.getId();
		//获取当前时间
		Date objDate = new Date();
		bill=new Bill();
		if(objIndent.getConsumptionType().equals("1")) {
			bill.setRecordTime(objDate);
			bill.setStaffId(iStaffId);
			bill.setUserId(objIndent.getUserId());
			bill.setConsumptionAmount(totalAmountRoom);
			bill.setIndentId(objIndent.getId());
			bill.setReceivedAmount(objIndent.getConsumptionAmount());
			bill.setRefundOrSupplement(refundOrPay);
			bill.setUser(objIndent.getUser());
			return new Result(1,"修改成功！",bill);
		}else {
			bill.setRecordTime(objDate);
			bill.setStaffId(iStaffId);
			bill.setUserId(objIndent.getUserId());
			System.out.println("userId+=+++++++"+objIndent.getUserId());
			bill.setConsumptionAmount(objIndent.getConsumptionAmount());
			bill.setIndentId(objIndent.getId());
			bill.setReceivedAmount(objIndent.getConsumptionAmount());
			bill.setRefundOrSupplement(0.0);
			bill.setUser(objIndent.getUser());
			System.out.println("user====="+objIndent.getUser());
			return new Result(1,"修改成功!",bill);
		}
		
	}
	/**
	 * 账单插入以及修改订单状态
	 * @return
	 */
	@RequestMapping("/back/settleAccount")
	@ResponseBody
	public Result settleAccount() {
		try {
			//插入订单
			int iBillId=billbiz.insertBill(bill);
			System.out.println("indentId++++++"+billbiz.selectBillById(iBillId).getIndentId());
			//修改订单状态
			indentBiz.updateStatus(billbiz.selectBillById(iBillId).getIndentId());
			return new Result(1,"该账单结算完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0,"系统繁忙，请稍后再试！");
		}
		
	}

}
