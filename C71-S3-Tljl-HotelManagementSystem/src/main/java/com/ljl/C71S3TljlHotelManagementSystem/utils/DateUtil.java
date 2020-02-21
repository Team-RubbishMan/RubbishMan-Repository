package com.ljl.C71S3TljlHotelManagementSystem.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	//获取当天日期
	private Date date = new Date();
	//实例化日历对象
	private Calendar calendar = Calendar.getInstance() ;

	/**
	 * @author Da
	 * 获取一天前的0:0:0
	 * @return
	 */
	public Date getStartTime() {
		// 获取当前系统时间
		calendar.setTime(date);
		// 获取1天前开始的时间
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date startTime = (Date) calendar.getTime();
		return startTime;
	}
	
	/**
	 * @author Da
	 * 获取一天前的0:0:0
	 * @return
	 */
	public Date getEndTime() {
		// 获取当前系统时间
		calendar.setTime(date);
		// 获取1天前结束的时间
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date endTime = (Date) calendar.getTime();
		return endTime;
	}
	
	/**
	 * @author Da
	 * 获取指定天数前的23:59:59
	 * @param iDay 天数
	 * @return
	 */
	public Date getStartTime(int iDay) {
		// 获取当前系统时间
		calendar.setTime(date);
		// 获取1天前开始的时间
		calendar.add(Calendar.DAY_OF_MONTH, -iDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date startTime = (Date) calendar.getTime();
		return startTime;
	}
	
	/**
	 * @author Da
	 * 获取指定天数前的23:59:59
	 * @param iDay 天数
	 * @return
	 */
	public Date getEndTime(int iDay) {
		// 获取当前系统时间
		calendar.setTime(date);
		// 获取当天结束的时间
		calendar.add(Calendar.DAY_OF_MONTH, -iDay);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date endTime = (Date) calendar.getTime();
		return endTime;
	}
	
	/**
	 * @author Da
	 * 获取前七天的日期
	 * @return
	 */
	public String [] getBeforeSevenDay(){
        String [] dateArr = new String[7];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = null;
        for (int i=0;i<7;i++){
            c=Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, - i-1);
            dateArr[6-i] =sdf.format(c.getTime());
        }
        return dateArr;
     }
	
}
