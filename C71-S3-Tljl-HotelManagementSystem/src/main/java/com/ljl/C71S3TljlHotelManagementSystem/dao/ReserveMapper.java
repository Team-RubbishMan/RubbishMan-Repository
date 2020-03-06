package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.bean.ReserveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ReserveMapper {
	
	@Select("select sum(number_of_rooms) from reserve where " +
			" (reserve_check_in_time < #{outTime} or " + 
			" reserve_check_out_time > #{outTime} or " + 
			" reserve_check_out_time > #{inTime} or " + 
			" (reserve_check_in_time > #{inTime} and reserve_check_out_time < #{outTime}))"	+
			" and room_type_id = #{roomTypeId} and status='0';")
	String selectUsedRooms(String inTime, String outTime, int roomTypeId);
	
    long countByExample(ReserveExample example);

    int deleteByExample(ReserveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reserve record);

    int insertSelective(Reserve record);

    List<Reserve> selectByExample(ReserveExample example);

    Reserve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reserve record, @Param("example") ReserveExample example);

    int updateByExample(@Param("record") Reserve record, @Param("example") ReserveExample example);

    int updateByPrimaryKeySelective(Reserve record);

    int updateByPrimaryKey(Reserve record);
}