package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Staff;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.StaffBiz;
import com.ljl.C71S3TljlHotelManagementSystem.dao.DepartmentMapper;
import com.ljl.C71S3TljlHotelManagementSystem.vo.Result;

@Controller
public class StaffAction {
	@Resource
	private StaffBiz staffBiz;
	@Resource	
	private DepartmentMapper departmentMapper;

	@GetMapping("/back/login.html")
	public String login() {
		return "back/login";
	}

	@GetMapping("/back/frame.html")
	public String frame() {
		return "back/frame";
	}

	@GetMapping("/back/forgetpassword.html")
	public String forgetpassword() {
		return "/back/forgetpassword";
	}

	@GetMapping("/back/signup.html")
	public String signup(Model m) {
		m.addAttribute("Department",departmentMapper.selectByExample(null));
		return "/back/signup";
	}
	
	@GetMapping("/back/setting.html")
	public String setting() {
		return "/back/setting";
	}
	/**
	 * @author 蒋璐
	 * 后台职员登录
	 * @param remeberUsername  记住密码
	 * @param username  登录职员的用户名
	 * @param password  登录职员的密码
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping("/back/dologin")
	@ResponseBody
	public Result dologin(boolean remeberUsername,@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		//清空session内容
		request.getSession().invalidate();
		try {
			// 获取staffBiz中已登录的职员信息
			Staff objStaff = staffBiz.loginStaff(username, password);
			System.out.println("objStaff" + objStaff);
			request.getSession().setAttribute("objStaff", objStaff);
			System.out.println("头像路径"+objStaff.getProfile());
			//如果选择记住用户名,则创建cookie,并将账号密码注入cookie
    		if(remeberUsername == true){
    		//创建cookie对象
        		Cookie objUsernameCookie = new Cookie("remeberUsername",username);
        		//设置Cookie有效时间,单位为妙
        		objUsernameCookie.setMaxAge(60*60*24*7);
        		 //设置Cookie的有效范围,/为全部路径
        		objUsernameCookie.setPath("/");
        		response.addCookie(objUsernameCookie);
        		Cookie objCheckboxIsCheckCookie = new Cookie("checkboxIsCheck","checked");
        		//设置Cookie有效时间,单位为妙
        		objCheckboxIsCheckCookie.setMaxAge(60*60*24*7);
        		 //设置Cookie的有效范围,/为全部路径
        		objCheckboxIsCheckCookie.setPath("/");
        		response.addCookie(objCheckboxIsCheckCookie);
        	}else{
        	//如果没有选中记住用户名,则将已记住密码的cookie失效.即有效时间设为0
        		Cookie[] cookies = request.getCookies();
        		for (Cookie cookie : cookies) {
    				if(cookie.getName().equals("remeberUsername")){
    					cookie.setMaxAge(0);
    					cookie.setPath("/");
    					response.addCookie(cookie);
    				}
    				if(cookie.getName().equals("checkboxIsCheck")){
    					cookie.setMaxAge(0);
    					cookie.setPath("/");
    					response.addCookie(cookie);
    				}
    			}
        	}
    		
			return new Result(1,"登录成功！",null);
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2,e.getMessage(),username);
		}catch (Exception e) {
			return new Result(0,"系统繁忙，请稍后再试！",null);
		}
		
	}

	@PostMapping("back/getVerificationCode")
	@ResponseBody
	public Result getVerificationCode(String account, String email, HttpServletRequest httpServletRequest) {
		httpServletRequest.getSession().invalidate();
		System.out.println("account=" + account);
		System.out.println("email=====" + email);
		try {
			if (staffBiz.accountAndEmaiIsNotEmpty(account,email)&&staffBiz.usernameIsExsist(account, email)) {
				String strVerificationCode = staffBiz.sendVerificationCode(email);
				System.out.println("验证码是========" + strVerificationCode);
				// 向session插入验证码，用于和用户输入的验证码进行比对
				httpServletRequest.getSession().setAttribute("verificationCode", strVerificationCode);
				httpServletRequest.getSession().setAttribute("validTime",
						new Date(System.currentTimeMillis() + 3 * 60 * 1000));
				httpServletRequest.getSession().setAttribute("reallyAccount", account);
				// 1代表成功
				return new Result(1, "验证码已发送，请及时查收！", null);
			}
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2, e.getMessage(), null);
		}
		return null;
	}

	@PostMapping("back/resetPassword")
	@ResponseBody
	public Result resetPassword(String account, String email, String verificationCode, String password,
			String cofirmPassword, HttpServletRequest httpServletRequest) {
		System.out.println("account=" + account);
		System.out.println("cofirmPassword" + cofirmPassword);
		System.out.println("verificationCode====" + verificationCode);
		try {
			// 在session中取出 获取验证码的用户名，验证码，有效时间
			String strReallyAccount = String
					.valueOf(httpServletRequest.getSession().getAttribute("reallyAccount"));
			String strReallyVerificationCode = String
					.valueOf(httpServletRequest.getSession().getAttribute("verificationCode"));
			Date objValidTime = (Date) httpServletRequest.getSession().getAttribute("validTime");
			if (staffBiz.accountIsTrue(strReallyAccount, account)
					&& staffBiz.verificationCodeIsTrue(strReallyVerificationCode, verificationCode)
					&& staffBiz.passwordIsSame(password, cofirmPassword)
					&& staffBiz.verificationCodeIsValid(objValidTime,new Date(System.currentTimeMillis()))) {
					staffBiz.resetPassword(account,password,email);
					httpServletRequest.getSession().invalidate();
					return new Result(1,"密码修改成功，3秒后返回登陆界面",null);
			}
		} catch (BizException e) {
			e.printStackTrace();
			return new Result(2,e.getMessage(),null);
		}
		return null;
	}
	/**
	 * 验证用户名是否被注册
	 * @param name 用户名
	 * @return
	 */
	@PostMapping("/back/doname")
	@ResponseBody
	public Result validation(@RequestParam String name) {
		try {
			if(staffBiz.validation(name)==1) {
				return new Result(1);
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return new Result(0);
	}
	
	/**
	 * 实现注册业务方法
	 * @param staff 接收实体类对象
	 * @return
	 */
	@PostMapping("/back/doreg")
	@ResponseBody
	public Result doreg(Staff staff) {
		System.out.println(staff.toString());
		try {
			if(staffBiz.register(staff)==1) {
				return new Result(1,"注册成功");
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		return new Result(0,"注册失败");
	}
}