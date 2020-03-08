package com.ljl.C71S3TljlHotelManagementSystem.biz;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljl.C71S3TljlHotelManagementSystem.bean.Bill;
import com.ljl.C71S3TljlHotelManagementSystem.bean.BillExample;
import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetail;
import com.ljl.C71S3TljlHotelManagementSystem.bean.CheckInDetailExample;
import com.ljl.C71S3TljlHotelManagementSystem.dao.BillMapper;
import com.ljl.C71S3TljlHotelManagementSystem.dao.CheckInDetailMapper;
import com.ljl.C71S3TljlHotelManagementSystem.utils.DateUtil;

@Service
public class HomePageDataStatisticsBiz {

	@Resource
	private CheckInDetailMapper checkInDetailMapper;
	@Resource
	private BillMapper billMapper;
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
	
	/**
	 * 年度账单
	 * @author Da
	 * @return
	 * @throws ParseException
	 */
	public Double[] getYearConsumptionAmount() throws ParseException {
		BillExample objBillExample = new BillExample();
		objBillExample.createCriteria().andRecordTimeBetween(objDateUtil.toDateYear(objDateUtil.getBeforeYear()),objDateUtil.toDateYear(objDateUtil.getLastYear()));
		List<Bill> beforeYearBill = billMapper.selectByExample(objBillExample);
		Double objbeforeYearConsumptionAmount = 0.0;
		for (Bill bill : beforeYearBill) {
			objbeforeYearConsumptionAmount += bill.getConsumptionAmount();
		}
		
		objBillExample.clear();
		objBillExample.createCriteria().andRecordTimeBetween(objDateUtil.toDateYear(objDateUtil.getLastYear()),objDateUtil.toDateYear(objDateUtil.getThisYear()));
		List<Bill> lastYearBill = billMapper.selectByExample(objBillExample);
		Double objlastYearConsumptionAmount = 0.0;
		for (Bill bill : lastYearBill) {
			objlastYearConsumptionAmount += bill.getConsumptionAmount();
		}
		
		objBillExample.clear();
		objBillExample.createCriteria().andRecordTimeGreaterThanOrEqualTo(objDateUtil.toDateYear(objDateUtil.getThisYear()));
		List<Bill> thisYearBill = billMapper.selectByExample(objBillExample);
		Double objthisYearConsumptionAmount = 0.0;
		for (Bill bill : thisYearBill) {
			objthisYearConsumptionAmount += bill.getConsumptionAmount();
		}
		
		Double [] consumptionAmountStrings = new Double[3];
		consumptionAmountStrings[0] = objbeforeYearConsumptionAmount;
		consumptionAmountStrings[1] = objlastYearConsumptionAmount;
		consumptionAmountStrings[2] = objthisYearConsumptionAmount;
		
		return consumptionAmountStrings;
	}
	
	/**
	 * 获取年份标签
	 * @author Da
	 * @return
	 */
	public String[] getYear() {
		String[] yearStrings = new String[3];
		yearStrings[0] = objDateUtil.getBeforeYear();
		yearStrings[1] = objDateUtil.getLastYear();
		yearStrings[2] = objDateUtil.getThisYear();
		
		return yearStrings;
	}
 	
	/**
	 * 季度账单
	 * @author Da
	 * @return
	 * @throws ParseException
	 */
	public Double[] getQuarterConsumptionAmount() throws ParseException {
		BillExample objBillExample = new BillExample();
		List<Date> quarterOfYear = objDateUtil.getQuarterOfYear();
		Double[] quarterDoubles = new Double[5];
		
		for (int i = 0; i < quarterOfYear.size(); i++) {
			objBillExample.clear();
			
			if(i+1==quarterOfYear.size()) {
				objBillExample.createCriteria().andRecordTimeGreaterThanOrEqualTo(quarterOfYear.get(i));
			}else {
				objBillExample.createCriteria().andRecordTimeBetween(quarterOfYear.get(i), quarterOfYear.get(i+1));
			}
			
			List<Bill> quarterConsumptionAmount = billMapper.selectByExample(objBillExample);
			
			if(quarterConsumptionAmount.size()==0) {
				quarterDoubles[i] = 0.0;
			}else {
				Double objQuarterConsumptionAmount = 0.0;
				for (Bill bill : quarterConsumptionAmount) {
					objQuarterConsumptionAmount += bill.getConsumptionAmount();
				}
				quarterDoubles[i] = objQuarterConsumptionAmount;
			}
		}
		Double[] tempQuarterDoubles = new Double[4];
		for (int i = 0; i < tempQuarterDoubles.length; i++) {
			tempQuarterDoubles[i] = quarterDoubles[i];
		}
		return tempQuarterDoubles;
	}
	
	/**
	 * 本月账单
	 * @author Da
	 * @return
	 * @throws ParseException
	 */
	public Double[] getMonthConsumptionAmount() throws ParseException {
		BillExample objBillExample = new BillExample();
		List<String> dayListOfMonth = objDateUtil.getDayListOfMonth();
		Double[] monthDoubles = new Double[dayListOfMonth.size()];
		
		for (int i = 0; i < dayListOfMonth.size(); i++) {
			objBillExample.clear();
			
			if(i+1==dayListOfMonth.size()) {
				objBillExample.createCriteria().andRecordTimeGreaterThanOrEqualTo(objDateUtil.toDate(dayListOfMonth.get(i)));
			}else {
				objBillExample.createCriteria().andRecordTimeBetween(objDateUtil.toDate(dayListOfMonth.get(i)), objDateUtil.toDate(dayListOfMonth.get(i+1)));
			}
			
			List<Bill> dayConsumptionAmount = billMapper.selectByExample(objBillExample);
			
			if(dayConsumptionAmount.size()==0) {
				monthDoubles[i] = 0.0;
			}else {
				monthDoubles[i] = dayConsumptionAmount.get(0).getConsumptionAmount();
			}
		}
		
		return monthDoubles;
	}
	
	/**
	 * 获取月份标签
	 * @author Da
	 * @return
	 */
	public String[] getMonth() {
		String[] yearStrings = new String[objDateUtil.getDayListOfMonth().size()];
		for (int i = 0; i < objDateUtil.getDayListOfMonth().size(); i++) {
			yearStrings[i] = String.valueOf(i+1);
		}
		return yearStrings;
	}
	
}
