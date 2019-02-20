package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProPublisherIsNull() {
            addCriterion("pro_publisher is null");
            return (Criteria) this;
        }

        public Criteria andProPublisherIsNotNull() {
            addCriterion("pro_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andProPublisherEqualTo(String value) {
            addCriterion("pro_publisher =", value, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherNotEqualTo(String value) {
            addCriterion("pro_publisher <>", value, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherGreaterThan(String value) {
            addCriterion("pro_publisher >", value, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("pro_publisher >=", value, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherLessThan(String value) {
            addCriterion("pro_publisher <", value, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherLessThanOrEqualTo(String value) {
            addCriterion("pro_publisher <=", value, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherLike(String value) {
            addCriterion("pro_publisher like", value, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherNotLike(String value) {
            addCriterion("pro_publisher not like", value, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherIn(List<String> values) {
            addCriterion("pro_publisher in", values, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherNotIn(List<String> values) {
            addCriterion("pro_publisher not in", values, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherBetween(String value1, String value2) {
            addCriterion("pro_publisher between", value1, value2, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPublisherNotBetween(String value1, String value2) {
            addCriterion("pro_publisher not between", value1, value2, "proPublisher");
            return (Criteria) this;
        }

        public Criteria andProPubnameIsNull() {
            addCriterion("pro_pubname is null");
            return (Criteria) this;
        }

        public Criteria andProPubnameIsNotNull() {
            addCriterion("pro_pubname is not null");
            return (Criteria) this;
        }

        public Criteria andProPubnameEqualTo(String value) {
            addCriterion("pro_pubname =", value, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameNotEqualTo(String value) {
            addCriterion("pro_pubname <>", value, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameGreaterThan(String value) {
            addCriterion("pro_pubname >", value, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_pubname >=", value, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameLessThan(String value) {
            addCriterion("pro_pubname <", value, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameLessThanOrEqualTo(String value) {
            addCriterion("pro_pubname <=", value, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameLike(String value) {
            addCriterion("pro_pubname like", value, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameNotLike(String value) {
            addCriterion("pro_pubname not like", value, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameIn(List<String> values) {
            addCriterion("pro_pubname in", values, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameNotIn(List<String> values) {
            addCriterion("pro_pubname not in", values, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameBetween(String value1, String value2) {
            addCriterion("pro_pubname between", value1, value2, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProPubnameNotBetween(String value1, String value2) {
            addCriterion("pro_pubname not between", value1, value2, "proPubname");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNull() {
            addCriterion("pro_type is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNotNull() {
            addCriterion("pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeEqualTo(String value) {
            addCriterion("pro_type =", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotEqualTo(String value) {
            addCriterion("pro_type <>", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThan(String value) {
            addCriterion("pro_type >", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_type >=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThan(String value) {
            addCriterion("pro_type <", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThanOrEqualTo(String value) {
            addCriterion("pro_type <=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLike(String value) {
            addCriterion("pro_type like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotLike(String value) {
            addCriterion("pro_type not like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeIn(List<String> values) {
            addCriterion("pro_type in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotIn(List<String> values) {
            addCriterion("pro_type not in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeBetween(String value1, String value2) {
            addCriterion("pro_type between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotBetween(String value1, String value2) {
            addCriterion("pro_type not between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProMoneyIsNull() {
            addCriterion("pro_money is null");
            return (Criteria) this;
        }

        public Criteria andProMoneyIsNotNull() {
            addCriterion("pro_money is not null");
            return (Criteria) this;
        }

        public Criteria andProMoneyEqualTo(Double value) {
            addCriterion("pro_money =", value, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyNotEqualTo(Double value) {
            addCriterion("pro_money <>", value, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyGreaterThan(Double value) {
            addCriterion("pro_money >", value, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("pro_money >=", value, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyLessThan(Double value) {
            addCriterion("pro_money <", value, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyLessThanOrEqualTo(Double value) {
            addCriterion("pro_money <=", value, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyIn(List<Double> values) {
            addCriterion("pro_money in", values, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyNotIn(List<Double> values) {
            addCriterion("pro_money not in", values, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyBetween(Double value1, Double value2) {
            addCriterion("pro_money between", value1, value2, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProMoneyNotBetween(Double value1, Double value2) {
            addCriterion("pro_money not between", value1, value2, "proMoney");
            return (Criteria) this;
        }

        public Criteria andProFoutimeIsNull() {
            addCriterion("pro_foutime is null");
            return (Criteria) this;
        }

        public Criteria andProFoutimeIsNotNull() {
            addCriterion("pro_foutime is not null");
            return (Criteria) this;
        }

        public Criteria andProFoutimeEqualTo(Date value) {
            addCriterion("pro_foutime =", value, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeNotEqualTo(Date value) {
            addCriterion("pro_foutime <>", value, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeGreaterThan(Date value) {
            addCriterion("pro_foutime >", value, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pro_foutime >=", value, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeLessThan(Date value) {
            addCriterion("pro_foutime <", value, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeLessThanOrEqualTo(Date value) {
            addCriterion("pro_foutime <=", value, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeIn(List<Date> values) {
            addCriterion("pro_foutime in", values, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeNotIn(List<Date> values) {
            addCriterion("pro_foutime not in", values, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeBetween(Date value1, Date value2) {
            addCriterion("pro_foutime between", value1, value2, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProFoutimeNotBetween(Date value1, Date value2) {
            addCriterion("pro_foutime not between", value1, value2, "proFoutime");
            return (Criteria) this;
        }

        public Criteria andProReltimeIsNull() {
            addCriterion("pro_reltime is null");
            return (Criteria) this;
        }

        public Criteria andProReltimeIsNotNull() {
            addCriterion("pro_reltime is not null");
            return (Criteria) this;
        }

        public Criteria andProReltimeEqualTo(Date value) {
            addCriterion("pro_reltime =", value, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeNotEqualTo(Date value) {
            addCriterion("pro_reltime <>", value, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeGreaterThan(Date value) {
            addCriterion("pro_reltime >", value, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pro_reltime >=", value, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeLessThan(Date value) {
            addCriterion("pro_reltime <", value, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeLessThanOrEqualTo(Date value) {
            addCriterion("pro_reltime <=", value, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeIn(List<Date> values) {
            addCriterion("pro_reltime in", values, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeNotIn(List<Date> values) {
            addCriterion("pro_reltime not in", values, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeBetween(Date value1, Date value2) {
            addCriterion("pro_reltime between", value1, value2, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProReltimeNotBetween(Date value1, Date value2) {
            addCriterion("pro_reltime not between", value1, value2, "proReltime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeIsNull() {
            addCriterion("pro_endtime is null");
            return (Criteria) this;
        }

        public Criteria andProEndtimeIsNotNull() {
            addCriterion("pro_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andProEndtimeEqualTo(Date value) {
            addCriterion("pro_endtime =", value, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeNotEqualTo(Date value) {
            addCriterion("pro_endtime <>", value, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeGreaterThan(Date value) {
            addCriterion("pro_endtime >", value, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pro_endtime >=", value, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeLessThan(Date value) {
            addCriterion("pro_endtime <", value, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("pro_endtime <=", value, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeIn(List<Date> values) {
            addCriterion("pro_endtime in", values, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeNotIn(List<Date> values) {
            addCriterion("pro_endtime not in", values, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeBetween(Date value1, Date value2) {
            addCriterion("pro_endtime between", value1, value2, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("pro_endtime not between", value1, value2, "proEndtime");
            return (Criteria) this;
        }

        public Criteria andProCityIsNull() {
            addCriterion("pro_city is null");
            return (Criteria) this;
        }

        public Criteria andProCityIsNotNull() {
            addCriterion("pro_city is not null");
            return (Criteria) this;
        }

        public Criteria andProCityEqualTo(String value) {
            addCriterion("pro_city =", value, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityNotEqualTo(String value) {
            addCriterion("pro_city <>", value, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityGreaterThan(String value) {
            addCriterion("pro_city >", value, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityGreaterThanOrEqualTo(String value) {
            addCriterion("pro_city >=", value, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityLessThan(String value) {
            addCriterion("pro_city <", value, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityLessThanOrEqualTo(String value) {
            addCriterion("pro_city <=", value, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityLike(String value) {
            addCriterion("pro_city like", value, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityNotLike(String value) {
            addCriterion("pro_city not like", value, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityIn(List<String> values) {
            addCriterion("pro_city in", values, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityNotIn(List<String> values) {
            addCriterion("pro_city not in", values, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityBetween(String value1, String value2) {
            addCriterion("pro_city between", value1, value2, "proCity");
            return (Criteria) this;
        }

        public Criteria andProCityNotBetween(String value1, String value2) {
            addCriterion("pro_city not between", value1, value2, "proCity");
            return (Criteria) this;
        }

        public Criteria andProHeatIsNull() {
            addCriterion("pro_heat is null");
            return (Criteria) this;
        }

        public Criteria andProHeatIsNotNull() {
            addCriterion("pro_heat is not null");
            return (Criteria) this;
        }

        public Criteria andProHeatEqualTo(Integer value) {
            addCriterion("pro_heat =", value, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatNotEqualTo(Integer value) {
            addCriterion("pro_heat <>", value, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatGreaterThan(Integer value) {
            addCriterion("pro_heat >", value, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_heat >=", value, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatLessThan(Integer value) {
            addCriterion("pro_heat <", value, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatLessThanOrEqualTo(Integer value) {
            addCriterion("pro_heat <=", value, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatIn(List<Integer> values) {
            addCriterion("pro_heat in", values, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatNotIn(List<Integer> values) {
            addCriterion("pro_heat not in", values, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatBetween(Integer value1, Integer value2) {
            addCriterion("pro_heat between", value1, value2, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProHeatNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_heat not between", value1, value2, "proHeat");
            return (Criteria) this;
        }

        public Criteria andProStateIsNull() {
            addCriterion("pro_state is null");
            return (Criteria) this;
        }

        public Criteria andProStateIsNotNull() {
            addCriterion("pro_state is not null");
            return (Criteria) this;
        }

        public Criteria andProStateEqualTo(Integer value) {
            addCriterion("pro_state =", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateNotEqualTo(Integer value) {
            addCriterion("pro_state <>", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateGreaterThan(Integer value) {
            addCriterion("pro_state >", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_state >=", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateLessThan(Integer value) {
            addCriterion("pro_state <", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateLessThanOrEqualTo(Integer value) {
            addCriterion("pro_state <=", value, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateIn(List<Integer> values) {
            addCriterion("pro_state in", values, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateNotIn(List<Integer> values) {
            addCriterion("pro_state not in", values, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateBetween(Integer value1, Integer value2) {
            addCriterion("pro_state between", value1, value2, "proState");
            return (Criteria) this;
        }

        public Criteria andProStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_state not between", value1, value2, "proState");
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