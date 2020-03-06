package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetailExample;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Indent;
import com.ljl.C71S3TljlHotelManagementSystem.bean.IndentExample;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomType;
import com.ljl.C71S3TljlHotelManagementSystem.dao.CheckInDetailMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.IndentMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.RoomTypeMapper;

@Service
public class IndentBiz {
	@Resource
	private IndentMapper indentMapper;
	
	@Resource
	private CheckInDetailMapper checkInDetailMapper;
	
	@Resource
	private RoomTypeMapper roomTypeMapper;
	
	
	/**
	 * @author 蒋璐
	 * 加载订单信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Indent> loadOrderInfo(int page,int pageSize) {
		PageHelper.startPage(page,pageSize);
		return new PageInfo<Indent>(indentMapper.selectByExample(null));
	}
	
	/**
	 * 通过indentid查找详情信息
	 * @param indentId
	 * @return
	 */
	public List<CheckInDetail> selectCheckInDetailInfoByIndentId(int indentId) {
		CheckInDetailExample objCheckInDetailExample = new CheckInDetailExample();
		objCheckInDetailExample.createCriteria().andOrderIdEqualTo(indentId);
		return checkInDetailMapper.selectByExample(objCheckInDetailExample);
	}

	/***
	 * 通过id查找全部的订单信息
	 * @param indentId
	 * @return
	 */
	public Indent selectAll(Integer indentId) {
		Indent objIndent=indentMapper.selectByPrimaryKey(indentId);
		return objIndent;
	}
	
	/**
	 * 通过id查找房间类型
	 * @param roomTypeId
	 */
	public RoomType selectRoomType(int roomTypeId) {
		RoomType objRoomType = roomTypeMapper.selectByPrimaryKey(roomTypeId);
		return objRoomType;
	}
	/**
	 * 通过结算时间和入住时间算住了多少天
	 */
	public int calculateTime(List<CheckInDetail> checkInDetailList) {
		long day = 0;
		int total = 0;
		for(CheckInDetail checkInDetail:checkInDetailList) {
			day=(checkInDetail.getCheckOutTime().getTime()-checkInDetail.getCheckInTime().getTime())/(60*60*24*1000);
			total += (int) day;
		}
		return total;
	}

	public void updateStatus(Integer indentId) {
		Indent objIndent=indentMapper.selectByPrimaryKey(indentId);
		System.out.println(objIndent);
		objIndent.setStatus("0");
		indentMapper.updateByPrimaryKeySelective(objIndent);
	}
	
}
