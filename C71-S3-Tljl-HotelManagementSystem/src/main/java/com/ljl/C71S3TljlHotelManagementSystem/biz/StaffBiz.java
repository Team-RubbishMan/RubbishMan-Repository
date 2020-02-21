package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Staff;
import com.ljl.C71S3TljlHotelManagementSystem.bean.StaffExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.StaffMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.MD5Util;
import com.ljl.C71S3TljlHotelManagementSystem.utils.SensitiveInfoHidingUtil;
import com.ljl.C71S3TljlHotelManagementSystem.utils.VerificationCodeUtil;

@Service
public class StaffBiz {
	
	@Resource
	private StaffMapper staffMapper;
	
	@Autowired
	private JavaMailSender javaMailSender; 
	
	//发件人的邮箱地址
	@Value("${mail.sender.addr}")
	private String senderAddr;
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
	/**
	 * 重置密码，需要验证该账号和邮箱在数据库中是否存在，不存在返回true 存在抛出异常
	 * @param account 账号： 可以是用户名，姓名，身份证
	 * @param email 邮箱地址
	 * @return 
	 * @throws BizException 
	 */
	public boolean usernameIsExsist(String account,String email) throws BizException {
		StaffExample objStaffExample=new StaffExample();
		objStaffExample.or().andUsernameEqualTo(account).andEmailEqualTo(email);
		objStaffExample.or().andNameEqualTo(account).andEmailEqualTo(email);
		objStaffExample.or().andIdCardEqualTo(account).andEmailEqualTo(email);
		 //取出数据库中查到的数据
		 List<Staff> lstStaff=staffMapper.selectByExample(objStaffExample);
		 if(lstStaff.size()!=0) {
			 System.out.println("查询到的职员信息"+lstStaff.get(0));
			 return true;
		 }else {
			 throw new BizException("该账号不存在，请查验后重新填写");
		 }
		
	}
	/**
	 * 发送验证码函数
	 * @param eamil 邮件地址
	 * @return strVerificationCode 验证码
	 */
	public String sendVerificationCode(String email) {
		//获取验证码工具类
		VerificationCodeUtil objVerificationCodeUtil = new VerificationCodeUtil();
		
		SimpleMailMessage objSimpleMailMessage=new SimpleMailMessage();
		
		objSimpleMailMessage.setFrom(senderAddr);
		
		objSimpleMailMessage.setTo(email);
		
		objSimpleMailMessage.setSubject("天堂酒店员工登录密码找回");
		//获取验证码
		String strVerificationCode=objVerificationCodeUtil.generateVerificationCode();
		
		objSimpleMailMessage.setText("您的找回密码的验证码为： "+strVerificationCode+" (有效时间为3分钟)，请勿将该验证码告诉任何人！");
		
		javaMailSender.send(objSimpleMailMessage);
		
		return strVerificationCode;
	}
	/**
	 * 判断发送验证码后，用户是否修改了账户名，验证用户是否修改了用户名，导致修改其他用户的密码
	 * @param account
	 * @param reallyAccount
	 * @return 两次验证对了，返回true  错了 抛出业务异常
	 * @throws BizException 
	 */
	public boolean accountIsTrue(String reallyAccount,String account) throws BizException {
		if(reallyAccount.equals(account)) {
			return true;
		}else {
			throw new BizException("账号信息发生了更改，请重新输入正确的账号");
		}
	}
	/**
	 * 比对验证码是否正确
	 * @param reallyVerificationCode 验证码
	 * @param verificationCode 用户输入的验证码
	 * @return 正确返回true  错误抛出义务异常
	 * @throws BizException
	 */
	public boolean verificationCodeIsTrue(String reallyVerificationCode, String verificationCode) throws BizException {
		if(reallyVerificationCode.equals(verificationCode)) {
			return true;
		}else {
			throw new BizException("验证码输入错误，请重新输入");
		}
	}
	/**
	 * 验证两次密码是否输入一致
	 * @param password 密码
	 * @param cofirmPassword 确认密码
	 * @return 一致则返回true  否则抛出业务异常
	 * @throws BizException
	 */
	public boolean passwordIsSame(String password, String cofirmPassword) throws BizException {
		if(password.equals(cofirmPassword)) {
			return true;
		}else {
			throw new BizException("两次密码输入不一致，请确认后重新输入");
		}
	}
	/**
	 * 判断验证码是否过期
	 * @param objValidTime
	 * @param presentTime
	 * @return
	 * @throws BizException
	 */
	public boolean verificationCodeIsValid(Date objValidTime, Date presentTime) throws BizException {
		if(objValidTime.after(presentTime)) {
			return true;
		}else {
			throw new BizException("两次密码输入不一致，请确认后重新输入");
		}
	}
	/**
	 * 重置密码
	 * @param account 账号
	 * @param password 密码
	 * @param email 邮箱地址
	 * account 和 email 作为标识，去数据库中提取数据  
	 */
	public void resetPassword(String account, String password,String email) {
		StaffExample objStaffExample=new StaffExample();
		objStaffExample.or().andUsernameEqualTo(account).andEmailEqualTo(email);
		objStaffExample.or().andNameEqualTo(account).andEmailEqualTo(email);
		objStaffExample.or().andIdCardEqualTo(account).andEmailEqualTo(email);
		Staff objStaff=new Staff();
		MD5Util objMD5Util=new MD5Util();
		String strPasswordByMD5=objMD5Util.MD5(password);
		objStaff.setPassword(strPasswordByMD5);
		staffMapper.updateByExampleSelective(objStaff, objStaffExample);
		
	}
	public boolean accountAndEmaiIsNotEmpty(String account,String email) throws BizException {
		if(account.equals("")||account==null) {
			throw new BizException("账号不能填写为空");
		}else if(email.equals("")||email==null) {
			throw new BizException("邮箱不能填写为空");
		}else {
			return true;
		}
	}
	
	/**
	 * 注册业务方法实现
	 * @param staff 实体类
	 * @return 成功返回1
	 * @throws BizException 业务异常
	 */
	public int register(Staff staff) throws BizException {
		try {
			staffMapper.insertSelective(staff);
		} catch (Exception e) {
			throw new RuntimeException("业务繁忙！");
		}
		return 1;
	}
	
	/**
	 * 验证用户名业务实现
	 * @param name 用户名
	 * @return 未注册返回1
	 * @throws BizException
	 */
	public int validation(String name) throws BizException {
		try {
			StaffExample objStaffExample = new StaffExample();
			objStaffExample.createCriteria().andUsernameEqualTo(name);
			List<Staff> lstStaffs = staffMapper.selectByExample(objStaffExample);
			if(lstStaffs.size()==0) {
				return 1;
			}else {
				return 0;
			}
		} catch (Exception e) {
			throw new RuntimeException("业务繁忙！");
		}
	}
}
