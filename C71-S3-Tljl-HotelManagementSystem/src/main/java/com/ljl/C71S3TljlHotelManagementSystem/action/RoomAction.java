package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Room;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomType;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.RoomBiz;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

@Controller
public class RoomAction {
	@Resource
	private RoomBiz roomBiz;

	/**
	 * @author 刘子源 加载房间管理网页
	 * @return 返回所需网页的路径 -- 房间管理
	 */
	@GetMapping("back/roommanagement.html")
	public String roomManagement(Model model) {
		// 取出房间信息
		List<Room> lstRoomInfo = roomBiz.loadRoomInfo();
		// 取出房间类别信息
		List<RoomType> lstRoomTypeInfo = roomBiz.loadRoomTypeInfo();
		// 将两个信息存入model 返回给ajax回调函数
		model.addAttribute("lstRoomInfo", lstRoomInfo);
		model.addAttribute("lstRoomTypeInfo", lstRoomTypeInfo);
		return "back/roommanagement";
	}
	@GetMapping("back/roompricemanagement.html")
	public String roomPriceManagement() {
		return "back/roompricemanagement";
	}
	
	@PostMapping("back/roomMaintenance")
	public Result roomMaintenance(int id) {
		try {
			System.out.println(id);
			roomBiz.roomMaintenance(id);
			return new Result(1,"操作成功",null);
		}catch(BizException e) {
			e.printStackTrace();
			return new Result(2,e.getMessage(),null);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"暂时无法进行操作，请稍后再试哦",null);
		}
	}
	

	@PostMapping("back/roomTypeUpdate")
	@ResponseBody
	public Result roomTypeManagement(RoomType roomType) {
		System.out.println(roomType);
		try {
			roomBiz.updateRoomTypeInfo(roomType);
			return new Result(1,"操作成功",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0,e.getMessage(),null);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0,"暂时无法进行操作，请稍后再试哦",null);
		}
	}
}
