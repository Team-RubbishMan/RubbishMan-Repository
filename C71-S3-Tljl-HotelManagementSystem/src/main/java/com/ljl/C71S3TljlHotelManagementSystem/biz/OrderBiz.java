package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Order;
import com.ljl.C71S3TljlHotelManagementSystem.dao.OrderMapper;

@Service
public class OrderBiz {
	@Resource
	private OrderMapper orderMapper;
	
	public PageInfo<Order> loadOrderInfo(int page,int pageSize) {
		PageHelper.startPage(page,pageSize);
		return new PageInfo<Order>(orderMapper.selectByExample(null));
	}



}
