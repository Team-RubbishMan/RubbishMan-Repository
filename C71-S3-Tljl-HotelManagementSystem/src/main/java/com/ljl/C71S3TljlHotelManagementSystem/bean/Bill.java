package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.Date;

public class Bill {
    private Integer id;

    private Date recordTime;

    private Integer staffId;

    private Integer userId;

    private Double consumptionAmount;

    private Integer indentId;

    private Double receivedAmount;

    private Double refundOrSupplement;

    private String temp3;
    private User user; 
    private Staff staff; 
    private Indent indent;


    @Override
	public String toString() {
		return "Bill [id=" + id + ", recordTime=" + recordTime + ", staffId=" + staffId + ", userId=" + userId
				+ ", consumptionAmount=" + consumptionAmount + ", indentId=" + indentId + ", receivedAmount="
				+ receivedAmount + ", refundOrSupplement=" + refundOrSupplement + ", temp3=" + temp3 + ", user=" + user
				+ ", staff=" + staff + ", indent=" + indent + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Indent getIndent() {
		return indent;
	}

	public void setIndent(Indent indent) {
		this.indent = indent;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getConsumptionAmount() {
        return consumptionAmount;
    }

    public void setConsumptionAmount(Double consumptionAmount) {
        this.consumptionAmount = consumptionAmount;
    }

    public Integer getIndentId() {
        return indentId;
    }

    public void setIndentId(Integer indentId) {
        this.indentId = indentId;
    }

    public Double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(Double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public Double getRefundOrSupplement() {
        return refundOrSupplement;
    }

    public void setRefundOrSupplement(Double refundOrSupplement) {
        this.refundOrSupplement = refundOrSupplement;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }
}