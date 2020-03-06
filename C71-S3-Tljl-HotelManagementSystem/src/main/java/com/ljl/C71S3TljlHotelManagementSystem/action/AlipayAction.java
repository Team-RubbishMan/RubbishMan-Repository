package com.ljl.C71S3TljlHotelManagementSystem.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ljl.C71S3TljlHotelManagementSystem.bean.Reserve;
import com.ljl.C71S3TljlHotelManagementSystem.biz.BizException;
import com.ljl.C71S3TljlHotelManagementSystem.biz.ReserveBiz;
import com.ljl.C71S3TljlHotelManagementSystem.dao.ReserveMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.AlipayConfig;

@Controller
public class AlipayAction {

	@Resource
	private ReserveBiz reserveBiz;
	@Resource
	private ReserveMapper reserveMapper;


	/**
	 * 订单支付处理
	 * @author Da
	 * @param orderid
	 * @return
	 * @throws BizException
	 */
	@PostMapping("/alipay/gopay")
	@ResponseBody
	public String gopay(String orderid) throws BizException {
		Reserve objReserve = reserveMapper.selectByPrimaryKey(Integer.parseInt(orderid));
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		String infoString  = null;
		switch(objReserve.getConsumptionType()) {
	     case 1:
	    	 infoString = "天堂酒店房间预定";
	        break;
	     case 2:
	    	 infoString = "天堂酒店餐饮预定";
	        break;
	     case 3:
	    	 infoString = "天堂酒店娱乐预定";
	        break;
		} 
		
		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = objReserve.getReserveNumber();
		// 付款金额，必填
		Double total_amount = objReserve.getPayAmount();
		// 订单名称，必填
		String subject = infoString;
		// 商品描述，可空
		String body = "";

		// 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
		// 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
		String timeout_express = "30m";

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\"," + "\"timeout_express\":\""
				+ timeout_express + "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 请求
		String result;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
			throw new BizException("系统繁忙,请稍后再试！");
		}
		return result;
	}

	/**
	 * 同步请求处理订单
	 * @author Da
	 * @param request
	 * @param model
	 * @return
	 * @throws BizException
	 */
	@RequestMapping(value = "/alipay/alipayReturnNotice")
	public String alipayReturnNotice(HttpServletRequest request, ModelMap model) throws BizException {
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		boolean signVerified = false;
		try {
			// 调用SDK验证签名
			signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
					AlipayConfig.sign_type);
		} catch (AlipayApiException e) {
			e.printStackTrace();
			throw new BizException("系统繁忙,请稍后再试！");
		} 
		
		if (signVerified) {
			// 商户订单号
			String out_trade_no;
			// 支付宝交易号
			String trade_no;
			// 付款金额
			String total_amount;
			try {
				out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
				trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
				total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new BizException("系统繁忙,请稍后再试！");
			}

			// 修改支付状态，改为 支付成功，已付款;
			reserveBiz.updateStatus(out_trade_no);

			model.put("out_trade_no", out_trade_no);// 订单编号
			model.put("trade_no", trade_no);// 支付宝交易号
			model.put("total_amount", total_amount);// 实付金额
		} else {
			System.out.println("支付, 验签失败...");
		}
		return "front/alipaySuccess";
	}
	
//	@RequestMapping(value = "/alipay/alipayNotifyNotice")
//	@ResponseBody 
//	public String alipayNotifyNotice(HttpServletRequest request) throws Exception {
//	  
//	  //获取支付宝POST过来反馈信息
//		Map<String,String> params = new HashMap<String,String>();
//	  Map<String,String[]> requestParams = request.getParameterMap(); 
//	  for(Iterator<String> iter = requestParams.keySet().iterator();iter.hasNext();){ 
//		  String name = (String) iter.next(); 
//		  String[] values = (String[])requestParams.get(name);
//		  String valueStr = ""; 
//	  for (int i = 0; i < values.length; i++) { 
//		  valueStr = (i == values.length - 1) ? valueStr +values[i] : valueStr + values[i] + ",";
//		  } 
//	  //乱码解决，这段代码在出现乱码时使用 // 
//	  valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8"); 
//	  params.put(name,valueStr); 
//	  }
//		//调用SDK验证签名
//	  boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); 
//	  
//	  
//	  if(signVerified) {//验证成功 
//		//商户订单号 
//		  String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//	  
//	  //支付宝交易号 
//		  String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
//	  
//	  //交易状态 
//		  String trade_status = new  String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
//	  
//	  //付款金额
//		  String total_amount = new  String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
//	  
//	  if(trade_status.equals("TRADE_FINISHED")){ //判断该笔订单是否在商户网站中已经做过处理
//	  //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//	 //如果有做过处理，不执行商户的业务程序
//	  
//	  //注意： 尚自习的订单没有退款功能, 这个条件判断是进不来的, 所以此处不必写代码
//	  //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知 
//		  }else if
//	  (trade_status.equals("TRADE_SUCCESS")){ //判断该笔订单是否在商户网站中已经做过处理
//	  //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//	  //如果有做过处理，不执行商户的业务程序
//	  
//	 //注意： //付款完成后，支付宝系统发送该交易状态通知
//	  
//	  // 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水 //修改叮当状态，改为 支付成功，已付款; Orders orders=new
//	  
//	  
//	  //同时新增支付流水 Orders order2=ordersService.selectByPrimaryKey(out_trade_no); Flow
//	  
//	  
//	 }else {//验证失败 System.out.println("支付, 验签失败..."); }
//	 
//	 return "success"; 
//	 }
}
