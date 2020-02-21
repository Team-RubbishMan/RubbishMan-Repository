package com.ljl.C71S3TljlHotelManagementSystem.bean;

public class Room {

	private Integer id;

    private Integer roomTypeId;

    private Integer roomNumber;

    private Double amount;

    private String status;

    private String temp1;

    private String temp2;

    private String temp3;

    private RoomType roomType;
    
    @Override
	public String toString() {
		return "Room [id=" + id + ", roomTypeId=" + roomTypeId + ", roomNumber=" + roomNumber + ", amount=" + amount
				+ ", status=" + status + ", temp1=" + temp1 + ", temp2=" + temp2 + ", temp3=" + temp3 + ", roomType="
				+ roomType + "]";
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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