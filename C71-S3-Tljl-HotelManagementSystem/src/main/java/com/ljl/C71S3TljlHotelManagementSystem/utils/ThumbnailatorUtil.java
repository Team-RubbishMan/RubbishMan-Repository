package com.ljl.C71S3TljlHotelManagementSystem.utils;

import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailatorUtil {
	public void changeImgSize(String originalAddress,String newAddress) throws IOException {
		Thumbnails.of(originalAddress).forceSize(50,50).toFile(newAddress);
		System.out.println("压缩成功");
	}
}
