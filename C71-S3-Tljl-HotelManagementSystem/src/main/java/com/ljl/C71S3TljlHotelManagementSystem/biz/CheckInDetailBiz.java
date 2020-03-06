package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.EntertainmentDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Indent;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.bean.ReserveExample;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Room;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.CheckInDetailMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.EntertainmentDetailMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.FoodDetailMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.IndentMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.ReserveMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.RoomMapper;


@Service
public class CheckInDetailBiz {
	@Resource
	RoomMapper roomMapper;
	@Resource
	ReserveMapper reserveMapper;
	@Resource
	IndentMapper indentMapper;
	@Resource
	CheckInDetailMapper checkInDetailMapper;
	@Resource
	FoodDetailMapper foodDetailMapper;
	@Resource
	EntertainmentDetailMapper entertainmentDetailMapper;
	/**
	 * @author 刘子源
	 * 通过房间类型的id 查询既是该房间类型又是空闲状态的房间
	 * @param roomTypeId
	 * @return
	 */
	@Transactional
	public List<Room> selectRoomsIsFree(int roomTypeId) {
		RoomExample objRoomExample=new RoomExample();
		objRoomExample.createCriteria().andRoomTypeIdEqualTo(roomTypeId).andStatusEqualTo("0");
		return roomMapper.selectByExample(objRoomExample);
	}
	/**
	 * 预订单id查询预定信息
	 * @author 刘子源
	 * @param reserveId
	 * @return
	 */
	@Transactional
	public Reserve selectReserveById(Integer reserveId) {
		return reserveMapper.selectByPrimaryKey(reserveId);
	}
	/**
	 * 插入订单信息
	 * @author 刘子源
	 * @param objIndent
	 * @return
	 */
	@Transactional
	public int insertIndent(Indent objIndent) {
		indentMapper.insertSelective(objIndent);
		return objIndent.getId();
	}
	/**
	 * 修改房间状态为入住状态
	 * @param room
	 */
	@Transactional
	public void setRoomIsUsed(Room room) {
		roomMapper.updateByPrimaryKey(room);
	}
	/**
	 * 插入checkInDetail数据
	 * @author 刘子源
	 * @param checkInDetail
	 */
	@Transactional
	public void insertCheckInDetail(CheckInDetail checkInDetail) {
		checkInDetailMapper.insertSelective(checkInDetail);
	}
	/**
	 * 修改预订单状态，改为已完成
	 * @author 刘子源
	 * @param reserveId
	 */
	@Transactional
	public void setReserveStatus(Integer reserveId) {
		Reserve objReserve=new Reserve();
		objReserve.setStatus(1);
		ReserveExample objReserveExample = new ReserveExample();
		objReserveExample.createCriteria().andIdEqualTo(reserveId);
		reserveMapper.updateByExampleSelective(objReserve, objReserveExample);
	}
	/**
	 * 插入foodDetail数据
	 * @param objFoodDetail
	 */
	public void insertFoodDetail(FoodDetail FoodDetail) {
		foodDetailMapper.insertSelective(FoodDetail);
	}
	public void insertEntertainmentDetail(EntertainmentDetail EntertainmentDetail) {
		entertainmentDetailMapper.insertSelective(EntertainmentDetail);
	}

}
