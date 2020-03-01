package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.List;

public class RoomType {
	private Integer id;

	private String type;

	private Double deposit;

	private Double amount;

	private List<Room> roomList;
	
	

	@Override
	public String toString() {
		return "RoomType [id=" + id + ", type=" + type + ", deposit=" + deposit + ", amount=" + amount + ", roomList="
				+ roomList + "]";
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}