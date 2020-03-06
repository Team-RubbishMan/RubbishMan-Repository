package com.ljl.C71S3TljlHotelManagementSystem.utils;

import java.util.Random;

public class RandomUtil {

	private Random random = new Random();
	/**
     * 生成唯一的随机数
     * 格式:时间+随机数
     * */
    public synchronized String getUniqueKey(){//为了防止重复 加个synchronized
        Integer number=random.nextInt(900000)+100000;//六位随机数
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
