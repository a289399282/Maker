package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionExample() {
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

        public Criteria andPositionNameIsNull() {
            addCriterion("position_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("position_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("position_name =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("position_name <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("position_name >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_name >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("position_name <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("position_name <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("position_name like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("position_name not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("position_name in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("position_name not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("position_name between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("position_name not between", value1, value2, "positionName");
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

        public Criteria andPositionReltimeIsNull() {
            addCriterion("position_reltime is null");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeIsNotNull() {
            addCriterion("position_reltime is not null");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeEqualTo(Date value) {
            addCriterion("position_reltime =", value, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeNotEqualTo(Date value) {
            addCriterion("position_reltime <>", value, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeGreaterThan(Date value) {
            addCriterion("position_reltime >", value, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("position_reltime >=", value, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeLessThan(Date value) {
            addCriterion("position_reltime <", value, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeLessThanOrEqualTo(Date value) {
            addCriterion("position_reltime <=", value, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeIn(List<Date> values) {
            addCriterion("position_reltime in", values, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeNotIn(List<Date> values) {
            addCriterion("position_reltime not in", values, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeBetween(Date value1, Date value2) {
            addCriterion("position_reltime between", value1, value2, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionReltimeNotBetween(Date value1, Date value2) {
            addCriterion("position_reltime not between", value1, value2, "positionReltime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeIsNull() {
            addCriterion("position_endtime is null");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeIsNotNull() {
            addCriterion("position_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeEqualTo(Date value) {
            addCriterion("position_endtime =", value, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeNotEqualTo(Date value) {
            addCriterion("position_endtime <>", value, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeGreaterThan(Date value) {
            addCriterion("position_endtime >", value, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("position_endtime >=", value, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeLessThan(Date value) {
            addCriterion("position_endtime <", value, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("position_endtime <=", value, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeIn(List<Date> values) {
            addCriterion("position_endtime in", values, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeNotIn(List<Date> values) {
            addCriterion("position_endtime not in", values, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeBetween(Date value1, Date value2) {
            addCriterion("position_endtime between", value1, value2, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("position_endtime not between", value1, value2, "positionEndtime");
            return (Criteria) this;
        }

        public Criteria andPositionAmountIsNull() {
            addCriterion("position_amount is null");
            return (Criteria) this;
        }

        public Criteria andPositionAmountIsNotNull() {
            addCriterion("position_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPositionAmountEqualTo(Integer value) {
            addCriterion("position_amount =", value, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountNotEqualTo(Integer value) {
            addCriterion("position_amount <>", value, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountGreaterThan(Integer value) {
            addCriterion("position_amount >", value, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_amount >=", value, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountLessThan(Integer value) {
            addCriterion("position_amount <", value, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountLessThanOrEqualTo(Integer value) {
            addCriterion("position_amount <=", value, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountIn(List<Integer> values) {
            addCriterion("position_amount in", values, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountNotIn(List<Integer> values) {
            addCriterion("position_amount not in", values, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountBetween(Integer value1, Integer value2) {
            addCriterion("position_amount between", value1, value2, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("position_amount not between", value1, value2, "positionAmount");
            return (Criteria) this;
        }

        public Criteria andPositionHeatIsNull() {
            addCriterion("position_heat is null");
            return (Criteria) this;
        }

        public Criteria andPositionHeatIsNotNull() {
            addCriterion("position_heat is not null");
            return (Criteria) this;
        }

        public Criteria andPositionHeatEqualTo(Integer value) {
            addCriterion("position_heat =", value, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatNotEqualTo(Integer value) {
            addCriterion("position_heat <>", value, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatGreaterThan(Integer value) {
            addCriterion("position_heat >", value, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_heat >=", value, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatLessThan(Integer value) {
            addCriterion("position_heat <", value, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatLessThanOrEqualTo(Integer value) {
            addCriterion("position_heat <=", value, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatIn(List<Integer> values) {
            addCriterion("position_heat in", values, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatNotIn(List<Integer> values) {
            addCriterion("position_heat not in", values, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatBetween(Integer value1, Integer value2) {
            addCriterion("position_heat between", value1, value2, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionHeatNotBetween(Integer value1, Integer value2) {
            addCriterion("position_heat not between", value1, value2, "positionHeat");
            return (Criteria) this;
        }

        public Criteria andPositionStateIsNull() {
            addCriterion("position_state is null");
            return (Criteria) this;
        }

        public Criteria andPositionStateIsNotNull() {
            addCriterion("position_state is not null");
            return (Criteria) this;
        }

        public Criteria andPositionStateEqualTo(Integer value) {
            addCriterion("position_state =", value, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateNotEqualTo(Integer value) {
            addCriterion("position_state <>", value, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateGreaterThan(Integer value) {
            addCriterion("position_state >", value, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_state >=", value, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateLessThan(Integer value) {
            addCriterion("position_state <", value, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateLessThanOrEqualTo(Integer value) {
            addCriterion("position_state <=", value, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateIn(List<Integer> values) {
            addCriterion("position_state in", values, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateNotIn(List<Integer> values) {
            addCriterion("position_state not in", values, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateBetween(Integer value1, Integer value2) {
            addCriterion("position_state between", value1, value2, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("position_state not between", value1, value2, "positionState");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNull() {
            addCriterion("position_type is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNotNull() {
            addCriterion("position_type is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeEqualTo(String value) {
            addCriterion("position_type =", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotEqualTo(String value) {
            addCriterion("position_type <>", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThan(String value) {
            addCriterion("position_type >", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("position_type >=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThan(String value) {
            addCriterion("position_type <", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThanOrEqualTo(String value) {
            addCriterion("position_type <=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLike(String value) {
            addCriterion("position_type like", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotLike(String value) {
            addCriterion("position_type not like", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIn(List<String> values) {
            addCriterion("position_type in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotIn(List<String> values) {
            addCriterion("position_type not in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeBetween(String value1, String value2) {
            addCriterion("position_type between", value1, value2, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotBetween(String value1, String value2) {
            addCriterion("position_type not between", value1, value2, "positionType");
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