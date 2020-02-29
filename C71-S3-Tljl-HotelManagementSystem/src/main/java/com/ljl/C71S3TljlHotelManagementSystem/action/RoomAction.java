package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
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
		//List<RoomType> lstRoomTypeInfo = roomBiz.loadRoomTypeInfo();
		// 将两个信息存入model 返回给ajax回调函数
		model.addAttribute("lstRoomInfo", lstRoomInfo);
		//model.addAttribute("lstRoomTypeInfo", lstRoomTypeInfo);
		return "back/roommanagement";
	}
	
	@GetMapping("back/roompricemanagement.html")
	public String roomPriceManagement(Model model) {
		model.addAttribute("lstRoomTypeInfo", roomBiz.loadRoomTypeInfo());
		return "back/roompricemanagement";
	}
	
	/**
	 * 加载表格数据
	 * @author Da
	 * @param limit 每页大小
	 * @param pageNumber 当前页数
	 * @return
	 */
	@ResponseBody
    @RequestMapping("back/loadRoomTypeInfo")
    public PageInfo<RoomType> getPage(@RequestParam(value = "limit", required = true) Integer limit,
                                      @RequestParam(value = "pageNumber", required = true) Integer pageNumber){
        return roomBiz.getPage(pageNumber,limit);
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
	
	/**
	 * 房型删除
	 * @author Da
	 * @param id id
	 * @return
	 */
	@PostMapping("back/roomTypeDelete")
	@ResponseBody
	public Result roomTypeDelete(Integer id) {
		try {
			roomBiz.deleteRoomTypeInfo(id);
			return new Result(1,"操作成功",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0,e.getMessage(),null);
		}
	}
	
	/**
	 * 房型删除
	 * @author Da
	 * @param id id数组
	 * @return
	 */
	@PostMapping("back/roomTypeDeletes")
	@ResponseBody
	public Result roomTypeDelete(@RequestParam String[] id) {
		try {
			roomBiz.deleteRoomTypeInfo(id);
			return new Result(1,"操作成功",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0,e.getMessage(),null);
		}
	}
	
	/**
	 * 房型更新
	 * @author Da
	 * @param roomType
	 * @return
	 */
	@PostMapping("back/roomTypeUpdate")
	@ResponseBody
	public Result roomTypeUpdate(RoomType roomType) {
		try {
			roomBiz.updateRoomTypeInfo(roomType);
			return new Result(1,"操作成功",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0,e.getMessage(),null);
		}
	}
	
	/**
	 * 检查房型是否存在
	 * @author Da
	 * @param typeName
	 * @return
	 * @throws BizException 
	 */
	@PostMapping("back/typeNameIsUsed")
	@ResponseBody
	public Result doRoomType(String typeName) throws BizException {
		try {
			if(roomBiz.selectTypeName(typeName)) {
				return new Result(1,"操作成功",null);
			}
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0,e.getMessage(),null);
		}
		return null;
	}
	
	/**
	 * 房型新增
	 * @author Da
	 * @param roomType
	 * @return
	 */
	@PostMapping("back/addRoomType")
	@ResponseBody
	public Result addRoomType(RoomType roomType) {
		try {
			roomBiz.addRoomType(roomType);
			return new Result(1,"操作成功",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(0,e.getMessage(),null);
		}
	}
	
}
