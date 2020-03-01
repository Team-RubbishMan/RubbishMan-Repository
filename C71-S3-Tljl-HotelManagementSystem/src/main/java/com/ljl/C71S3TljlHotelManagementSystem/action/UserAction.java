package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljl.C71S3TljlHotelManagementSystem.bean.User;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.UserBiz;
import com.ljl.C71S3TljlHotelManagementSystem.utils.MD5Util;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

@Controller
public class UserAction {
	@Resource
	private UserBiz userBiz;
	/**
	 * 打开，登录，注册，忘记密码页面
	 * @author 刘子源
	 * @return
	 */
	@GetMapping("front/signIn.html")
	public String SignIn() {
		return "front/signIn";
	}
	
	
	/**
	 * @author 蒋璐
	 * 前台用户登录功能
	 * @param remeberUsername    记住账号是否勾选
	 * @param username    用户名
	 * @param password    密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/front/dologin")
	@ResponseBody
	public Result dologin(boolean remeberUsername, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
				// 清空session内容
				request.getSession().invalidate();
				try {
					// 获取staffBiz中已登录的职员信息
					User objUser=userBiz.loginUser(username,password);
					request.getSession().setAttribute("objUser", objUser);
					

					return new Result(1, "登录成功！", null);
				} catch (BizException e) {
					e.printStackTrace();
					return new Result(2, e.getMessage(), username);
				} catch (Exception e) {
					return new Result(0, "系统繁忙，请稍后再试！", null);
				}
		
	
	}
	
	/**
	 * 验证用户名是否被注册
	 * @author Da
	 * @param name 用户名
	 * @return
	 */
	@PostMapping("/front/doname")
	@ResponseBody
	public Result validation(@RequestParam String name) {
		try {
			if (userBiz.validation(name)) {
				return new Result(1);
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return new Result(0);
	}

	/**
	 * 实现注册业务方法
	 * @author Da
	 * @param user 接收实体类对象
	 * @return
	 */
	@PostMapping("/front/doreg")
	@ResponseBody
	public Result doreg(User user) {
		System.out.println(user.getPassword());
		String pwd = new MD5Util().MD5(user.getPassword());
		user.setPassword(pwd);
		try {
			if (userBiz.register(user)) {
				return new Result(1, "注册成功");
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return new Result(0, "注册失败");
	}
	
	/**
	 * 发送验证码邮件
	 * @author 刘子源
	 * @param user
	 * @param email
	 * @param httpServletRequest
	 * @return
	 */
	@PostMapping("front/getVerificationCode")
	@ResponseBody
	public Result getVerificationCode(String user, String email, HttpServletRequest httpServletRequest) {
		httpServletRequest.getSession().invalidate();
		System.out.println(user);
		System.out.println(email);
		try {
			if (userBiz.userAndEmaiIsValid(user, email)) {
				String strVerificationCode = userBiz.sendVerificationCode(email);
				System.out.println("验证码是========" + strVerificationCode);
				// 向session插入验证码，用于和用户输入的验证码进行比对
				httpServletRequest.getSession().setAttribute("verificationCode", strVerificationCode);
				httpServletRequest.getSession().setAttribute("validTime",
						new Date(System.currentTimeMillis() + 3 * 60 * 1000));
				httpServletRequest.getSession().setAttribute("orginalUser", user);
				// 1代表成功
				return new Result(1, "验证码已发送，请及时查收！", null);
			}
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2, e.getMessage(), null);
		}
		return null;
	}
	/**
	 * 重置密码
	 * @param user
	 * @param email
	 * @param verificationCode
	 * @param password
	 * @param confirmPassword
	 * @param httpServletRequest
	 * @return
	 */
	@PostMapping("front/resetPassword")
	@ResponseBody
	public Result resetPassword(String user, String email, String verificationCode, String password,
			String confirmPassword, HttpServletRequest httpServletRequest) {
		System.out.println("user=" + user);
		System.out.println("email" + email);
		System.out.println("verificationCode====" + verificationCode);
		System.out.println("password" + password);
		System.out.println("cofirmPassword" + confirmPassword);
		// 在session中取出 获取验证码的用户名，验证码，有效时间
		String strOrginalUser = String.valueOf(httpServletRequest.getSession().getAttribute("orginalUser"));
		String strReallyVerificationCode = String
				.valueOf(httpServletRequest.getSession().getAttribute("verificationCode"));
		Date objValidTime = (Date) httpServletRequest.getSession().getAttribute("validTime");
		try {
			userBiz.resetPasswordInfoValid(user, email, verificationCode, password, 
					confirmPassword, strOrginalUser,strReallyVerificationCode, 
					objValidTime, new Date(System.currentTimeMillis()));
			return new Result(1,"修改成功，3s后跳转登录页面",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2,e.getMessage(),null);
		}
	}
}
