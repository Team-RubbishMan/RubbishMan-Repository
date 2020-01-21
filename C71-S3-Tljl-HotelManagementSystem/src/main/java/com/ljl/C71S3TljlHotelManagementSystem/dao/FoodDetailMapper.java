package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodDetailMapper {
    long countByExample(FoodDetailExample example);

    int deleteByExample(FoodDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FoodDetail record);

    int insertSelective(FoodDetail record);

    List<FoodDetail> selectByExample(FoodDetailExample example);

    FoodDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FoodDetail record, @Param("example") FoodDetailExample example);

    int updateByExample(@Param("record") FoodDetail record, @Param("example") FoodDetailExample example);

    int updateByPrimaryKeySelective(FoodDetail record);

    int updateByPrimaryKey(FoodDetail record);
}