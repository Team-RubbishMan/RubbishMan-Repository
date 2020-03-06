package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.text.ParseException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.OrderForm;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.dao.EntertainmentDeviceMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.RoomTypeMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.DateUtil;
import com.ljl.C71S3TljlHotelManagementSystem.utils.RandomUtil;

@Service
public class ToReserveBiz {

	@Resource
	private RoomTypeMapper roomTypeMapper;
	@Resource
	private EntertainmentDeviceMapper entertainmentDeviceMapper;
	
	private DateUtil dateUtil = new DateUtil();
	private RandomUtil randomUtil = new RandomUtil();
	
	/**
	 * 房间预定转Reserve
	 * @author Da
	 * @param orderForm
	 * @return
	 * @throws ParseException
	 */
	public Reserve ToReserve(OrderForm orderForm) throws ParseException {
		double amountDouble = (double) roomTypeMapper.selectMoney(orderForm.getRoomTypeId());
		String uniqueKey = randomUtil.getUniqueKey();
		Reserve reserve = new Reserve();
		reserve.setReserveNumber(uniqueKey);
		reserve.setEmail(orderForm.getEmail());
		reserve.setUserId(orderForm.getId());
		reserve.setPayAmount(amountDouble);
		reserve.setConsumptionType(1);
		reserve.setRoomTypeId(orderForm.getRoomTypeId());
		reserve.setNumberOfRooms(orderForm.getNumber());
		reserve.setReserveCheckInTime(dateUtil.toDate(orderForm.getInTime()));
		reserve.setReserveCheckOutTime(dateUtil.toDate(orderForm.getOutTime()));
		return reserve;
	}

	/**
	 * 餐饮预定转Reserve
	 * @author Da
	 * @param userId
	 * @param dinnerTime
	 * @param dinnerNumber
	 * @return
	 * @throws ParseException
	 */
	public Reserve foodToReserve(String userId, String dinnerTime, String dinnerNumber) throws ParseException {
		Reserve reserve = new Reserve();
		Double amountDouble = (double) Integer.parseInt(dinnerNumber)*150;
		String uniqueKey = randomUtil.getUniqueKey();
		reserve.setReserveNumber(uniqueKey);
		reserve.setUserId(Integer.parseInt(userId));
		reserve.setConsumptionFigures(Integer.parseInt(dinnerNumber));
		reserve.setPayAmount(amountDouble);
		reserve.setConsumptionType(2);
		reserve.setDinnerTime(dateUtil.toDateTime(dinnerTime));
		return reserve;
	}

	/**
	 * 娱乐预定转Reserve
	 * @author Da
	 * @param userId
	 * @param entertainmentTime
	 * @param entertainmentType
	 * @return
	 * @throws ParseException
	 */
	public Reserve entertainmentToReserve(String userId, String entertainmentTime, String entertainmentType) throws ParseException {
		Reserve reserve = new Reserve();
		Double amountDouble = (double) entertainmentDeviceMapper.selectMoney(Integer.parseInt(entertainmentType));
		String uniqueKey = randomUtil.getUniqueKey();
		reserve.setReserveNumber(uniqueKey);
		reserve.setUserId(Integer.parseInt(userId));
		reserve.setPayAmount(amountDouble);
		reserve.setConsumptionType(3);
		reserve.setNumberOfEntertaiment(Integer.parseInt(entertainmentType));
		reserve.setReserveCheckInTime(dateUtil.toDate(entertainmentTime));
		reserve.setReserveCheckOutTime(dateUtil.toDateTimes(entertainmentTime));
		return reserve;
	}
}
