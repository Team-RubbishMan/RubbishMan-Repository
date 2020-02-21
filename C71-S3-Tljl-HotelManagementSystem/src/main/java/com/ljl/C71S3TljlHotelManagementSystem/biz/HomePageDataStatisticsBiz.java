package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetailExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.CheckInDetailMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.DateUtil;

@Service
public class HomePageDataStatisticsBiz {

	@Resource
	private CheckInDetailMapper checkInDetailMapper;
	//实例化日期工具
	private DateUtil objDateUtil = new DateUtil();
	
	/**
	 * @author Da
	 * 查询昨天订单数
	 * @return 
	 */
	public int queryOrder() {
		CheckInDetailExample objCheckInDetailExample = new CheckInDetailExample();
		objCheckInDetailExample.createCriteria().andCheckInTimeBetween(objDateUtil.getStartTime(), objDateUtil.getEndTime());
		
		List<CheckInDetail> lstCheckInDetails = checkInDetailMapper.selectByExample(objCheckInDetailExample);
		for (CheckInDetail checkInDetail : lstCheckInDetails) {
			System.out.println(checkInDetail.toString());
		}
		return lstCheckInDetails.size();
	}
	
	/**
	 * @author Da
	 * 查询昨天入住人数
	 * @return 
	 */
	public int queryPeople() {
		CheckInDetailExample objCheckInDetailExample = new CheckInDetailExample();
		objCheckInDetailExample.createCriteria().andCheckInTimeBetween(objDateUtil.getStartTime(), objDateUtil.getEndTime());
		
		List<CheckInDetail> lstCheckInDetails = checkInDetailMapper.selectByExample(objCheckInDetailExample);
		
		//记录入住人数
		int iTotal = 0;
		for (CheckInDetail checkInDetail : lstCheckInDetails) {
			iTotal += checkInDetail.getCheckInNumber();
		}
		return iTotal;
	}
	
	/**
	 * @author Da
	 * 查询前七天的日期
	 * @return
	 */
	public String[] queryDate() {
		String[] beforeSevenDay = objDateUtil.getBeforeSevenDay();
		return beforeSevenDay;
	}
	
	/**
	 * @author Da
	 * 分别查询前七天的历史入住人数
	 * @return 
	 */
	public String[] queryObjHistoryCheckInNumber() {
		CheckInDetailExample objCheckInDetailExample = new CheckInDetailExample();
		Map<Integer, List<CheckInDetail>> colHistoryCheckInNumberMap = new HashMap<Integer, List<CheckInDetail>>();
		
		for (int i = 1; i <= 7; i++) {
			objCheckInDetailExample.clear();
			objCheckInDetailExample.createCriteria().andCheckInTimeBetween(objDateUtil.getStartTime(i), objDateUtil.getEndTime(i));
			colHistoryCheckInNumberMap.put(i, checkInDetailMapper.selectByExample(objCheckInDetailExample));
		}
		//记录入住人数
		String[] iHistoryCheckInNumber1 = new String[7];
		//记录一天的入住人数
		int iTotal = 0;
		for (int i = 1; i <= 7; i++) {
			iTotal = 0;
			for (CheckInDetail checkInDetail : colHistoryCheckInNumberMap.get(i)) {
				iTotal += checkInDetail.getCheckInNumber();
			}
			iHistoryCheckInNumber1[i-1] = String.valueOf(iTotal);
		}
		//反转数组内容
		String[] iHistoryCheckInNumber2 = new String[7];
		for (int i = 0; i < iHistoryCheckInNumber1.length; i++) {
			iHistoryCheckInNumber2[i] = iHistoryCheckInNumber1[iHistoryCheckInNumber1.length-i-1];
		}
		return iHistoryCheckInNumber2;
	}
	
	/**
	 * @author Da
	 * 分别查询前七天的历史订单数
	 * @return 
	 */
	public String[] queryObjHistoryCheckInOrder() {
		CheckInDetailExample objCheckInDetailExample = new CheckInDetailExample();
		Map<Integer, Integer> colHistoryCheckInOrderMap = new HashMap<Integer, Integer>();
		
		for (int i = 1; i <= 7; i++) {
			//每次查询前先清除上一次查询的条件
			objCheckInDetailExample.clear();
			objCheckInDetailExample.createCriteria().andCheckInTimeBetween(objDateUtil.getStartTime(i), objDateUtil.getEndTime(i));
			colHistoryCheckInOrderMap.put(i, checkInDetailMapper.selectByExample(objCheckInDetailExample).size());
		}
		//记录入住人数
		String[] iHistoryCheckInOrder1 = new String[7];
		//记录一天的入住人数
		for (int i = 1; i <= 7; i++) {
			iHistoryCheckInOrder1[i-1] = String.valueOf(colHistoryCheckInOrderMap.get(i));
		}
		//反转数组内容
		String[] iHistoryCheckInOrder2 = new String[7];
		for (int i = 0; i < iHistoryCheckInOrder1.length; i++) {
			iHistoryCheckInOrder2[i] = iHistoryCheckInOrder1[iHistoryCheckInOrder1.length-i-1];
		}
		return iHistoryCheckInOrder2;
	}
}
