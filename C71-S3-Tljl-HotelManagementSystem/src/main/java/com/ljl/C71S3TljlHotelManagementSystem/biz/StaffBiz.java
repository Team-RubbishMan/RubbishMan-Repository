package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Staff;
import com.ljl.C71S3TljlHotelManagementSystem.bean.StaffExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.StaffMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.MD5Util;
import com.ljl.C71S3TljlHotelManagementSystem.utils.SensitiveInfoHidingUtil;

@Service
public class StaffBiz {
	
	@Resource
	private StaffMapper staffMapper;
	
	/**
	 * 登录业务处理 
	 * @param staff  登录的职员
	 * @return
	 * @throws BizException 
	 */
	public Staff loginStaff(String username,String password) throws BizException {
		SensitiveInfoHidingUtil objSensitiveInfoHidingUtil = new SensitiveInfoHidingUtil();
		MD5Util objMD5Util = new MD5Util();
		//存放登录职员的信息
		Staff objStaff = null;
		StaffExample objStaffExample = new StaffExample();
		
		objStaffExample.or().andUsernameEqualTo(username).andPasswordEqualTo(objMD5Util.MD5(password));
		objStaffExample.or().andNameEqualTo(username).andPasswordEqualTo(objMD5Util.MD5(password));
		objStaffExample.or().andIdCardEqualTo(username).andPasswordEqualTo(objMD5Util.MD5(password));
		//System.out.println();
		//存放从数据库中查找到的职员信息
		List<Staff> lstStaff = staffMapper.selectByExample(objStaffExample);
		
		if(lstStaff.size()==0) {
			throw new BizException("员工用户名或密码不正确，请确认后输入！");
		}else {
			objStaff = lstStaff.get(0);
			objStaff.setPassword("");
			objStaff.setIdCard(objSensitiveInfoHidingUtil.hidingIdcard(objStaff.getIdCard()));
			objStaff.setTelephone(objSensitiveInfoHidingUtil.hidingTel(objStaff.getTelephone()));
			System.out.println(objStaff);
			return objStaff;
		}
		/*if(lstStaff.size()==0) {
			System.out.println("name=====");
			objCriteria.andNameEqualTo(username);
			lstStaff = staffMapper.selectByExample(objStaffExample);
		}
		if(lstStaff.size()==0) {
			System.out.println("idcard=====");
			objCriteria.andIdCardEqualTo(username);
			lstStaff = staffMapper.selectByExample(objStaffExample);
		}
		if(lstStaff.size()==0) {
			throw new BizException("员工用户名不正确，请确认后输入！");
		}else {
			if( ! lstStaff.get(0).getPassword().equals(password) ) {
				throw new BizException("输入的密码错误，请重新输入！");
			}else {
				objStaff = lstStaff.get(0);
				objStaff.setPassword("");
				objStaff.setIdCard(objSensitiveInfoHidingUtil.hidingIdcard(objStaff.getIdCard()));
				objStaff.setTelephone(objSensitiveInfoHidingUtil.hidingTel(objStaff.getTelephone()));
				return objStaff;
			}
		}*/
		
	}
}
