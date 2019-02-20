package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PositionmemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionmemExample() {
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

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(String value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(String value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(String value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(String value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(String value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLike(String value) {
            addCriterion("position_id like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotLike(String value) {
            addCriterion("position_id not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<String> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<String> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(String value1, String value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(String value1, String value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdIsNull() {
            addCriterion("positionmem_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdIsNotNull() {
            addCriterion("positionmem_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdEqualTo(String value) {
            addCriterion("positionmem_id =", value, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdNotEqualTo(String value) {
            addCriterion("positionmem_id <>", value, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdGreaterThan(String value) {
            addCriterion("positionmem_id >", value, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdGreaterThanOrEqualTo(String value) {
            addCriterion("positionmem_id >=", value, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdLessThan(String value) {
            addCriterion("positionmem_id <", value, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdLessThanOrEqualTo(String value) {
            addCriterion("positionmem_id <=", value, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdLike(String value) {
            addCriterion("positionmem_id like", value, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdNotLike(String value) {
            addCriterion("positionmem_id not like", value, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdIn(List<String> values) {
            addCriterion("positionmem_id in", values, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdNotIn(List<String> values) {
            addCriterion("positionmem_id not in", values, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdBetween(String value1, String value2) {
            addCriterion("positionmem_id between", value1, value2, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemIdNotBetween(String value1, String value2) {
            addCriterion("positionmem_id not between", value1, value2, "positionmemId");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeIsNull() {
            addCriterion("positionmem_time is null");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeIsNotNull() {
            addCriterion("positionmem_time is not null");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeEqualTo(Date value) {
            addCriterion("positionmem_time =", value, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeNotEqualTo(Date value) {
            addCriterion("positionmem_time <>", value, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeGreaterThan(Date value) {
            addCriterion("positionmem_time >", value, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("positionmem_time >=", value, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeLessThan(Date value) {
            addCriterion("positionmem_time <", value, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeLessThanOrEqualTo(Date value) {
            addCriterion("positionmem_time <=", value, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeIn(List<Date> values) {
            addCriterion("positionmem_time in", values, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeNotIn(List<Date> values) {
            addCriterion("positionmem_time not in", values, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeBetween(Date value1, Date value2) {
            addCriterion("positionmem_time between", value1, value2, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemTimeNotBetween(Date value1, Date value2) {
            addCriterion("positionmem_time not between", value1, value2, "positionmemTime");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateIsNull() {
            addCriterion("positionmem_state is null");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateIsNotNull() {
            addCriterion("positionmem_state is not null");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateEqualTo(Integer value) {
            addCriterion("positionmem_state =", value, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateNotEqualTo(Integer value) {
            addCriterion("positionmem_state <>", value, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateGreaterThan(Integer value) {
            addCriterion("positionmem_state >", value, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("positionmem_state >=", value, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateLessThan(Integer value) {
            addCriterion("positionmem_state <", value, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateLessThanOrEqualTo(Integer value) {
            addCriterion("positionmem_state <=", value, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateIn(List<Integer> values) {
            addCriterion("positionmem_state in", values, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateNotIn(List<Integer> values) {
            addCriterion("positionmem_state not in", values, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateBetween(Integer value1, Integer value2) {
            addCriterion("positionmem_state between", value1, value2, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmemStateNotBetween(Integer value1, Integer value2) {
            addCriterion("positionmem_state not between", value1, value2, "positionmemState");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeIsNull() {
            addCriterion("positionmen_reltime is null");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeIsNotNull() {
            addCriterion("positionmen_reltime is not null");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeEqualTo(Date value) {
            addCriterion("positionmen_reltime =", value, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeNotEqualTo(Date value) {
            addCriterion("positionmen_reltime <>", value, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeGreaterThan(Date value) {
            addCriterion("positionmen_reltime >", value, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("positionmen_reltime >=", value, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeLessThan(Date value) {
            addCriterion("positionmen_reltime <", value, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeLessThanOrEqualTo(Date value) {
            addCriterion("positionmen_reltime <=", value, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeIn(List<Date> values) {
            addCriterion("positionmen_reltime in", values, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeNotIn(List<Date> values) {
            addCriterion("positionmen_reltime not in", values, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeBetween(Date value1, Date value2) {
            addCriterion("positionmen_reltime between", value1, value2, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenReltimeNotBetween(Date value1, Date value2) {
            addCriterion("positionmen_reltime not between", value1, value2, "positionmenReltime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeIsNull() {
            addCriterion("positionmen_endime is null");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeIsNotNull() {
            addCriterion("positionmen_endime is not null");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeEqualTo(Date value) {
            addCriterion("positionmen_endime =", value, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeNotEqualTo(Date value) {
            addCriterion("positionmen_endime <>", value, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeGreaterThan(Date value) {
            addCriterion("positionmen_endime >", value, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeGreaterThanOrEqualTo(Date value) {
            addCriterion("positionmen_endime >=", value, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeLessThan(Date value) {
            addCriterion("positionmen_endime <", value, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeLessThanOrEqualTo(Date value) {
            addCriterion("positionmen_endime <=", value, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeIn(List<Date> values) {
            addCriterion("positionmen_endime in", values, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeNotIn(List<Date> values) {
            addCriterion("positionmen_endime not in", values, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeBetween(Date value1, Date value2) {
            addCriterion("positionmen_endime between", value1, value2, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenEndimeNotBetween(Date value1, Date value2) {
            addCriterion("positionmen_endime not between", value1, value2, "positionmenEndime");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumIsNull() {
            addCriterion("positionmen_sum is null");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumIsNotNull() {
            addCriterion("positionmen_sum is not null");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumEqualTo(Integer value) {
            addCriterion("positionmen_sum =", value, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumNotEqualTo(Integer value) {
            addCriterion("positionmen_sum <>", value, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumGreaterThan(Integer value) {
            addCriterion("positionmen_sum >", value, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("positionmen_sum >=", value, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumLessThan(Integer value) {
            addCriterion("positionmen_sum <", value, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumLessThanOrEqualTo(Integer value) {
            addCriterion("positionmen_sum <=", value, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumIn(List<Integer> values) {
            addCriterion("positionmen_sum in", values, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumNotIn(List<Integer> values) {
            addCriterion("positionmen_sum not in", values, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumBetween(Integer value1, Integer value2) {
            addCriterion("positionmen_sum between", value1, value2, "positionmenSum");
            return (Criteria) this;
        }

        public Criteria andPositionmenSumNotBetween(Integer value1, Integer value2) {
            addCriterion("positionmen_sum not between", value1, value2, "positionmenSum");
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