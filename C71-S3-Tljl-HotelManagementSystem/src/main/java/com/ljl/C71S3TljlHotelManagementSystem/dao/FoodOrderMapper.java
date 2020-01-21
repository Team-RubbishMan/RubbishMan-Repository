package com.ljl.C71S3TljlHotelManagementSystem.dao;

import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodOrder;
import com.ljl.C71S3TljlHotelManagementSystem.bean.FoodOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodOrderMapper {
    long countByExample(FoodOrderExample example);

    int deleteByExample(FoodOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FoodOrder record);

    int insertSelective(FoodOrder record);

    List<FoodOrder> selectByExample(FoodOrderExample example);

    FoodOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FoodOrder record, @Param("example") FoodOrderExample example);

    int updateByExample(@Param("record") FoodOrder record, @Param("example") FoodOrderExample example);

    int updateByPrimaryKeySelective(FoodOrder record);

    int updateByPrimaryKey(FoodOrder record);
}