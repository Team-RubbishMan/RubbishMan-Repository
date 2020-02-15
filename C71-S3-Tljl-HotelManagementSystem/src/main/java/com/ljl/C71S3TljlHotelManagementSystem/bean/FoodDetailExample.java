package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoodDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDiningTimeIsNull() {
            addCriterion("dining_time is null");
            return (Criteria) this;
        }

        public Criteria andDiningTimeIsNotNull() {
            addCriterion("dining_time is not null");
            return (Criteria) this;
        }

        public Criteria andDiningTimeEqualTo(Date value) {
            addCriterion("dining_time =", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeNotEqualTo(Date value) {
            addCriterion("dining_time <>", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeGreaterThan(Date value) {
            addCriterion("dining_time >", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dining_time >=", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeLessThan(Date value) {
            addCriterion("dining_time <", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeLessThanOrEqualTo(Date value) {
            addCriterion("dining_time <=", value, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeIn(List<Date> values) {
            addCriterion("dining_time in", values, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeNotIn(List<Date> values) {
            addCriterion("dining_time not in", values, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeBetween(Date value1, Date value2) {
            addCriterion("dining_time between", value1, value2, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDiningTimeNotBetween(Date value1, Date value2) {
            addCriterion("dining_time not between", value1, value2, "diningTime");
            return (Criteria) this;
        }

        public Criteria andDishIdIsNull() {
            addCriterion("dish_id is null");
            return (Criteria) this;
        }

        public Criteria andDishIdIsNotNull() {
            addCriterion("dish_id is not null");
            return (Criteria) this;
        }

        public Criteria andDishIdEqualTo(Integer value) {
            addCriterion("dish_id =", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotEqualTo(Integer value) {
            addCriterion("dish_id <>", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdGreaterThan(Integer value) {
            addCriterion("dish_id >", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dish_id >=", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdLessThan(Integer value) {
            addCriterion("dish_id <", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdLessThanOrEqualTo(Integer value) {
            addCriterion("dish_id <=", value, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdIn(List<Integer> values) {
            addCriterion("dish_id in", values, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotIn(List<Integer> values) {
            addCriterion("dish_id not in", values, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdBetween(Integer value1, Integer value2) {
            addCriterion("dish_id between", value1, value2, "dishId");
            return (Criteria) this;
        }

        public Criteria andDishIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dish_id not between", value1, value2, "dishId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdIsNull() {
            addCriterion("food_order_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdIsNotNull() {
            addCriterion("food_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdEqualTo(Integer value) {
            addCriterion("food_order_id =", value, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdNotEqualTo(Integer value) {
            addCriterion("food_order_id <>", value, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdGreaterThan(Integer value) {
            addCriterion("food_order_id >", value, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_order_id >=", value, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdLessThan(Integer value) {
            addCriterion("food_order_id <", value, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("food_order_id <=", value, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdIn(List<Integer> values) {
            addCriterion("food_order_id in", values, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdNotIn(List<Integer> values) {
            addCriterion("food_order_id not in", values, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("food_order_id between", value1, value2, "foodOrderId");
            return (Criteria) this;
        }

        public Criteria andFoodOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("food_order_id not between", value1, value2, "foodOrderId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}