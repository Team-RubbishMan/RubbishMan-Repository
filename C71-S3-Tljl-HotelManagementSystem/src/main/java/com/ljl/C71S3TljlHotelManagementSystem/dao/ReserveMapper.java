package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.bean.ReserveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReserveMapper {
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