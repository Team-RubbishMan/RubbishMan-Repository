package com.ljl.C71S3TljlHotelManagementSystem.bean;

public class Food {
    private Integer id;

    private String name;

    private Double price;

    private Integer foodTypeId;
    
    private FoodType foodType;

    
    @Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", price=" + price + ", foodTypeId=" + foodTypeId + ", foodType="
				+ foodType + "]";
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

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
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(Integer foodTypeId) {
        this.foodTypeId = foodTypeId;
    }
}