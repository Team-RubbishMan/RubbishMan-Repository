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

	/**
	 * 加载房型信息
	 * @author Da
	 * @return
	 */
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

	/**
	 * 修改房型信息
	 * @author Da
	 * @param roomType
	 * @throws BizException
	 */
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

	/**
	 * 新增房型信息
	 * @author Da
	 * @param roomType
	 * @throws BizException
	 */
	public void addRoomType(RoomType roomType) throws BizException {
		try {
			roomTypeMapper.insert(roomType);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("添加失败");
		}
	}
	
	/**
	 * 删除房型信息
	 * @author Da
	 * @param roomTypeid
	 * @throws BizException
	 */
	public void deleteRoomTypeInfo(Integer roomTypeid) throws BizException {
		try {
			roomTypeMapper.deleteByPrimaryKey(roomTypeid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("删除失败");
		}
	}
	
	/**
	 * 删除多个房型信息
	 * @author Da
	 * @param roomTypeids id数组
	 * @throws BizException
	 */
	public void deleteRoomTypeInfo(String[] roomTypeids) throws BizException {
		try {
			for (String roomTypeid : roomTypeids) {
				roomTypeMapper.deleteByPrimaryKey(Integer.parseInt(roomTypeid));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BizException("删除失败");
		}
	}

	/**
	 * 使用PageHelper封装房型信息
	 * @author Da
	 * @param page 当前页
	 * @param pageSize	页面大小
	 * @return
	 */

	public PageInfo<RoomType> getPage(Integer page,Integer pageSize){
		PageHelper.startPage(page,pageSize);
		return new PageInfo<RoomType>(roomTypeMapper.selectByExample(null));
	}

	/**
	 * 判断房型是否存在
	 * @author Da
	 * @param typeName
	 * @return
	 * @throws BizException
	 */
	public boolean selectTypeName(String typeName) throws BizException {
		RoomTypeExample objRoomTypeExample=new RoomTypeExample();
		objRoomTypeExample.createCriteria().andTypeEqualTo(typeName);
		roomTypeMapper.selectByExample(objRoomTypeExample);
		
		if(roomTypeMapper.selectByExample(objRoomTypeExample).size()==0) {
			return true;
		}else {
			throw new BizException("改房型已经存在！");
		}
	}

}
