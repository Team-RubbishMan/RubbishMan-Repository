package com.ljl.C71S3TljlHotelManagementSystem.bean;

public class OrderForm {
	
	private Integer id;
	private String name;
	private String email;
	private Integer roomTypeId;
	private String inTime;
	private String outTime;
	private Integer number;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", name=" + name + ", email=" + email + ", roomTypeId=" + roomTypeId
				+ ", inTime=" + inTime + ", outTime=" + outTime + ", number=" + number + "]";
	}
	
	
	

}
