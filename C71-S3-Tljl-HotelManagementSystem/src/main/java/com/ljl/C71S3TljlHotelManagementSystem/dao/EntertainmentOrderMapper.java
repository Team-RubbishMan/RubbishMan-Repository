package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.EntertainmentOrder;
import com.ljl.C71S3TljlHotelManagementSystem.bean.EntertainmentOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntertainmentOrderMapper {
    long countByExample(EntertainmentOrderExample example);

    int deleteByExample(EntertainmentOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EntertainmentOrder record);

    int insertSelective(EntertainmentOrder record);

    List<EntertainmentOrder> selectByExample(EntertainmentOrderExample example);

    EntertainmentOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EntertainmentOrder record, @Param("example") EntertainmentOrderExample example);

    int updateByExample(@Param("record") EntertainmentOrder record, @Param("example") EntertainmentOrderExample example);

    int updateByPrimaryKeySelective(EntertainmentOrder record);

    int updateByPrimaryKey(EntertainmentOrder record);
}