package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForumimgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForumimgExample() {
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

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(String value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(String value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(String value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(String value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(String value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(String value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLike(String value) {
            addCriterion("img_id like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotLike(String value) {
            addCriterion("img_id not like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<String> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<String> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(String value1, String value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(String value1, String value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgRouteIsNull() {
            addCriterion("img_route is null");
            return (Criteria) this;
        }

        public Criteria andImgRouteIsNotNull() {
            addCriterion("img_route is not null");
            return (Criteria) this;
        }

        public Criteria andImgRouteEqualTo(String value) {
            addCriterion("img_route =", value, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteNotEqualTo(String value) {
            addCriterion("img_route <>", value, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteGreaterThan(String value) {
            addCriterion("img_route >", value, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteGreaterThanOrEqualTo(String value) {
            addCriterion("img_route >=", value, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteLessThan(String value) {
            addCriterion("img_route <", value, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteLessThanOrEqualTo(String value) {
            addCriterion("img_route <=", value, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteLike(String value) {
            addCriterion("img_route like", value, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteNotLike(String value) {
            addCriterion("img_route not like", value, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteIn(List<String> values) {
            addCriterion("img_route in", values, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteNotIn(List<String> values) {
            addCriterion("img_route not in", values, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteBetween(String value1, String value2) {
            addCriterion("img_route between", value1, value2, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRouteNotBetween(String value1, String value2) {
            addCriterion("img_route not between", value1, value2, "imgRoute");
            return (Criteria) this;
        }

        public Criteria andImgRectimeIsNull() {
            addCriterion("img_rectime is null");
            return (Criteria) this;
        }

        public Criteria andImgRectimeIsNotNull() {
            addCriterion("img_rectime is not null");
            return (Criteria) this;
        }

        public Criteria andImgRectimeEqualTo(Date value) {
            addCriterion("img_rectime =", value, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeNotEqualTo(Date value) {
            addCriterion("img_rectime <>", value, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeGreaterThan(Date value) {
            addCriterion("img_rectime >", value, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeGreaterThanOrEqualTo(Date value) {
            addCriterion("img_rectime >=", value, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeLessThan(Date value) {
            addCriterion("img_rectime <", value, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeLessThanOrEqualTo(Date value) {
            addCriterion("img_rectime <=", value, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeIn(List<Date> values) {
            addCriterion("img_rectime in", values, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeNotIn(List<Date> values) {
            addCriterion("img_rectime not in", values, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeBetween(Date value1, Date value2) {
            addCriterion("img_rectime between", value1, value2, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgRectimeNotBetween(Date value1, Date value2) {
            addCriterion("img_rectime not between", value1, value2, "imgRectime");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridIsNull() {
            addCriterion("img_authorId is null");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridIsNotNull() {
            addCriterion("img_authorId is not null");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridEqualTo(String value) {
            addCriterion("img_authorId =", value, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridNotEqualTo(String value) {
            addCriterion("img_authorId <>", value, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridGreaterThan(String value) {
            addCriterion("img_authorId >", value, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridGreaterThanOrEqualTo(String value) {
            addCriterion("img_authorId >=", value, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridLessThan(String value) {
            addCriterion("img_authorId <", value, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridLessThanOrEqualTo(String value) {
            addCriterion("img_authorId <=", value, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridLike(String value) {
            addCriterion("img_authorId like", value, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridNotLike(String value) {
            addCriterion("img_authorId not like", value, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridIn(List<String> values) {
            addCriterion("img_authorId in", values, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridNotIn(List<String> values) {
            addCriterion("img_authorId not in", values, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridBetween(String value1, String value2) {
            addCriterion("img_authorId between", value1, value2, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgAuthoridNotBetween(String value1, String value2) {
            addCriterion("img_authorId not between", value1, value2, "imgAuthorid");
            return (Criteria) this;
        }

        public Criteria andImgSizeIsNull() {
            addCriterion("img_size is null");
            return (Criteria) this;
        }

        public Criteria andImgSizeIsNotNull() {
            addCriterion("img_size is not null");
            return (Criteria) this;
        }

        public Criteria andImgSizeEqualTo(Double value) {
            addCriterion("img_size =", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeNotEqualTo(Double value) {
            addCriterion("img_size <>", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeGreaterThan(Double value) {
            addCriterion("img_size >", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("img_size >=", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeLessThan(Double value) {
            addCriterion("img_size <", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeLessThanOrEqualTo(Double value) {
            addCriterion("img_size <=", value, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeIn(List<Double> values) {
            addCriterion("img_size in", values, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeNotIn(List<Double> values) {
            addCriterion("img_size not in", values, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeBetween(Double value1, Double value2) {
            addCriterion("img_size between", value1, value2, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgSizeNotBetween(Double value1, Double value2) {
            addCriterion("img_size not between", value1, value2, "imgSize");
            return (Criteria) this;
        }

        public Criteria andImgStartIsNull() {
            addCriterion("img_start is null");
            return (Criteria) this;
        }

        public Criteria andImgStartIsNotNull() {
            addCriterion("img_start is not null");
            return (Criteria) this;
        }

        public Criteria andImgStartEqualTo(Integer value) {
            addCriterion("img_start =", value, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartNotEqualTo(Integer value) {
            addCriterion("img_start <>", value, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartGreaterThan(Integer value) {
            addCriterion("img_start >", value, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_start >=", value, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartLessThan(Integer value) {
            addCriterion("img_start <", value, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartLessThanOrEqualTo(Integer value) {
            addCriterion("img_start <=", value, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartIn(List<Integer> values) {
            addCriterion("img_start in", values, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartNotIn(List<Integer> values) {
            addCriterion("img_start not in", values, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartBetween(Integer value1, Integer value2) {
            addCriterion("img_start between", value1, value2, "imgStart");
            return (Criteria) this;
        }

        public Criteria andImgStartNotBetween(Integer value1, Integer value2) {
            addCriterion("img_start not between", value1, value2, "imgStart");
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