package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdetaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProdetaExample() {
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

        public Criteria andPrdeIswinIsNull() {
            addCriterion("prde_iswin is null");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinIsNotNull() {
            addCriterion("prde_iswin is not null");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinEqualTo(String value) {
            addCriterion("prde_iswin =", value, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinNotEqualTo(String value) {
            addCriterion("prde_iswin <>", value, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinGreaterThan(String value) {
            addCriterion("prde_iswin >", value, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinGreaterThanOrEqualTo(String value) {
            addCriterion("prde_iswin >=", value, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinLessThan(String value) {
            addCriterion("prde_iswin <", value, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinLessThanOrEqualTo(String value) {
            addCriterion("prde_iswin <=", value, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinLike(String value) {
            addCriterion("prde_iswin like", value, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinNotLike(String value) {
            addCriterion("prde_iswin not like", value, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinIn(List<String> values) {
            addCriterion("prde_iswin in", values, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinNotIn(List<String> values) {
            addCriterion("prde_iswin not in", values, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinBetween(String value1, String value2) {
            addCriterion("prde_iswin between", value1, value2, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeIswinNotBetween(String value1, String value2) {
            addCriterion("prde_iswin not between", value1, value2, "prdeIswin");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeIsNull() {
            addCriterion("prde_rectime is null");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeIsNotNull() {
            addCriterion("prde_rectime is not null");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeEqualTo(Date value) {
            addCriterion("prde_rectime =", value, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeNotEqualTo(Date value) {
            addCriterion("prde_rectime <>", value, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeGreaterThan(Date value) {
            addCriterion("prde_rectime >", value, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeGreaterThanOrEqualTo(Date value) {
            addCriterion("prde_rectime >=", value, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeLessThan(Date value) {
            addCriterion("prde_rectime <", value, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeLessThanOrEqualTo(Date value) {
            addCriterion("prde_rectime <=", value, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeIn(List<Date> values) {
            addCriterion("prde_rectime in", values, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeNotIn(List<Date> values) {
            addCriterion("prde_rectime not in", values, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeBetween(Date value1, Date value2) {
            addCriterion("prde_rectime between", value1, value2, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeRectimeNotBetween(Date value1, Date value2) {
            addCriterion("prde_rectime not between", value1, value2, "prdeRectime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeIsNull() {
            addCriterion("prde_comtime is null");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeIsNotNull() {
            addCriterion("prde_comtime is not null");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeEqualTo(Date value) {
            addCriterion("prde_comtime =", value, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeNotEqualTo(Date value) {
            addCriterion("prde_comtime <>", value, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeGreaterThan(Date value) {
            addCriterion("prde_comtime >", value, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("prde_comtime >=", value, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeLessThan(Date value) {
            addCriterion("prde_comtime <", value, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeLessThanOrEqualTo(Date value) {
            addCriterion("prde_comtime <=", value, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeIn(List<Date> values) {
            addCriterion("prde_comtime in", values, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeNotIn(List<Date> values) {
            addCriterion("prde_comtime not in", values, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeBetween(Date value1, Date value2) {
            addCriterion("prde_comtime between", value1, value2, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeComtimeNotBetween(Date value1, Date value2) {
            addCriterion("prde_comtime not between", value1, value2, "prdeComtime");
            return (Criteria) this;
        }

        public Criteria andPrdeStateIsNull() {
            addCriterion("prde_state is null");
            return (Criteria) this;
        }

        public Criteria andPrdeStateIsNotNull() {
            addCriterion("prde_state is not null");
            return (Criteria) this;
        }

        public Criteria andPrdeStateEqualTo(Integer value) {
            addCriterion("prde_state =", value, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateNotEqualTo(Integer value) {
            addCriterion("prde_state <>", value, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateGreaterThan(Integer value) {
            addCriterion("prde_state >", value, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("prde_state >=", value, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateLessThan(Integer value) {
            addCriterion("prde_state <", value, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateLessThanOrEqualTo(Integer value) {
            addCriterion("prde_state <=", value, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateIn(List<Integer> values) {
            addCriterion("prde_state in", values, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateNotIn(List<Integer> values) {
            addCriterion("prde_state not in", values, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateBetween(Integer value1, Integer value2) {
            addCriterion("prde_state between", value1, value2, "prdeState");
            return (Criteria) this;
        }

        public Criteria andPrdeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("prde_state not between", value1, value2, "prdeState");
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