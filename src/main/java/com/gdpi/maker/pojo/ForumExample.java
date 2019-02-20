package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForumExample() {
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

        public Criteria andForumIdIsNull() {
            addCriterion("forum_id is null");
            return (Criteria) this;
        }

        public Criteria andForumIdIsNotNull() {
            addCriterion("forum_id is not null");
            return (Criteria) this;
        }

        public Criteria andForumIdEqualTo(String value) {
            addCriterion("forum_id =", value, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdNotEqualTo(String value) {
            addCriterion("forum_id <>", value, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdGreaterThan(String value) {
            addCriterion("forum_id >", value, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdGreaterThanOrEqualTo(String value) {
            addCriterion("forum_id >=", value, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdLessThan(String value) {
            addCriterion("forum_id <", value, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdLessThanOrEqualTo(String value) {
            addCriterion("forum_id <=", value, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdLike(String value) {
            addCriterion("forum_id like", value, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdNotLike(String value) {
            addCriterion("forum_id not like", value, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdIn(List<String> values) {
            addCriterion("forum_id in", values, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdNotIn(List<String> values) {
            addCriterion("forum_id not in", values, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdBetween(String value1, String value2) {
            addCriterion("forum_id between", value1, value2, "forumId");
            return (Criteria) this;
        }

        public Criteria andForumIdNotBetween(String value1, String value2) {
            addCriterion("forum_id not between", value1, value2, "forumId");
            return (Criteria) this;
        }

        public Criteria andForummemIdIsNull() {
            addCriterion("forummem_id is null");
            return (Criteria) this;
        }

        public Criteria andForummemIdIsNotNull() {
            addCriterion("forummem_id is not null");
            return (Criteria) this;
        }

        public Criteria andForummemIdEqualTo(String value) {
            addCriterion("forummem_id =", value, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdNotEqualTo(String value) {
            addCriterion("forummem_id <>", value, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdGreaterThan(String value) {
            addCriterion("forummem_id >", value, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdGreaterThanOrEqualTo(String value) {
            addCriterion("forummem_id >=", value, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdLessThan(String value) {
            addCriterion("forummem_id <", value, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdLessThanOrEqualTo(String value) {
            addCriterion("forummem_id <=", value, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdLike(String value) {
            addCriterion("forummem_id like", value, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdNotLike(String value) {
            addCriterion("forummem_id not like", value, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdIn(List<String> values) {
            addCriterion("forummem_id in", values, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdNotIn(List<String> values) {
            addCriterion("forummem_id not in", values, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdBetween(String value1, String value2) {
            addCriterion("forummem_id between", value1, value2, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForummemIdNotBetween(String value1, String value2) {
            addCriterion("forummem_id not between", value1, value2, "forummemId");
            return (Criteria) this;
        }

        public Criteria andForumWhatIsNull() {
            addCriterion("forum_what is null");
            return (Criteria) this;
        }

        public Criteria andForumWhatIsNotNull() {
            addCriterion("forum_what is not null");
            return (Criteria) this;
        }

        public Criteria andForumWhatEqualTo(Integer value) {
            addCriterion("forum_what =", value, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatNotEqualTo(Integer value) {
            addCriterion("forum_what <>", value, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatGreaterThan(Integer value) {
            addCriterion("forum_what >", value, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatGreaterThanOrEqualTo(Integer value) {
            addCriterion("forum_what >=", value, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatLessThan(Integer value) {
            addCriterion("forum_what <", value, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatLessThanOrEqualTo(Integer value) {
            addCriterion("forum_what <=", value, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatIn(List<Integer> values) {
            addCriterion("forum_what in", values, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatNotIn(List<Integer> values) {
            addCriterion("forum_what not in", values, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatBetween(Integer value1, Integer value2) {
            addCriterion("forum_what between", value1, value2, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumWhatNotBetween(Integer value1, Integer value2) {
            addCriterion("forum_what not between", value1, value2, "forumWhat");
            return (Criteria) this;
        }

        public Criteria andForumRouteIsNull() {
            addCriterion("forum_route is null");
            return (Criteria) this;
        }

        public Criteria andForumRouteIsNotNull() {
            addCriterion("forum_route is not null");
            return (Criteria) this;
        }

        public Criteria andForumRouteEqualTo(String value) {
            addCriterion("forum_route =", value, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteNotEqualTo(String value) {
            addCriterion("forum_route <>", value, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteGreaterThan(String value) {
            addCriterion("forum_route >", value, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteGreaterThanOrEqualTo(String value) {
            addCriterion("forum_route >=", value, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteLessThan(String value) {
            addCriterion("forum_route <", value, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteLessThanOrEqualTo(String value) {
            addCriterion("forum_route <=", value, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteLike(String value) {
            addCriterion("forum_route like", value, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteNotLike(String value) {
            addCriterion("forum_route not like", value, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteIn(List<String> values) {
            addCriterion("forum_route in", values, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteNotIn(List<String> values) {
            addCriterion("forum_route not in", values, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteBetween(String value1, String value2) {
            addCriterion("forum_route between", value1, value2, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumRouteNotBetween(String value1, String value2) {
            addCriterion("forum_route not between", value1, value2, "forumRoute");
            return (Criteria) this;
        }

        public Criteria andForumForidIsNull() {
            addCriterion("forum_forid is null");
            return (Criteria) this;
        }

        public Criteria andForumForidIsNotNull() {
            addCriterion("forum_forid is not null");
            return (Criteria) this;
        }

        public Criteria andForumForidEqualTo(String value) {
            addCriterion("forum_forid =", value, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidNotEqualTo(String value) {
            addCriterion("forum_forid <>", value, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidGreaterThan(String value) {
            addCriterion("forum_forid >", value, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidGreaterThanOrEqualTo(String value) {
            addCriterion("forum_forid >=", value, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidLessThan(String value) {
            addCriterion("forum_forid <", value, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidLessThanOrEqualTo(String value) {
            addCriterion("forum_forid <=", value, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidLike(String value) {
            addCriterion("forum_forid like", value, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidNotLike(String value) {
            addCriterion("forum_forid not like", value, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidIn(List<String> values) {
            addCriterion("forum_forid in", values, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidNotIn(List<String> values) {
            addCriterion("forum_forid not in", values, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidBetween(String value1, String value2) {
            addCriterion("forum_forid between", value1, value2, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumForidNotBetween(String value1, String value2) {
            addCriterion("forum_forid not between", value1, value2, "forumForid");
            return (Criteria) this;
        }

        public Criteria andForumReltimeIsNull() {
            addCriterion("forum_reltime is null");
            return (Criteria) this;
        }

        public Criteria andForumReltimeIsNotNull() {
            addCriterion("forum_reltime is not null");
            return (Criteria) this;
        }

        public Criteria andForumReltimeEqualTo(Date value) {
            addCriterion("forum_reltime =", value, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeNotEqualTo(Date value) {
            addCriterion("forum_reltime <>", value, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeGreaterThan(Date value) {
            addCriterion("forum_reltime >", value, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("forum_reltime >=", value, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeLessThan(Date value) {
            addCriterion("forum_reltime <", value, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeLessThanOrEqualTo(Date value) {
            addCriterion("forum_reltime <=", value, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeIn(List<Date> values) {
            addCriterion("forum_reltime in", values, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeNotIn(List<Date> values) {
            addCriterion("forum_reltime not in", values, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeBetween(Date value1, Date value2) {
            addCriterion("forum_reltime between", value1, value2, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumReltimeNotBetween(Date value1, Date value2) {
            addCriterion("forum_reltime not between", value1, value2, "forumReltime");
            return (Criteria) this;
        }

        public Criteria andForumNameIsNull() {
            addCriterion("forum_name is null");
            return (Criteria) this;
        }

        public Criteria andForumNameIsNotNull() {
            addCriterion("forum_name is not null");
            return (Criteria) this;
        }

        public Criteria andForumNameEqualTo(String value) {
            addCriterion("forum_name =", value, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameNotEqualTo(String value) {
            addCriterion("forum_name <>", value, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameGreaterThan(String value) {
            addCriterion("forum_name >", value, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameGreaterThanOrEqualTo(String value) {
            addCriterion("forum_name >=", value, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameLessThan(String value) {
            addCriterion("forum_name <", value, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameLessThanOrEqualTo(String value) {
            addCriterion("forum_name <=", value, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameLike(String value) {
            addCriterion("forum_name like", value, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameNotLike(String value) {
            addCriterion("forum_name not like", value, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameIn(List<String> values) {
            addCriterion("forum_name in", values, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameNotIn(List<String> values) {
            addCriterion("forum_name not in", values, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameBetween(String value1, String value2) {
            addCriterion("forum_name between", value1, value2, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumNameNotBetween(String value1, String value2) {
            addCriterion("forum_name not between", value1, value2, "forumName");
            return (Criteria) this;
        }

        public Criteria andForumTypeIsNull() {
            addCriterion("forum_type is null");
            return (Criteria) this;
        }

        public Criteria andForumTypeIsNotNull() {
            addCriterion("forum_type is not null");
            return (Criteria) this;
        }

        public Criteria andForumTypeEqualTo(String value) {
            addCriterion("forum_type =", value, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeNotEqualTo(String value) {
            addCriterion("forum_type <>", value, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeGreaterThan(String value) {
            addCriterion("forum_type >", value, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeGreaterThanOrEqualTo(String value) {
            addCriterion("forum_type >=", value, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeLessThan(String value) {
            addCriterion("forum_type <", value, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeLessThanOrEqualTo(String value) {
            addCriterion("forum_type <=", value, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeLike(String value) {
            addCriterion("forum_type like", value, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeNotLike(String value) {
            addCriterion("forum_type not like", value, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeIn(List<String> values) {
            addCriterion("forum_type in", values, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeNotIn(List<String> values) {
            addCriterion("forum_type not in", values, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeBetween(String value1, String value2) {
            addCriterion("forum_type between", value1, value2, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumTypeNotBetween(String value1, String value2) {
            addCriterion("forum_type not between", value1, value2, "forumType");
            return (Criteria) this;
        }

        public Criteria andForumHeatIsNull() {
            addCriterion("forum_heat is null");
            return (Criteria) this;
        }

        public Criteria andForumHeatIsNotNull() {
            addCriterion("forum_heat is not null");
            return (Criteria) this;
        }

        public Criteria andForumHeatEqualTo(Integer value) {
            addCriterion("forum_heat =", value, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatNotEqualTo(Integer value) {
            addCriterion("forum_heat <>", value, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatGreaterThan(Integer value) {
            addCriterion("forum_heat >", value, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("forum_heat >=", value, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatLessThan(Integer value) {
            addCriterion("forum_heat <", value, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatLessThanOrEqualTo(Integer value) {
            addCriterion("forum_heat <=", value, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatIn(List<Integer> values) {
            addCriterion("forum_heat in", values, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatNotIn(List<Integer> values) {
            addCriterion("forum_heat not in", values, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatBetween(Integer value1, Integer value2) {
            addCriterion("forum_heat between", value1, value2, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumHeatNotBetween(Integer value1, Integer value2) {
            addCriterion("forum_heat not between", value1, value2, "forumHeat");
            return (Criteria) this;
        }

        public Criteria andForumStartIsNull() {
            addCriterion("forum_start is null");
            return (Criteria) this;
        }

        public Criteria andForumStartIsNotNull() {
            addCriterion("forum_start is not null");
            return (Criteria) this;
        }

        public Criteria andForumStartEqualTo(Integer value) {
            addCriterion("forum_start =", value, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartNotEqualTo(Integer value) {
            addCriterion("forum_start <>", value, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartGreaterThan(Integer value) {
            addCriterion("forum_start >", value, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("forum_start >=", value, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartLessThan(Integer value) {
            addCriterion("forum_start <", value, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartLessThanOrEqualTo(Integer value) {
            addCriterion("forum_start <=", value, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartIn(List<Integer> values) {
            addCriterion("forum_start in", values, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartNotIn(List<Integer> values) {
            addCriterion("forum_start not in", values, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartBetween(Integer value1, Integer value2) {
            addCriterion("forum_start between", value1, value2, "forumStart");
            return (Criteria) this;
        }

        public Criteria andForumStartNotBetween(Integer value1, Integer value2) {
            addCriterion("forum_start not between", value1, value2, "forumStart");
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