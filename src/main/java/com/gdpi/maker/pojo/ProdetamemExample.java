package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdetamemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProdetamemExample() {
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

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(String value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(String value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(String value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(String value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(String value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(String value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLike(String value) {
            addCriterion("pro_id like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotLike(String value) {
            addCriterion("pro_id not like", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<String> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<String> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(String value1, String value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(String value1, String value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdIsNull() {
            addCriterion("prdemem_id is null");
            return (Criteria) this;
        }

        public Criteria andPrdememIdIsNotNull() {
            addCriterion("prdemem_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrdememIdEqualTo(String value) {
            addCriterion("prdemem_id =", value, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdNotEqualTo(String value) {
            addCriterion("prdemem_id <>", value, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdGreaterThan(String value) {
            addCriterion("prdemem_id >", value, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdGreaterThanOrEqualTo(String value) {
            addCriterion("prdemem_id >=", value, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdLessThan(String value) {
            addCriterion("prdemem_id <", value, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdLessThanOrEqualTo(String value) {
            addCriterion("prdemem_id <=", value, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdLike(String value) {
            addCriterion("prdemem_id like", value, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdNotLike(String value) {
            addCriterion("prdemem_id not like", value, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdIn(List<String> values) {
            addCriterion("prdemem_id in", values, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdNotIn(List<String> values) {
            addCriterion("prdemem_id not in", values, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdBetween(String value1, String value2) {
            addCriterion("prdemem_id between", value1, value2, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememIdNotBetween(String value1, String value2) {
            addCriterion("prdemem_id not between", value1, value2, "prdememId");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeIsNull() {
            addCriterion("prdemem_time is null");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeIsNotNull() {
            addCriterion("prdemem_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeEqualTo(Date value) {
            addCriterion("prdemem_time =", value, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeNotEqualTo(Date value) {
            addCriterion("prdemem_time <>", value, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeGreaterThan(Date value) {
            addCriterion("prdemem_time >", value, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("prdemem_time >=", value, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeLessThan(Date value) {
            addCriterion("prdemem_time <", value, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeLessThanOrEqualTo(Date value) {
            addCriterion("prdemem_time <=", value, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeIn(List<Date> values) {
            addCriterion("prdemem_time in", values, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeNotIn(List<Date> values) {
            addCriterion("prdemem_time not in", values, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeBetween(Date value1, Date value2) {
            addCriterion("prdemem_time between", value1, value2, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememTimeNotBetween(Date value1, Date value2) {
            addCriterion("prdemem_time not between", value1, value2, "prdememTime");
            return (Criteria) this;
        }

        public Criteria andPrdememStateIsNull() {
            addCriterion("prdemem_state is null");
            return (Criteria) this;
        }

        public Criteria andPrdememStateIsNotNull() {
            addCriterion("prdemem_state is not null");
            return (Criteria) this;
        }

        public Criteria andPrdememStateEqualTo(Integer value) {
            addCriterion("prdemem_state =", value, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateNotEqualTo(Integer value) {
            addCriterion("prdemem_state <>", value, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateGreaterThan(Integer value) {
            addCriterion("prdemem_state >", value, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("prdemem_state >=", value, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateLessThan(Integer value) {
            addCriterion("prdemem_state <", value, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateLessThanOrEqualTo(Integer value) {
            addCriterion("prdemem_state <=", value, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateIn(List<Integer> values) {
            addCriterion("prdemem_state in", values, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateNotIn(List<Integer> values) {
            addCriterion("prdemem_state not in", values, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateBetween(Integer value1, Integer value2) {
            addCriterion("prdemem_state between", value1, value2, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememStateNotBetween(Integer value1, Integer value2) {
            addCriterion("prdemem_state not between", value1, value2, "prdememState");
            return (Criteria) this;
        }

        public Criteria andPrdememSumIsNull() {
            addCriterion("prdemem_sum is null");
            return (Criteria) this;
        }

        public Criteria andPrdememSumIsNotNull() {
            addCriterion("prdemem_sum is not null");
            return (Criteria) this;
        }

        public Criteria andPrdememSumEqualTo(Integer value) {
            addCriterion("prdemem_sum =", value, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumNotEqualTo(Integer value) {
            addCriterion("prdemem_sum <>", value, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumGreaterThan(Integer value) {
            addCriterion("prdemem_sum >", value, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("prdemem_sum >=", value, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumLessThan(Integer value) {
            addCriterion("prdemem_sum <", value, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumLessThanOrEqualTo(Integer value) {
            addCriterion("prdemem_sum <=", value, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumIn(List<Integer> values) {
            addCriterion("prdemem_sum in", values, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumNotIn(List<Integer> values) {
            addCriterion("prdemem_sum not in", values, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumBetween(Integer value1, Integer value2) {
            addCriterion("prdemem_sum between", value1, value2, "prdememSum");
            return (Criteria) this;
        }

        public Criteria andPrdememSumNotBetween(Integer value1, Integer value2) {
            addCriterion("prdemem_sum not between", value1, value2, "prdememSum");
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