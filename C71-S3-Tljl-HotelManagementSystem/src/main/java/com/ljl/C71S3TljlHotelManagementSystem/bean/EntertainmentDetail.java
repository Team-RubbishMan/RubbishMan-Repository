package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.sql.Timestamp;

public class EntertainmentDetail {
    private Integer id;

    private Timestamp payTime;

    private Integer entertainmentDeviceId;

    private Integer entertainmentOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Integer getEntertainmentDeviceId() {
        return entertainmentDeviceId;
    }

    public void setEntertainmentDeviceId(Integer entertainmentDeviceId) {
        this.entertainmentDeviceId = entertainmentDeviceId;
    }

    public Integer getEntertainmentOrderId() {
        return entertainmentOrderId;
    }

    public void setEntertainmentOrderId(Integer entertainmentOrderId) {
        this.entertainmentOrderId = entertainmentOrderId;
    }
}