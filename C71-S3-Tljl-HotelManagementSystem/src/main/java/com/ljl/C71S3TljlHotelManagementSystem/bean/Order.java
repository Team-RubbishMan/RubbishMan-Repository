package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;

    private Integer orderNumber;

    private Integer userId;

    private Date orderTime;

    private Date eCheckInTime;

    private Date eCheckOutTime;

    private Double consumptionAmount;

    private String status;

    private String temp1;

    private String temp2;

    private String temp3;
    
    private List<CheckInDetail> checkInDetailList;
    
    

    @Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", userId=" + userId + ", orderTime=" + orderTime
				+ ", eCheckInTime=" + eCheckInTime + ", eCheckOutTime=" + eCheckOutTime + ", consumptionAmount="
				+ consumptionAmount + ", status=" + status + ", temp1=" + temp1 + ", temp2=" + temp2 + ", temp3="
				+ temp3 + ", checkInDetail=" + checkInDetailList + "]";
	}

	public List<CheckInDetail> getCheckInDetail() {
		return checkInDetailList;
	}

	public void setCheckInDetail(List<CheckInDetail> checkInDetailList) {
		this.checkInDetailList = checkInDetailList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date geteCheckInTime() {
        return eCheckInTime;
    }

    public void seteCheckInTime(Date eCheckInTime) {
        this.eCheckInTime = eCheckInTime;
    }

    public Date geteCheckOutTime() {
        return eCheckOutTime;
    }

    public void seteCheckOutTime(Date eCheckOutTime) {
        this.eCheckOutTime = eCheckOutTime;
    }

    public Double getConsumptionAmount() {
        return consumptionAmount;
    }

    public void setConsumptionAmount(Double consumptionAmount) {
        this.consumptionAmount = consumptionAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }
}