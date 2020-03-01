package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.User;
import com.ljl.C71S3TljlHotelManagementSystem.bean.UserExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.UserMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.MD5Util;
import com.ljl.C71S3TljlHotelManagementSystem.utils.SensitiveInfoHidingUtil;
import com.ljl.C71S3TljlHotelManagementSystem.utils.VerificationCodeUtil;

@Service
public class UserBiz {

	@Resource
	private UserMapper userMapper;
	
	@Autowired
	private JavaMailSender javaMailSender; 
	
	//发件人的邮箱地址
	@Value("${mail.sender.addr}")
	private String senderAddr;
	
	/**
	 * @author 蒋璐
	 * 用户登录
	 * @param username  用户名
	 * @param password   密码
	 * @return
	 * @throws BizException
	 */
	public User loginUser(String username, String password) throws BizException {
		SensitiveInfoHidingUtil objSensitiveInfoHidingUtil = new SensitiveInfoHidingUtil();
		MD5Util objMD5Util = new MD5Util();
		// 存放登录用户的信息
		User objUser = null;
		UserExample objUserExample = new UserExample();
		//判断username和password是否为空
		if(username==null || password == null) {
			throw new BizException("请输入用户名或密码！");
		}

		objUserExample.or().andUsernameEqualTo(username).andPasswordEqualTo(objMD5Util.MD5(password));
		objUserExample.or().andTelephoneEqualTo(username).andPasswordEqualTo(objMD5Util.MD5(password));
		// 存放从数据库中查找到的用户信息
		List<User> lstUser = userMapper.selectByExample(objUserExample);

		if (lstUser.size() == 0) {
			throw new BizException("输入用户用户名或密码不正确，请确认后输入！");
		} else {
			objUser = lstUser.get(0);
			objUser.setPassword("");
			objUser.setIdCard(objSensitiveInfoHidingUtil.hidingIdcard(objUser.getIdCard()));
			objUser.setTelephone(objSensitiveInfoHidingUtil.hidingTel(objUser.getTelephone()));
			return objUser;
		}

	}
	
	/**
	 * 注册方法实现
	 * @author Da
	 * @param user
	 * @return
	 * @throws BizException 
	 */
	public boolean register(User user) throws BizException {
		try {
			userMapper.insertSelective(user);
			return true;
		} catch (Exception e) {
			throw new BizException("业务繁忙！");
		}
	}

	/**
	 * 判断用户名是否被注册
	 * @author Da
	 * @param name
	 * @return
	 * @throws BizException 
	 */
	public boolean validation(String name) throws BizException {
		try {
			UserExample objUserExample = new UserExample();
			objUserExample.createCriteria().andUsernameEqualTo(name);
			if(userMapper.selectByExample(objUserExample).size()==0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			throw new BizException("业务繁忙！");
		}
	}
	/**
	 * 验证用户名和邮箱信息是否合法
	 * @author 刘子源
	 * @param user
	 * @param email
	 * @return
	 * @throws BizException
	 */
	public boolean userAndEmaiIsValid(String user, String email) throws BizException {
		if(user.equals("Your Full Name")) {
			throw new BizException("请输入用户名");
		}
		if(email.equals("Email@address.com")) {
			throw new BizException("请输入邮箱地址");
		}
		UserExample objUserExample=new UserExample();
		objUserExample.or().andUsernameEqualTo(user).andEmailEqualTo(email);
		objUserExample.or().andTelephoneEqualTo(user).andEmailEqualTo(email);
		objUserExample.or().andEmailEqualTo(user).andEmailEqualTo(email);
		List<User> lstUser = userMapper.selectByExample(objUserExample);
		if(lstUser.size()==0) {
			throw new BizException("您输入的账号不存在，请查验后再重新填写");
		}
		return true;
	}
	/**
	 * 发送找回密码验证码邮件
	 * @author 刘子源 
	 * @param email
	 * @return
	 */
	public String sendVerificationCode(String email) {
		//获取验证码工具类
		VerificationCodeUtil objVerificationCodeUtil = new VerificationCodeUtil();
		
		SimpleMailMessage objSimpleMailMessage=new SimpleMailMessage();
		
		objSimpleMailMessage.setFrom(senderAddr);
		
		objSimpleMailMessage.setTo(email);
		
		objSimpleMailMessage.setSubject("天堂酒店用户登录密码找回");
		//获取验证码
		String strVerificationCode=objVerificationCodeUtil.generateVerificationCode();
		
		objSimpleMailMessage.setText("您的找回密码的验证码为： "+strVerificationCode+" (有效时间为3分钟)，请勿将该验证码告诉任何人！");
		
		javaMailSender.send(objSimpleMailMessage);
		
		return strVerificationCode;
	}
	/**
	 * 重置密码
	 * @author 刘子源
	 * @param user
	 * @param email
	 * @param verificationCode
	 * @param password
	 * @param cofirmPassword
	 * @param orginalUser
	 * @param reallyVerificationCode
	 * @param objValidTime
	 * @param presentTime
	 * @throws BizException
	 */
	public void resetPasswordInfoValid(String user, String email, String verificationCode, String password,
			String cofirmPassword, String orginalUser, String reallyVerificationCode, Date objValidTime,
			Date presentTime) throws BizException {
		if(!orginalUser.equals(user)) {
			throw new BizException("用户名信息被修改，请重新输入正确的用户名");
		}
		if(!reallyVerificationCode.equals(verificationCode)) {
			throw new BizException("验证码输入错误，请重新输入");
		}
		if(!password.equals(cofirmPassword)) {
			throw new BizException("两次密码输入不一致，请确认后重新输入");
		}
		if(!objValidTime.after(presentTime)) {
			throw new BizException("验证码已经失效,请重新获取验证码");
		}
		resetPassword(user,password,email);
	}
	/**
	 * 重置密码的相关信息校验
	 * @param user
	 * @param password
	 * @param email
	 */
	private void resetPassword(String user, String password,String email) {
		UserExample objUserExample=new UserExample();
		objUserExample.or().andUsernameEqualTo(user).andEmailEqualTo(email);
		objUserExample.or().andTelephoneEqualTo(user).andEmailEqualTo(email);
		objUserExample.or().andEmailEqualTo(user).andEmailEqualTo(email);
		User objUser=new User();
		MD5Util objMD5Util=new MD5Util();
		String strPasswordByMD5=objMD5Util.MD5(password);
		objUser.setPassword(strPasswordByMD5);
		userMapper.updateByExampleSelective(objUser, objUserExample);
		
	}
}
