package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.EntertainmentDevice;
import com.ljl.C71S3TljlHotelManagementSystem.bean.EntertainmentDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EntertainmentDeviceMapper {
	
	@Select("select amount from entertainment_device where id = #{id}")
	Object selectMoney(Integer id);
	
    long countByExample(EntertainmentDeviceExample example);

    int deleteByExample(EntertainmentDeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EntertainmentDevice record);

    int insertSelective(EntertainmentDevice record);

    List<EntertainmentDevice> selectByExample(EntertainmentDeviceExample example);

    EntertainmentDevice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EntertainmentDevice record, @Param("example") EntertainmentDeviceExample example);

    int updateByExample(@Param("record") EntertainmentDevice record, @Param("example") EntertainmentDeviceExample example);

    int updateByPrimaryKeySelective(EntertainmentDevice record);

    int updateByPrimaryKey(EntertainmentDevice record);
}