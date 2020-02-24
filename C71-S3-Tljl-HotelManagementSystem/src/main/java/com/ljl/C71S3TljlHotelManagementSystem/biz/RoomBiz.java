package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Room;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomExample;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomType;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomTypeExample;
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


	public PageInfo<RoomType> loadRoomTypeInfo(int page) {
		PageHelper.startPage(page,5);
		PageInfo<RoomType> pageinfoRoomTypeInfo = new PageInfo<>(roomTypeMapper.selectByExample(null),5);
		return pageinfoRoomTypeInfo;
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

	public void updateRoomTypeInfo(RoomType roomType) throws BizException {
		try {
			RoomTypeExample objRoomTypeExample=new RoomTypeExample();
			objRoomTypeExample.createCriteria().andIdEqualTo(roomType.getId());
			roomTypeMapper.updateByExample(roomType,objRoomTypeExample);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("修改失败");
		}
	}
}
