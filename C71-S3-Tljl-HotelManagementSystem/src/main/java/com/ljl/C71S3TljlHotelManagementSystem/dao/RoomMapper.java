package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Room;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoomMapper {
	
	@Select("select count(*) from room where room_type_id = #{roomTypeId} and status = '0'")
	int selectCountRoom(Integer roomTypeId);
	
    long countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);
}