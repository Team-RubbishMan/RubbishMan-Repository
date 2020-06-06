package com.ljl.C71S3TljlHotelManagementSystem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
	 * 获取一天前的23:59:59
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
	 * 获取一天前的23:59:59
	 * @return
	 */
	public Date getThisEndTime(Date date) {
		// 获取当前系统时间
		calendar.setTime(date);
		// 获取1天前结束的时间
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date endTime = (Date) calendar.getTime();
		return endTime;
	}
	
	/**
	 * @author Da
	 * 获取指定天数前的0:00:00
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
	
	/**
	 * 字符串转Date yyyy
	 * @author Da
	 * @param str 时间字符串
	 * @return
	 * @throws ParseException
	 */
	public Date toDateYear(String str) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		Date date = simpleDateFormat.parse(str);
		return date;
	}
	/**
	 * 字符串转Date yyyy-MM-dd
	 * @author Da
	 * @param str 时间字符串
	 * @return
	 * @throws ParseException
	 */
	public Date toDate(String str) throws ParseException {
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     Date date = simpleDateFormat.parse(str);
	     return date;
	}
	
	/**
	 * 字符串转Date yyyy-MM-dd hh:mm:ss
	 * @author Da
	 * @param str 时间字符串
	 * @return
	 * @throws ParseException
	 */
	public Date toDateTime(String str) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(str);
		return date;
	}
	
	/**
	 * 字符串转Date yyyy-MM-dd 23:00:00
	 * @author Da
	 * @param str 时间字符串
	 * @return
	 * @throws ParseException
	 */
	public Date toDateTimes(String str) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse(str);
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return date;
	}
	/**
	 * 获取今年时间
	 * @author Da
	 * @return
	 */
	public String getThisYear() {
		// 获取当前系统时间
		calendar.setTime(date);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		String date = simpleDateFormat.format(calendar.getTime());
		return date;
	}
	/**
	 * 获取去年时间
	 * @author Da
	 * @return
	 */
	public String getLastYear() {
		// 获取当前系统时间 
		calendar.setTime(date);
		calendar.add(1,-1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		String date = simpleDateFormat.format(calendar.getTime());
		return date;
	}
	/**
	 * 获取前年时间
	 * @author Da
	 * @return
	 */
	public String getBeforeYear() {
		// 获取当前系统时间
		calendar.setTime(date);
		calendar.add(1,-2);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		String date = simpleDateFormat.format(calendar.getTime());
		return date;
	}
	
//	/**
//	 * 获得本月第一天0点时间
//	 * @author Da
//	 * @return
//	 */
//    public Date getTimesMonthmorning() {  
//    	// 获取当前系统时间
//    	calendar.setTime(date); 
//    	calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
//    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));  
//        return calendar.getTime();  
//    }  
//  
//    /**
//	 * 获得本月最后一天24点时间 
//	 * @author Da
//	 * @return
//	 */
//    public Date getTimesMonthnight() {  
//    	// 获取当前系统时间
//    	calendar.setTime(date); 
//    	calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
//    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
//    	calendar.set(Calendar.HOUR_OF_DAY, 24);  
//        return calendar.getTime();  
//    }  
	
	/**
	 * 获取本年的季度
	 * @author Da
	 * @return
	 * @throws ParseException
	 */
    public List<Date> getQuarterOfYear() throws ParseException{
    	List<Date> quarterList = new ArrayList<Date>();
    	// 获取当前系统时间
    	calendar.setTime(date);
    	quarterList.add(new DateUtil().toDateTime(calendar.get(Calendar.YEAR)+"-1-1 0:00:00"));
    	quarterList.add(new DateUtil().toDateTime(calendar.get(Calendar.YEAR)+"-4-1 0:00:00"));
    	quarterList.add(new DateUtil().toDateTime(calendar.get(Calendar.YEAR)+"-7-1 0:00:00"));
    	quarterList.add(new DateUtil().toDateTime(calendar.get(Calendar.YEAR)+"-10-1 0:00:00"));
    	quarterList.add(new DateUtil().toDateTime(calendar.get(Calendar.YEAR)+"-12-31 23:59:59"));
    	
    	return quarterList;
    	
    }
	
	
	/**
	 * 获取当年所有月份
	 * @author Da
	 * @return
	 */
	public List<String> getMonthListOfYear() {
		List<String> list = new ArrayList<String>();
		calendar.setTime(date); 
		int year = calendar.get(Calendar.YEAR) + 1;
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.getActualMaximum(Calendar.DATE);
		for (int i = 1; i <= day; i++) {
			String aDate = String.valueOf(year)+"-"+month+"-"+i;
			list.add(aDate);
		}
		return list;
	}
    /**
     * 获取本月所有天数
     * @author Da
     * @return
     */
    public List<String> getDayListOfMonth() {
        List<String> list = new ArrayList<String>();
        calendar.setTime(date); 
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String aDate = String.valueOf(year)+"-"+month+"-"+i;
            list.add(aDate);
        }
        return list;
    }
}
