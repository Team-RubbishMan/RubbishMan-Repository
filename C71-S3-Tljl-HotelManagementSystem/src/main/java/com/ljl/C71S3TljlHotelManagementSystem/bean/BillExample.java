package com.ljl.C71S3TljlHotelManagementSystem.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BillExample() {
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

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("staff_id is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("staff_id =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("staff_id <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("staff_id >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("staff_id >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("staff_id <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("staff_id <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<Integer> values) {
            addCriterion("staff_id in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<Integer> values) {
            addCriterion("staff_id not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("staff_id between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("staff_id not between", value1, value2, "staffId");
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

        public Criteria andIndentIdIsNull() {
            addCriterion("indent_id is null");
            return (Criteria) this;
        }

        public Criteria andIndentIdIsNotNull() {
            addCriterion("indent_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndentIdEqualTo(Integer value) {
            addCriterion("indent_id =", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdNotEqualTo(Integer value) {
            addCriterion("indent_id <>", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdGreaterThan(Integer value) {
            addCriterion("indent_id >", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("indent_id >=", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdLessThan(Integer value) {
            addCriterion("indent_id <", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdLessThanOrEqualTo(Integer value) {
            addCriterion("indent_id <=", value, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdIn(List<Integer> values) {
            addCriterion("indent_id in", values, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdNotIn(List<Integer> values) {
            addCriterion("indent_id not in", values, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdBetween(Integer value1, Integer value2) {
            addCriterion("indent_id between", value1, value2, "indentId");
            return (Criteria) this;
        }

        public Criteria andIndentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("indent_id not between", value1, value2, "indentId");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountIsNull() {
            addCriterion("received_amount is null");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountIsNotNull() {
            addCriterion("received_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountEqualTo(Double value) {
            addCriterion("received_amount =", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountNotEqualTo(Double value) {
            addCriterion("received_amount <>", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountGreaterThan(Double value) {
            addCriterion("received_amount >", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("received_amount >=", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountLessThan(Double value) {
            addCriterion("received_amount <", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountLessThanOrEqualTo(Double value) {
            addCriterion("received_amount <=", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountIn(List<Double> values) {
            addCriterion("received_amount in", values, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountNotIn(List<Double> values) {
            addCriterion("received_amount not in", values, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountBetween(Double value1, Double value2) {
            addCriterion("received_amount between", value1, value2, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountNotBetween(Double value1, Double value2) {
            addCriterion("received_amount not between", value1, value2, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementIsNull() {
            addCriterion("refund_or_supplement is null");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementIsNotNull() {
            addCriterion("refund_or_supplement is not null");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementEqualTo(Double value) {
            addCriterion("refund_or_supplement =", value, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementNotEqualTo(Double value) {
            addCriterion("refund_or_supplement <>", value, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementGreaterThan(Double value) {
            addCriterion("refund_or_supplement >", value, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementGreaterThanOrEqualTo(Double value) {
            addCriterion("refund_or_supplement >=", value, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementLessThan(Double value) {
            addCriterion("refund_or_supplement <", value, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementLessThanOrEqualTo(Double value) {
            addCriterion("refund_or_supplement <=", value, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementIn(List<Double> values) {
            addCriterion("refund_or_supplement in", values, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementNotIn(List<Double> values) {
            addCriterion("refund_or_supplement not in", values, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementBetween(Double value1, Double value2) {
            addCriterion("refund_or_supplement between", value1, value2, "refundOrSupplement");
            return (Criteria) this;
        }

        public Criteria andRefundOrSupplementNotBetween(Double value1, Double value2) {
            addCriterion("refund_or_supplement not between", value1, value2, "refundOrSupplement");
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