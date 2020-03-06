package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReserveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReserveExample() {
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

        public Criteria andReserveNumberIsNull() {
            addCriterion("reserve_number is null");
            return (Criteria) this;
        }

        public Criteria andReserveNumberIsNotNull() {
            addCriterion("reserve_number is not null");
            return (Criteria) this;
        }

        public Criteria andReserveNumberEqualTo(String value) {
            addCriterion("reserve_number =", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberNotEqualTo(String value) {
            addCriterion("reserve_number <>", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberGreaterThan(String value) {
            addCriterion("reserve_number >", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberGreaterThanOrEqualTo(String value) {
            addCriterion("reserve_number >=", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberLessThan(String value) {
            addCriterion("reserve_number <", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberLessThanOrEqualTo(String value) {
            addCriterion("reserve_number <=", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberLike(String value) {
            addCriterion("reserve_number like", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberNotLike(String value) {
            addCriterion("reserve_number not like", value, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberIn(List<String> values) {
            addCriterion("reserve_number in", values, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberNotIn(List<String> values) {
            addCriterion("reserve_number not in", values, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberBetween(String value1, String value2) {
            addCriterion("reserve_number between", value1, value2, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andReserveNumberNotBetween(String value1, String value2) {
            addCriterion("reserve_number not between", value1, value2, "reserveNumber");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(Double value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(Double value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(Double value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(Double value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(Double value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<Double> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<Double> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(Double value1, Double value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(Double value1, Double value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresIsNull() {
            addCriterion("consumption_figures is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresIsNotNull() {
            addCriterion("consumption_figures is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresEqualTo(Integer value) {
            addCriterion("consumption_figures =", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresNotEqualTo(Integer value) {
            addCriterion("consumption_figures <>", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresGreaterThan(Integer value) {
            addCriterion("consumption_figures >", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresGreaterThanOrEqualTo(Integer value) {
            addCriterion("consumption_figures >=", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresLessThan(Integer value) {
            addCriterion("consumption_figures <", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresLessThanOrEqualTo(Integer value) {
            addCriterion("consumption_figures <=", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresIn(List<Integer> values) {
            addCriterion("consumption_figures in", values, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresNotIn(List<Integer> values) {
            addCriterion("consumption_figures not in", values, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresBetween(Integer value1, Integer value2) {
            addCriterion("consumption_figures between", value1, value2, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresNotBetween(Integer value1, Integer value2) {
            addCriterion("consumption_figures not between", value1, value2, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeIsNull() {
            addCriterion("consumption_type is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeIsNotNull() {
            addCriterion("consumption_type is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeEqualTo(Integer value) {
            addCriterion("consumption_type =", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeNotEqualTo(Integer value) {
            addCriterion("consumption_type <>", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeGreaterThan(Integer value) {
            addCriterion("consumption_type >", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("consumption_type >=", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeLessThan(Integer value) {
            addCriterion("consumption_type <", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("consumption_type <=", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeIn(List<Integer> values) {
            addCriterion("consumption_type in", values, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeNotIn(List<Integer> values) {
            addCriterion("consumption_type not in", values, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeBetween(Integer value1, Integer value2) {
            addCriterion("consumption_type between", value1, value2, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("consumption_type not between", value1, value2, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdIsNull() {
            addCriterion("room_type_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdIsNotNull() {
            addCriterion("room_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdEqualTo(Integer value) {
            addCriterion("room_type_id =", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotEqualTo(Integer value) {
            addCriterion("room_type_id <>", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdGreaterThan(Integer value) {
            addCriterion("room_type_id >", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_type_id >=", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdLessThan(Integer value) {
            addCriterion("room_type_id <", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_type_id <=", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdIn(List<Integer> values) {
            addCriterion("room_type_id in", values, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotIn(List<Integer> values) {
            addCriterion("room_type_id not in", values, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("room_type_id between", value1, value2, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_type_id not between", value1, value2, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsIsNull() {
            addCriterion("number_of_rooms is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsIsNotNull() {
            addCriterion("number_of_rooms is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsEqualTo(Integer value) {
            addCriterion("number_of_rooms =", value, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsNotEqualTo(Integer value) {
            addCriterion("number_of_rooms <>", value, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsGreaterThan(Integer value) {
            addCriterion("number_of_rooms >", value, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_of_rooms >=", value, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsLessThan(Integer value) {
            addCriterion("number_of_rooms <", value, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsLessThanOrEqualTo(Integer value) {
            addCriterion("number_of_rooms <=", value, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsIn(List<Integer> values) {
            addCriterion("number_of_rooms in", values, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsNotIn(List<Integer> values) {
            addCriterion("number_of_rooms not in", values, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsBetween(Integer value1, Integer value2) {
            addCriterion("number_of_rooms between", value1, value2, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfRoomsNotBetween(Integer value1, Integer value2) {
            addCriterion("number_of_rooms not between", value1, value2, "numberOfRooms");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentIsNull() {
            addCriterion("number_of_entertaiment is null");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentIsNotNull() {
            addCriterion("number_of_entertaiment is not null");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentEqualTo(Integer value) {
            addCriterion("number_of_entertaiment =", value, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentNotEqualTo(Integer value) {
            addCriterion("number_of_entertaiment <>", value, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentGreaterThan(Integer value) {
            addCriterion("number_of_entertaiment >", value, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentGreaterThanOrEqualTo(Integer value) {
            addCriterion("number_of_entertaiment >=", value, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentLessThan(Integer value) {
            addCriterion("number_of_entertaiment <", value, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentLessThanOrEqualTo(Integer value) {
            addCriterion("number_of_entertaiment <=", value, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentIn(List<Integer> values) {
            addCriterion("number_of_entertaiment in", values, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentNotIn(List<Integer> values) {
            addCriterion("number_of_entertaiment not in", values, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentBetween(Integer value1, Integer value2) {
            addCriterion("number_of_entertaiment between", value1, value2, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andNumberOfEntertaimentNotBetween(Integer value1, Integer value2) {
            addCriterion("number_of_entertaiment not between", value1, value2, "numberOfEntertaiment");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeIsNull() {
            addCriterion("dinner_time is null");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeIsNotNull() {
            addCriterion("dinner_time is not null");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeEqualTo(Date value) {
            addCriterion("dinner_time =", value, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeNotEqualTo(Date value) {
            addCriterion("dinner_time <>", value, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeGreaterThan(Date value) {
            addCriterion("dinner_time >", value, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dinner_time >=", value, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeLessThan(Date value) {
            addCriterion("dinner_time <", value, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeLessThanOrEqualTo(Date value) {
            addCriterion("dinner_time <=", value, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeIn(List<Date> values) {
            addCriterion("dinner_time in", values, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeNotIn(List<Date> values) {
            addCriterion("dinner_time not in", values, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeBetween(Date value1, Date value2) {
            addCriterion("dinner_time between", value1, value2, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andDinnerTimeNotBetween(Date value1, Date value2) {
            addCriterion("dinner_time not between", value1, value2, "dinnerTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeIsNull() {
            addCriterion("reserve_check_in_time is null");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeIsNotNull() {
            addCriterion("reserve_check_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeEqualTo(Date value) {
            addCriterion("reserve_check_in_time =", value, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeNotEqualTo(Date value) {
            addCriterion("reserve_check_in_time <>", value, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeGreaterThan(Date value) {
            addCriterion("reserve_check_in_time >", value, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reserve_check_in_time >=", value, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeLessThan(Date value) {
            addCriterion("reserve_check_in_time <", value, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeLessThanOrEqualTo(Date value) {
            addCriterion("reserve_check_in_time <=", value, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeIn(List<Date> values) {
            addCriterion("reserve_check_in_time in", values, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeNotIn(List<Date> values) {
            addCriterion("reserve_check_in_time not in", values, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeBetween(Date value1, Date value2) {
            addCriterion("reserve_check_in_time between", value1, value2, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckInTimeNotBetween(Date value1, Date value2) {
            addCriterion("reserve_check_in_time not between", value1, value2, "reserveCheckInTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeIsNull() {
            addCriterion("reserve_check_out_time is null");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeIsNotNull() {
            addCriterion("reserve_check_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeEqualTo(Date value) {
            addCriterion("reserve_check_out_time =", value, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeNotEqualTo(Date value) {
            addCriterion("reserve_check_out_time <>", value, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeGreaterThan(Date value) {
            addCriterion("reserve_check_out_time >", value, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reserve_check_out_time >=", value, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeLessThan(Date value) {
            addCriterion("reserve_check_out_time <", value, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("reserve_check_out_time <=", value, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeIn(List<Date> values) {
            addCriterion("reserve_check_out_time in", values, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeNotIn(List<Date> values) {
            addCriterion("reserve_check_out_time not in", values, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeBetween(Date value1, Date value2) {
            addCriterion("reserve_check_out_time between", value1, value2, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andReserveCheckOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("reserve_check_out_time not between", value1, value2, "reserveCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTemp3IsNull() {
            addCriterion("temp3 is null");
            return (Criteria) this;
        }

        public Criteria andTemp3IsNotNull() {
            addCriterion("temp3 is not null");
            return (Criteria) this;
        }

        public Criteria andTemp3EqualTo(String value) {
            addCriterion("temp3 =", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3NotEqualTo(String value) {
            addCriterion("temp3 <>", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3GreaterThan(String value) {
            addCriterion("temp3 >", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3GreaterThanOrEqualTo(String value) {
            addCriterion("temp3 >=", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3LessThan(String value) {
            addCriterion("temp3 <", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3LessThanOrEqualTo(String value) {
            addCriterion("temp3 <=", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3Like(String value) {
            addCriterion("temp3 like", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3NotLike(String value) {
            addCriterion("temp3 not like", value, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3In(List<String> values) {
            addCriterion("temp3 in", values, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3NotIn(List<String> values) {
            addCriterion("temp3 not in", values, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3Between(String value1, String value2) {
            addCriterion("temp3 between", value1, value2, "temp3");
            return (Criteria) this;
        }

        public Criteria andTemp3NotBetween(String value1, String value2) {
            addCriterion("temp3 not between", value1, value2, "temp3");
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