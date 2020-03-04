package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.Date;

public class Reserve {
    private Integer id;

    private String reserveNumber;

    private Integer userId;

    private Double payAmount;

    private Integer payStatus;

    private Integer consumptionFigures;

    private Integer consumptionType;

    private Integer roomTypeId;

    private Integer numberOfRooms;

    private Integer numberOfEntertaiment;

    private Date dinnerTime;

    private Date reserveCheckInTime;

    private Date reserveCheckOutTime;

    private String email;

    private String temp2;

    private String temp3;
    
    private User user;
    
    
    @Override
	public String toString() {
		return "Reserve [id=" + id + ", reserveNumber=" + reserveNumber + ", userId=" + userId + ", payAmount="
				+ payAmount + ", payStatus=" + payStatus + ", consumptionFigures=" + consumptionFigures
				+ ", consumptionType=" + consumptionType + ", roomTypeId=" + roomTypeId + ", numberOfRooms="
				+ numberOfRooms + ", numberOfEntertaiment=" + numberOfEntertaiment + ", dinnerTime=" + dinnerTime
				+ ", reserveCheckInTime=" + reserveCheckInTime + ", reserveCheckOutTime=" + reserveCheckOutTime
				+ ", email=" + email + ", temp2=" + temp2 + ", temp3=" + temp3 + ", user=" + user + "]";
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

    public String getReserveNumber() {
        return reserveNumber;
    }

    public void setReserveNumber(String reserveNumber) {
        this.reserveNumber = reserveNumber == null ? null : reserveNumber.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getConsumptionFigures() {
        return consumptionFigures;
    }

    public void setConsumptionFigures(Integer consumptionFigures) {
        this.consumptionFigures = consumptionFigures;
    }

    public Integer getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(Integer consumptionType) {
        this.consumptionType = consumptionType;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfEntertaiment() {
        return numberOfEntertaiment;
    }

    public void setNumberOfEntertaiment(Integer numberOfEntertaiment) {
        this.numberOfEntertaiment = numberOfEntertaiment;
    }

    public Date getDinnerTime() {
        return dinnerTime;
    }

    public void setDinnerTime(Date dinnerTime) {
        this.dinnerTime = dinnerTime;
    }

    public Date getReserveCheckInTime() {
        return reserveCheckInTime;
    }

    public void setReserveCheckInTime(Date reserveCheckInTime) {
        this.reserveCheckInTime = reserveCheckInTime;
    }

    public Date getReserveCheckOutTime() {
        return reserveCheckOutTime;
    }

    public void setReserveCheckOutTime(Date reserveCheckOutTime) {
        this.reserveCheckOutTime = reserveCheckOutTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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