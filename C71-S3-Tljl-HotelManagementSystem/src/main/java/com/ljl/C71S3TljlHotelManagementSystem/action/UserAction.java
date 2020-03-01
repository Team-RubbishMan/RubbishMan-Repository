package com.ljl.C71S3TljlHotelManagementSystem.action;

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
			// 如果选择记住用户名,则创建cookie,并将账号密码注入cookie
			if (remeberUsername == true) {
				// 创建cookie对象
				Cookie objUsernameCookie = new Cookie("remeberUsername", username);
				// 设置Cookie有效时间,单位为妙
				objUsernameCookie.setMaxAge(60 * 60 * 24 * 7);
				// 设置Cookie的有效范围,/为全部路径
				objUsernameCookie.setPath("/");
				response.addCookie(objUsernameCookie);
				Cookie objCheckboxIsCheckCookie = new Cookie("checkboxIsCheck", "checked");
				// 设置Cookie有效时间,单位为妙
				objCheckboxIsCheckCookie.setMaxAge(60 * 60 * 24 * 7);
				// 设置Cookie的有效范围,/为全部路径
				objCheckboxIsCheckCookie.setPath("/");
				response.addCookie(objCheckboxIsCheckCookie);
			} else {
				// 如果没有选中记住用户名,则将已记住密码的cookie失效.即有效时间设为0
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("remeberUsername")) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
					if (cookie.getName().equals("checkboxIsCheck")) {
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}

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
}
