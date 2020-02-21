package com.ljl.C71S3TljlHotelManagementSystem.action;



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
	
}
