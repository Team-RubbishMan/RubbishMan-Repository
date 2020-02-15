package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.Date;

public class FoodDetail {
    private Integer id;

    private Date diningTime;

    private Integer dishId;

    private Integer foodOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDiningTime() {
        return diningTime;
    }

    public void setDiningTime(Date diningTime) {
        this.diningTime = diningTime;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getFoodOrderId() {
        return foodOrderId;
    }

    public void setFoodOrderId(Integer foodOrderId) {
        this.foodOrderId = foodOrderId;
    }
}