package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.User;
import com.ljl.C71S3TljlHotelManagementSystem.bean.UserExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.UserMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.MD5Util;
import com.ljl.C71S3TljlHotelManagementSystem.utils.SensitiveInfoHidingUtil;

@Service
public class UserBiz {

	@Resource
	private UserMapper userMapper;

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
}
