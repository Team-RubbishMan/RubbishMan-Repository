package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Room;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomExample;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomType;
import com.ljl.C71S3TljlHotelManagementSystem.dao.RoomMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.RoomTypeMapper;
@Service
public class RoomBiz {
	@Resource
	private RoomMapper roomMapper;
	@Resource
	private RoomTypeMapper roomTypeMapper;
	
	public List<Room> loadRoomInfo() {
		return roomMapper.selectByExample(null);
	}


	public List<RoomType> loadRoomTypeInfo() {
		return roomTypeMapper.selectByExample(null);
	}
	
	private boolean roomWasUsed(int id) throws BizException {
		Room objRoom=roomMapper.selectByPrimaryKey(id);
		if(!objRoom.getStatus().equals("0")) {
			return false;
		}else {
			throw new BizException("该房间正在被使用，不能被修改成维护状态");
		}
		
	}
	
	public void roomMaintenance(int id) throws BizException {
		if(!roomWasUsed(id)) {
			Room objrRoom=new Room();
			objrRoom.setStatus("2");
			RoomExample objRoomExample=new RoomExample();
			objRoomExample.createCriteria().andIdEqualTo(id);
			roomMapper.updateByExampleSelective(objrRoom, objRoomExample);
		}
	}
	
	
}
