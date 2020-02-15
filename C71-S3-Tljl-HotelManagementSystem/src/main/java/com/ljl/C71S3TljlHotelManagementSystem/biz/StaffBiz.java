package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Staff;
import com.ljl.C71S3TljlHotelManagementSystem.bean.StaffExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.StaffMapper;

@Service
public class StaffBiz {
	
	@Resource
	private StaffMapper sm;
	
	/**
	 * 登录业务处理 
	 * @param staff  登录的职员
	 * @return
	 */
	public Staff login(Staff staff) {
		
		StaffExample example = new StaffExample();
		example.createCriteria().
			andUsernameEqualTo(staff.getUsername()).
			andPasswordEqualTo(staff.getPassword());
		
		//用来存放登录的职员账号
		List<Staff> list = sm.selectByExample(example);
		
		if(  list.size() != 0  ) {
			System.out.println( list );
			return list.get(0);
		}
		return null;
	}
}
