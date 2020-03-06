package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndentExample() {
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
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

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeIsNull() {
            addCriterion("e_check_in_time is null");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeIsNotNull() {
            addCriterion("e_check_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeEqualTo(Date value) {
            addCriterion("e_check_in_time =", value, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeNotEqualTo(Date value) {
            addCriterion("e_check_in_time <>", value, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeGreaterThan(Date value) {
            addCriterion("e_check_in_time >", value, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("e_check_in_time >=", value, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeLessThan(Date value) {
            addCriterion("e_check_in_time <", value, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeLessThanOrEqualTo(Date value) {
            addCriterion("e_check_in_time <=", value, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeIn(List<Date> values) {
            addCriterion("e_check_in_time in", values, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeNotIn(List<Date> values) {
            addCriterion("e_check_in_time not in", values, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeBetween(Date value1, Date value2) {
            addCriterion("e_check_in_time between", value1, value2, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckInTimeNotBetween(Date value1, Date value2) {
            addCriterion("e_check_in_time not between", value1, value2, "eCheckInTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeIsNull() {
            addCriterion("e_check_out_time is null");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeIsNotNull() {
            addCriterion("e_check_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeEqualTo(Date value) {
            addCriterion("e_check_out_time =", value, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeNotEqualTo(Date value) {
            addCriterion("e_check_out_time <>", value, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeGreaterThan(Date value) {
            addCriterion("e_check_out_time >", value, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("e_check_out_time >=", value, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeLessThan(Date value) {
            addCriterion("e_check_out_time <", value, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("e_check_out_time <=", value, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeIn(List<Date> values) {
            addCriterion("e_check_out_time in", values, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeNotIn(List<Date> values) {
            addCriterion("e_check_out_time not in", values, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeBetween(Date value1, Date value2) {
            addCriterion("e_check_out_time between", value1, value2, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andECheckOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("e_check_out_time not between", value1, value2, "eCheckOutTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountIsNull() {
            addCriterion("consumption_amount is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountIsNotNull() {
            addCriterion("consumption_amount is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountEqualTo(Double value) {
            addCriterion("consumption_amount =", value, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountNotEqualTo(Double value) {
            addCriterion("consumption_amount <>", value, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountGreaterThan(Double value) {
            addCriterion("consumption_amount >", value, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("consumption_amount >=", value, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountLessThan(Double value) {
            addCriterion("consumption_amount <", value, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountLessThanOrEqualTo(Double value) {
            addCriterion("consumption_amount <=", value, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountIn(List<Double> values) {
            addCriterion("consumption_amount in", values, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountNotIn(List<Double> values) {
            addCriterion("consumption_amount not in", values, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountBetween(Double value1, Double value2) {
            addCriterion("consumption_amount between", value1, value2, "consumptionAmount");
            return (Criteria) this;
        }

        public Criteria andConsumptionAmountNotBetween(Double value1, Double value2) {
            addCriterion("consumption_amount not between", value1, value2, "consumptionAmount");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andConsumptionTypeEqualTo(String value) {
            addCriterion("consumption_type =", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeNotEqualTo(String value) {
            addCriterion("consumption_type <>", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeGreaterThan(String value) {
            addCriterion("consumption_type >", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("consumption_type >=", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeLessThan(String value) {
            addCriterion("consumption_type <", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeLessThanOrEqualTo(String value) {
            addCriterion("consumption_type <=", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeLike(String value) {
            addCriterion("consumption_type like", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeNotLike(String value) {
            addCriterion("consumption_type not like", value, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeIn(List<String> values) {
            addCriterion("consumption_type in", values, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeNotIn(List<String> values) {
            addCriterion("consumption_type not in", values, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeBetween(String value1, String value2) {
            addCriterion("consumption_type between", value1, value2, "consumptionType");
            return (Criteria) this;
        }

        public Criteria andConsumptionTypeNotBetween(String value1, String value2) {
            addCriterion("consumption_type not between", value1, value2, "consumptionType");
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

        public Criteria andConsumptionFiguresEqualTo(String value) {
            addCriterion("consumption_figures =", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresNotEqualTo(String value) {
            addCriterion("consumption_figures <>", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresGreaterThan(String value) {
            addCriterion("consumption_figures >", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresGreaterThanOrEqualTo(String value) {
            addCriterion("consumption_figures >=", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresLessThan(String value) {
            addCriterion("consumption_figures <", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresLessThanOrEqualTo(String value) {
            addCriterion("consumption_figures <=", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresLike(String value) {
            addCriterion("consumption_figures like", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresNotLike(String value) {
            addCriterion("consumption_figures not like", value, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresIn(List<String> values) {
            addCriterion("consumption_figures in", values, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresNotIn(List<String> values) {
            addCriterion("consumption_figures not in", values, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresBetween(String value1, String value2) {
            addCriterion("consumption_figures between", value1, value2, "consumptionFigures");
            return (Criteria) this;
        }

        public Criteria andConsumptionFiguresNotBetween(String value1, String value2) {
            addCriterion("consumption_figures not between", value1, value2, "consumptionFigures");
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