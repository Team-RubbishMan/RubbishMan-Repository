package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.Date;

public class EntertainmentDetail {
    private Integer id;

    private Date payTime;

    private Integer entertainmentDeviceId;

    private Integer entertainmentOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
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