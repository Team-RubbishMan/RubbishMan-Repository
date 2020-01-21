package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckInDetailMapper {
    long countByExample(CheckInDetailExample example);

    int deleteByExample(CheckInDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckInDetail record);

    int insertSelective(CheckInDetail record);

    List<CheckInDetail> selectByExample(CheckInDetailExample example);

    CheckInDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckInDetail record, @Param("example") CheckInDetailExample example);

    int updateByExample(@Param("record") CheckInDetail record, @Param("example") CheckInDetailExample example);

    int updateByPrimaryKeySelective(CheckInDetail record);

    int updateByPrimaryKey(CheckInDetail record);
}