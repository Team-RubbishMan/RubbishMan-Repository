package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomType;
import com.ljl.C71S3TljlHotelManagementSystem.bean.RoomTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RoomTypeMapper {
	
	@Select("select sum(amount+deposit) from room_type where id = #{roomTypeId}")
	Object selectMoney(Integer roomTypeId);
	
    long countByExample(RoomTypeExample example);

    int deleteByExample(RoomTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    List<RoomType> selectByExample(RoomTypeExample example);

    RoomType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomType record, @Param("example") RoomTypeExample example);

    int updateByExample(@Param("record") RoomType record, @Param("example") RoomTypeExample example);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
}