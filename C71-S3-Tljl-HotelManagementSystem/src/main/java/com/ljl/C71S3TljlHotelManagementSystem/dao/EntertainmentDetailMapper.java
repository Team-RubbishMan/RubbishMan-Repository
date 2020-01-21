package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.EntertainmentDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.EntertainmentDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntertainmentDetailMapper {
    long countByExample(EntertainmentDetailExample example);

    int deleteByExample(EntertainmentDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EntertainmentDetail record);

    int insertSelective(EntertainmentDetail record);

    List<EntertainmentDetail> selectByExample(EntertainmentDetailExample example);

    EntertainmentDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EntertainmentDetail record, @Param("example") EntertainmentDetailExample example);

    int updateByExample(@Param("record") EntertainmentDetail record, @Param("example") EntertainmentDetailExample example);

    int updateByPrimaryKeySelective(EntertainmentDetail record);

    int updateByPrimaryKey(EntertainmentDetail record);
}