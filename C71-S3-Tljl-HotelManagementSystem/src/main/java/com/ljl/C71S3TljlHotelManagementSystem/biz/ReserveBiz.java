package com.ljl.C71S3TljlHotelManagementSystem.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.dao.ReserveMapper;

@Service
public class ReserveBiz {
	@Resource
	ReserveMapper reserveMapper;

	public PageInfo<Reserve> loadReserveInfo(int limit, int pageNumber) {
		PageHelper.startPage(pageNumber,limit);
		return new PageInfo<Reserve>(reserveMapper.selectByExample(null));
	}
	public Reserve loadReserveInfoById(int id) {
		return (reserveMapper.selectByPrimaryKey(id));
	}
	
}
