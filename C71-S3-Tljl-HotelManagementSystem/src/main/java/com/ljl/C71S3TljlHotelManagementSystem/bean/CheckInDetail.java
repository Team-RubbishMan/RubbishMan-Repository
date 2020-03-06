package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.Date;

public class CheckInDetail {
    private Integer id;

    private Date checkInTime;

    private Date checkOutTime;

    private Integer checkInNumber;

    private Integer roomId;

    private Integer orderId;

    private Integer roomTypeId;

    private String temp3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Integer getCheckInNumber() {
        return checkInNumber;
    }

    public void setCheckInNumber(Integer checkInNumber) {
        this.checkInNumber = checkInNumber;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }
}