package com.ljl.C71S3TljlHotelManagementSystem.action;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljl.C71S3TljlHotelManagementSystem.bean.User;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.UserBiz;
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
}
