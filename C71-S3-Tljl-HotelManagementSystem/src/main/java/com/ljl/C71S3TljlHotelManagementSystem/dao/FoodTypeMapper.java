package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodType;
import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodTypeMapper {
    long countByExample(FoodTypeExample example);

    int deleteByExample(FoodTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FoodType record);

    int insertSelective(FoodType record);

    List<FoodType> selectByExample(FoodTypeExample example);

    FoodType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FoodType record, @Param("example") FoodTypeExample example);

    int updateByExample(@Param("record") FoodType record, @Param("example") FoodTypeExample example);

    int updateByPrimaryKeySelective(FoodType record);

    int updateByPrimaryKey(FoodType record);
}