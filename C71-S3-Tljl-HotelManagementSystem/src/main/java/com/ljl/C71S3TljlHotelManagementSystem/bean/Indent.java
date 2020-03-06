package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.Date;

public class Indent {
    private Integer id;

    private String orderNumber;

    private Integer userId;

    private Date orderTime;

    private Date eCheckInTime;

    private Date eCheckOutTime;

    private Double consumptionAmount;

    private String status;

    private String consumptionType;

    private String consumptionFigures;

    private String temp3;

    private User user;
    
    
    @Override
	public String toString() {
		return "Indent [id=" + id + ", orderNumber=" + orderNumber + ", userId=" + userId + ", orderTime=" + orderTime
				+ ", eCheckInTime=" + eCheckInTime + ", eCheckOutTime=" + eCheckOutTime + ", consumptionAmount="
				+ consumptionAmount + ", status=" + status + ", consumptionType=" + consumptionType
				+ ", consumptionFigures=" + consumptionFigures + ", temp3=" + temp3 + ", user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
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

    public String getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType == null ? null : consumptionType.trim();
    }

    public String getConsumptionFigures() {
        return consumptionFigures;
    }

    public void setConsumptionFigures(String consumptionFigures) {
        this.consumptionFigures = consumptionFigures == null ? null : consumptionFigures.trim();
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }
}