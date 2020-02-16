package com.ljl.C71S3TljlHotelManagementSystem.utils;

public class SensitiveInfoHidingUtil {
	/**
	 * 身份证隐藏
	 * @param idCard 身份证号
	 * @return 经过隐藏的身份证号
	 */
	public  String hidingIdcard(String idCard) {
		
		idCard = idCard.replaceAll("(\\d{6})\\d{8}(\\d{4})","$1********$2");
		return idCard;
	}
	/**
	 * 电话隐藏
	 * @param telephone 电话号码
	 * @return 经过隐藏的电话号码
	 */ 
	public  String hidingTel(String telephone) {
		telephone  = telephone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
		return telephone;
	}
	
}
