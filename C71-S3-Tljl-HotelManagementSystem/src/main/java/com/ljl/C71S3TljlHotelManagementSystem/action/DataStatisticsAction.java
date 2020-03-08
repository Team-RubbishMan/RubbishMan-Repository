package com.ljl.C71S3TljlHotelManagementSystem.action;



import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljl.C71S3TljlHotelManagementSystem.biz.HomePageDataStatisticsBiz;

@Controller
public class DataStatisticsAction {

	@Resource
	private HomePageDataStatisticsBiz homePageDataStatisticsBiz;
	
	@GetMapping("/back/home.html")
	public String home(Model m) {
		m.addAttribute("orders", homePageDataStatisticsBiz.queryOrder());
		m.addAttribute("peoples", homePageDataStatisticsBiz.queryPeople());
		return "back/home";
	}
	@GetMapping("/back/billstatistics.html")
	public String home2(){
		return "back/billstatistics";
	}
	
	@PostMapping("/back/getDate")
	@ResponseBody
	public Map<String, String[]> getData() {
		
		String [] objHistoryDateArr = homePageDataStatisticsBiz.queryDate();
		String [] objHistoryCheckInNumberArr = homePageDataStatisticsBiz.queryObjHistoryCheckInNumber();
		String [] objHistoryCheckInOrderArr = homePageDataStatisticsBiz.queryObjHistoryCheckInOrder();
		
		//定义用于存放数据的Map集合
		Map<String, String[]> colHistoryDataMap = new HashMap<String, String[]>();
		colHistoryDataMap.put("objHistoryDateArr", objHistoryDateArr);
		colHistoryDataMap.put("objHistoryCheckInNumberArr", objHistoryCheckInNumberArr);
		colHistoryDataMap.put("objHistoryCheckInOrderArr", objHistoryCheckInOrderArr);
		
		return colHistoryDataMap;
	}
	
	@PostMapping("/back/getConsumptionAmount")
	@ResponseBody
	public Map<String, Object[]> getConsumptionAmount() throws ParseException {
		
		Map<String, Object[]> colConsumptionAmountMap = new HashMap<String, Object[]>();
		colConsumptionAmountMap.put("year", homePageDataStatisticsBiz.getYearConsumptionAmount());
		colConsumptionAmountMap.put("quarter", homePageDataStatisticsBiz.getQuarterConsumptionAmount());
		colConsumptionAmountMap.put("month", homePageDataStatisticsBiz.getMonthConsumptionAmount());
		colConsumptionAmountMap.put("getYear", homePageDataStatisticsBiz.getYear());
		colConsumptionAmountMap.put("getMonth", homePageDataStatisticsBiz.getMonth());
		
		return colConsumptionAmountMap;
	}
	
}
