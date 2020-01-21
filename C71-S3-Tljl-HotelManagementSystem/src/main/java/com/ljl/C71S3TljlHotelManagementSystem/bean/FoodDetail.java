package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.sql.Timestamp;

public class FoodDetail {
    private Integer id;

    private Timestamp diningTime;

    private Integer dishId;

    private Integer foodOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDiningTime() {
        return diningTime;
    }

    public void setDiningTime(Timestamp diningTime) {
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