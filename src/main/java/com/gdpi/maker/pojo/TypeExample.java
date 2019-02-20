package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.List;

public class TypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypeExample() {
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

        public Criteria andTpIdIsNull() {
            addCriterion("tp_id is null");
            return (Criteria) this;
        }

        public Criteria andTpIdIsNotNull() {
            addCriterion("tp_id is not null");
            return (Criteria) this;
        }

        public Criteria andTpIdEqualTo(String value) {
            addCriterion("tp_id =", value, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdNotEqualTo(String value) {
            addCriterion("tp_id <>", value, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdGreaterThan(String value) {
            addCriterion("tp_id >", value, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdGreaterThanOrEqualTo(String value) {
            addCriterion("tp_id >=", value, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdLessThan(String value) {
            addCriterion("tp_id <", value, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdLessThanOrEqualTo(String value) {
            addCriterion("tp_id <=", value, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdLike(String value) {
            addCriterion("tp_id like", value, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdNotLike(String value) {
            addCriterion("tp_id not like", value, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdIn(List<String> values) {
            addCriterion("tp_id in", values, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdNotIn(List<String> values) {
            addCriterion("tp_id not in", values, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdBetween(String value1, String value2) {
            addCriterion("tp_id between", value1, value2, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpIdNotBetween(String value1, String value2) {
            addCriterion("tp_id not between", value1, value2, "tpId");
            return (Criteria) this;
        }

        public Criteria andTpNameIsNull() {
            addCriterion("tp_name is null");
            return (Criteria) this;
        }

        public Criteria andTpNameIsNotNull() {
            addCriterion("tp_name is not null");
            return (Criteria) this;
        }

        public Criteria andTpNameEqualTo(String value) {
            addCriterion("tp_name =", value, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameNotEqualTo(String value) {
            addCriterion("tp_name <>", value, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameGreaterThan(String value) {
            addCriterion("tp_name >", value, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameGreaterThanOrEqualTo(String value) {
            addCriterion("tp_name >=", value, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameLessThan(String value) {
            addCriterion("tp_name <", value, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameLessThanOrEqualTo(String value) {
            addCriterion("tp_name <=", value, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameLike(String value) {
            addCriterion("tp_name like", value, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameNotLike(String value) {
            addCriterion("tp_name not like", value, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameIn(List<String> values) {
            addCriterion("tp_name in", values, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameNotIn(List<String> values) {
            addCriterion("tp_name not in", values, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameBetween(String value1, String value2) {
            addCriterion("tp_name between", value1, value2, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpNameNotBetween(String value1, String value2) {
            addCriterion("tp_name not between", value1, value2, "tpName");
            return (Criteria) this;
        }

        public Criteria andTpCareerIsNull() {
            addCriterion("tp_career is null");
            return (Criteria) this;
        }

        public Criteria andTpCareerIsNotNull() {
            addCriterion("tp_career is not null");
            return (Criteria) this;
        }

        public Criteria andTpCareerEqualTo(String value) {
            addCriterion("tp_career =", value, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerNotEqualTo(String value) {
            addCriterion("tp_career <>", value, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerGreaterThan(String value) {
            addCriterion("tp_career >", value, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerGreaterThanOrEqualTo(String value) {
            addCriterion("tp_career >=", value, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerLessThan(String value) {
            addCriterion("tp_career <", value, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerLessThanOrEqualTo(String value) {
            addCriterion("tp_career <=", value, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerLike(String value) {
            addCriterion("tp_career like", value, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerNotLike(String value) {
            addCriterion("tp_career not like", value, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerIn(List<String> values) {
            addCriterion("tp_career in", values, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerNotIn(List<String> values) {
            addCriterion("tp_career not in", values, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerBetween(String value1, String value2) {
            addCriterion("tp_career between", value1, value2, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpCareerNotBetween(String value1, String value2) {
            addCriterion("tp_career not between", value1, value2, "tpCareer");
            return (Criteria) this;
        }

        public Criteria andTpStyleIsNull() {
            addCriterion("tp_style is null");
            return (Criteria) this;
        }

        public Criteria andTpStyleIsNotNull() {
            addCriterion("tp_style is not null");
            return (Criteria) this;
        }

        public Criteria andTpStyleEqualTo(String value) {
            addCriterion("tp_style =", value, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleNotEqualTo(String value) {
            addCriterion("tp_style <>", value, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleGreaterThan(String value) {
            addCriterion("tp_style >", value, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleGreaterThanOrEqualTo(String value) {
            addCriterion("tp_style >=", value, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleLessThan(String value) {
            addCriterion("tp_style <", value, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleLessThanOrEqualTo(String value) {
            addCriterion("tp_style <=", value, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleLike(String value) {
            addCriterion("tp_style like", value, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleNotLike(String value) {
            addCriterion("tp_style not like", value, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleIn(List<String> values) {
            addCriterion("tp_style in", values, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleNotIn(List<String> values) {
            addCriterion("tp_style not in", values, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleBetween(String value1, String value2) {
            addCriterion("tp_style between", value1, value2, "tpStyle");
            return (Criteria) this;
        }

        public Criteria andTpStyleNotBetween(String value1, String value2) {
            addCriterion("tp_style not between", value1, value2, "tpStyle");
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