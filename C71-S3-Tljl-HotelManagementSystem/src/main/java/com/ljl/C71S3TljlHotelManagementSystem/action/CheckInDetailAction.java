package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.EntertainmentDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Indent;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Room;
import com.ljl.C71S3TljlHotelManagementSystem.biz.CheckInDetailBiz;
import com.ljl.C71S3TljlHotelManagementSystem.utils.RandomUtil;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

@Controller
public class CheckInDetailAction {
	@Resource
	CheckInDetailBiz checkInDetailBiz;

	/**
	 * 办理入住
	 * 
	 * @author 刘子源
	 * @param reserveId
	 * @param userId
	 * @param username
	 * @param roomTypeId
	 * @param roomType
	 * @param numberOfRooms
	 * @param payAmount
	 * @return
	 */
	@PostMapping("back/checkIn")
	@ResponseBody
	public Result checkIn(int reserveId, int userId, String username, int roomTypeId, String roomType,
			int numberOfRooms, double payAmount) {
		try {
			RandomUtil objRandomUtil = new RandomUtil();
			// 建立一个空的Indent对象
			Indent objIndent = new Indent();
			// 通过reserveId 查询预定单
			Reserve objReserve = checkInDetailBiz.selectReserveById(reserveId);
			System.out.println(objReserve);
			// 给Indent 对象录入数据
			objIndent.setOrderNumber(objRandomUtil.getUniqueKey());
			objIndent.setUserId(userId);
			objIndent.setOrderTime(new Timestamp(System.currentTimeMillis()));
			objIndent.setConsumptionAmount(payAmount);
			objIndent.setStatus("1");
			objIndent.setConsumptionType("1");// temp1:记录消费的类型：1、住房 2、餐饮 3、娱乐
			objIndent.setConsumptionFigures(String.valueOf(objReserve.getConsumptionFigures()));// temp2:记录消费人数
			// 插入订单信息 并记录返回的主键
			int iIndentId = checkInDetailBiz.insertIndent(objIndent);
			// 查询当前用户需要预定的房型的空闲房间
			List<Room> lstRoomsIsFree = checkInDetailBiz.selectRoomsIsFree(roomTypeId);
			// 修改用户入住的房间的状态，使用一个数组记录房间的ID
			Room[] arrFreeRoom = new Room[numberOfRooms];
			Room objRoom;
			for (int i = 0; i < numberOfRooms; i++) {
				objRoom = lstRoomsIsFree.get(i);
				objRoom.setStatus("1");
				checkInDetailBiz.setRoomIsUsed(objRoom);
				arrFreeRoom[i] = objRoom;
			}
			for (Room room : arrFreeRoom) {
				// 插入入住详情 CheckInDetail
				CheckInDetail objCheckInDetail = new CheckInDetail();
				objCheckInDetail.setCheckInTime(objReserve.getReserveCheckInTime());
				objCheckInDetail.setCheckOutTime(objReserve.getReserveCheckOutTime());
				objCheckInDetail.setCheckInNumber(objReserve.getConsumptionFigures());
				objCheckInDetail.setRoomId(room.getId());
				objCheckInDetail.setOrderId(iIndentId);
				objCheckInDetail.setRoomTypeId(objReserve.getRoomTypeId());
				checkInDetailBiz.insertCheckInDetail(objCheckInDetail);
			}
			// 修改预定单的信息，将状态改成0 即完成状态
			checkInDetailBiz.setReserveStatus(objReserve.getId());
			return new Result(1, "房间办理成功", arrFreeRoom);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统繁忙，请稍后再试", null);
		}
	}

	/**
	 * 办理餐饮预订单
	 * 
	 * @author 刘子源
	 * @param reserveId
	 * @param userId
	 * @param username
	 * @param consumptionFigures
	 * @param payAmount
	 */
	@PostMapping("back/catering")
	@ResponseBody
	public Result catering(Integer reserveId, Integer userId, String username, Integer consumptionFigures,
			Double payAmount) {
		try {
			RandomUtil objRandomUtil = new RandomUtil();
			// 建立一个空的Indent对象
			Indent objIndent = new Indent();
			// 通过reserveId 查询预定单
			Reserve objReserve = checkInDetailBiz.selectReserveById(reserveId);
			// 给objIndent记录数据
			objIndent.setOrderNumber(objRandomUtil.getUniqueKey());
			objIndent.setUserId(userId);
			objIndent.setOrderTime(new Timestamp(System.currentTimeMillis()));
			objIndent.setConsumptionAmount(payAmount);
			objIndent.setStatus("1");
			objIndent.setConsumptionType("2");// temp1:记录消费的类型：1、住房 2、餐饮 3、娱乐
			objIndent.setConsumptionFigures(String.valueOf(objReserve.getConsumptionFigures()));// temp2:记录消费人数
			// 插入订单信息 并记录返回的主键
			int iIndentId = checkInDetailBiz.insertIndent(objIndent);
			FoodDetail objFoodDetail = new FoodDetail();
			objFoodDetail.setDiningTime(objReserve.getDinnerTime());
			objFoodDetail.setIndentId(iIndentId);
			checkInDetailBiz.insertFoodDetail(objFoodDetail);
			checkInDetailBiz.setReserveStatus(objReserve.getId());
			return new Result(1, "餐饮订单办理成功", objFoodDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统繁忙，请稍后再试", null);
		}
	}

	@PostMapping("back/processEntertainment")
	@ResponseBody
	public Result processEntertainment(Integer reserveId, Integer userId, String username, Integer entertainmentDeviceId,
			Double payAmount) {
		try {
			System.out.println("reserveId=" + reserveId);
			System.out.println("userId=" + userId);
			System.out.println("username=" + username);
			System.out.println("entertainmentDeviceId=" + entertainmentDeviceId);
			System.out.println("payAmount=" + payAmount);
			RandomUtil objRandomUtil = new RandomUtil();
			// 建立一个空的Indent对象
			Indent objIndent = new Indent();
			// 通过reserveId 查询预定单
			Reserve objReserve = checkInDetailBiz.selectReserveById(reserveId);
			// 给objIndent记录数据
			objIndent.setOrderNumber(objRandomUtil.getUniqueKey());
			objIndent.setUserId(userId);
			objIndent.setOrderTime(new Timestamp(System.currentTimeMillis()));
			objIndent.setConsumptionAmount(payAmount);
			objIndent.setStatus("1");
			objIndent.setConsumptionType("3");// temp1:记录消费的类型：1、住房 2、餐饮 3、娱乐
			objIndent.setConsumptionFigures("1");// temp2:记录消费人数
			// 插入订单信息 并记录返回的主键
			int iIndentId = checkInDetailBiz.insertIndent(objIndent);
			EntertainmentDetail objEntertainmentDetail = new EntertainmentDetail();
			objEntertainmentDetail.setEntertainmentDeviceId(objReserve.getNumberOfEntertaiment());
			objEntertainmentDetail.setIndentId(iIndentId);
			checkInDetailBiz.insertEntertainmentDetail(objEntertainmentDetail);
			checkInDetailBiz.setReserveStatus(objReserve.getId());
			return new Result(1, "娱乐订单办理成功", objEntertainmentDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0, "系统繁忙，请稍后再试", null);
		}
	}
}
