package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudiomemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudiomemExample() {
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

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(String value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(String value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(String value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(String value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(String value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLike(String value) {
            addCriterion("stu_id like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotLike(String value) {
            addCriterion("stu_id not like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<String> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<String> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(String value1, String value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(String value1, String value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNull() {
            addCriterion("dev_id is null");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNotNull() {
            addCriterion("dev_id is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdEqualTo(String value) {
            addCriterion("dev_id =", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotEqualTo(String value) {
            addCriterion("dev_id <>", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThan(String value) {
            addCriterion("dev_id >", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThanOrEqualTo(String value) {
            addCriterion("dev_id >=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThan(String value) {
            addCriterion("dev_id <", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThanOrEqualTo(String value) {
            addCriterion("dev_id <=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLike(String value) {
            addCriterion("dev_id like", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotLike(String value) {
            addCriterion("dev_id not like", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdIn(List<String> values) {
            addCriterion("dev_id in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotIn(List<String> values) {
            addCriterion("dev_id not in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdBetween(String value1, String value2) {
            addCriterion("dev_id between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotBetween(String value1, String value2) {
            addCriterion("dev_id not between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andStumemPowerIsNull() {
            addCriterion("stumem_power is null");
            return (Criteria) this;
        }

        public Criteria andStumemPowerIsNotNull() {
            addCriterion("stumem_power is not null");
            return (Criteria) this;
        }

        public Criteria andStumemPowerEqualTo(Integer value) {
            addCriterion("stumem_power =", value, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerNotEqualTo(Integer value) {
            addCriterion("stumem_power <>", value, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerGreaterThan(Integer value) {
            addCriterion("stumem_power >", value, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("stumem_power >=", value, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerLessThan(Integer value) {
            addCriterion("stumem_power <", value, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerLessThanOrEqualTo(Integer value) {
            addCriterion("stumem_power <=", value, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerIn(List<Integer> values) {
            addCriterion("stumem_power in", values, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerNotIn(List<Integer> values) {
            addCriterion("stumem_power not in", values, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerBetween(Integer value1, Integer value2) {
            addCriterion("stumem_power between", value1, value2, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("stumem_power not between", value1, value2, "stumemPower");
            return (Criteria) this;
        }

        public Criteria andStumemIsIsNull() {
            addCriterion("stumem_is is null");
            return (Criteria) this;
        }

        public Criteria andStumemIsIsNotNull() {
            addCriterion("stumem_is is not null");
            return (Criteria) this;
        }

        public Criteria andStumemIsEqualTo(Integer value) {
            addCriterion("stumem_is =", value, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsNotEqualTo(Integer value) {
            addCriterion("stumem_is <>", value, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsGreaterThan(Integer value) {
            addCriterion("stumem_is >", value, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsGreaterThanOrEqualTo(Integer value) {
            addCriterion("stumem_is >=", value, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsLessThan(Integer value) {
            addCriterion("stumem_is <", value, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsLessThanOrEqualTo(Integer value) {
            addCriterion("stumem_is <=", value, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsIn(List<Integer> values) {
            addCriterion("stumem_is in", values, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsNotIn(List<Integer> values) {
            addCriterion("stumem_is not in", values, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsBetween(Integer value1, Integer value2) {
            addCriterion("stumem_is between", value1, value2, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemIsNotBetween(Integer value1, Integer value2) {
            addCriterion("stumem_is not between", value1, value2, "stumemIs");
            return (Criteria) this;
        }

        public Criteria andStumemSumIsNull() {
            addCriterion("stumem_sum is null");
            return (Criteria) this;
        }

        public Criteria andStumemSumIsNotNull() {
            addCriterion("stumem_sum is not null");
            return (Criteria) this;
        }

        public Criteria andStumemSumEqualTo(Integer value) {
            addCriterion("stumem_sum =", value, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumNotEqualTo(Integer value) {
            addCriterion("stumem_sum <>", value, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumGreaterThan(Integer value) {
            addCriterion("stumem_sum >", value, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stumem_sum >=", value, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumLessThan(Integer value) {
            addCriterion("stumem_sum <", value, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumLessThanOrEqualTo(Integer value) {
            addCriterion("stumem_sum <=", value, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumIn(List<Integer> values) {
            addCriterion("stumem_sum in", values, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumNotIn(List<Integer> values) {
            addCriterion("stumem_sum not in", values, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumBetween(Integer value1, Integer value2) {
            addCriterion("stumem_sum between", value1, value2, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemSumNotBetween(Integer value1, Integer value2) {
            addCriterion("stumem_sum not between", value1, value2, "stumemSum");
            return (Criteria) this;
        }

        public Criteria andStumemTimeIsNull() {
            addCriterion("stumem_time is null");
            return (Criteria) this;
        }

        public Criteria andStumemTimeIsNotNull() {
            addCriterion("stumem_time is not null");
            return (Criteria) this;
        }

        public Criteria andStumemTimeEqualTo(Date value) {
            addCriterion("stumem_time =", value, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeNotEqualTo(Date value) {
            addCriterion("stumem_time <>", value, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeGreaterThan(Date value) {
            addCriterion("stumem_time >", value, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stumem_time >=", value, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeLessThan(Date value) {
            addCriterion("stumem_time <", value, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeLessThanOrEqualTo(Date value) {
            addCriterion("stumem_time <=", value, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeIn(List<Date> values) {
            addCriterion("stumem_time in", values, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeNotIn(List<Date> values) {
            addCriterion("stumem_time not in", values, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeBetween(Date value1, Date value2) {
            addCriterion("stumem_time between", value1, value2, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemTimeNotBetween(Date value1, Date value2) {
            addCriterion("stumem_time not between", value1, value2, "stumemTime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeIsNull() {
            addCriterion("stumem_registime is null");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeIsNotNull() {
            addCriterion("stumem_registime is not null");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeEqualTo(Date value) {
            addCriterion("stumem_registime =", value, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeNotEqualTo(Date value) {
            addCriterion("stumem_registime <>", value, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeGreaterThan(Date value) {
            addCriterion("stumem_registime >", value, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stumem_registime >=", value, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeLessThan(Date value) {
            addCriterion("stumem_registime <", value, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeLessThanOrEqualTo(Date value) {
            addCriterion("stumem_registime <=", value, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeIn(List<Date> values) {
            addCriterion("stumem_registime in", values, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeNotIn(List<Date> values) {
            addCriterion("stumem_registime not in", values, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeBetween(Date value1, Date value2) {
            addCriterion("stumem_registime between", value1, value2, "stumemRegistime");
            return (Criteria) this;
        }

        public Criteria andStumemRegistimeNotBetween(Date value1, Date value2) {
            addCriterion("stumem_registime not between", value1, value2, "stumemRegistime");
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