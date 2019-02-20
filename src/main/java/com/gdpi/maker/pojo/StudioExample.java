package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudioExample() {
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

        public Criteria andStuNameIsNull() {
            addCriterion("stu_name is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stu_name is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stu_name =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stu_name <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stu_name >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stu_name >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stu_name <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stu_name <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stu_name like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stu_name not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stu_name in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stu_name not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stu_name between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stu_name not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeIsNull() {
            addCriterion("stu_registime is null");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeIsNotNull() {
            addCriterion("stu_registime is not null");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeEqualTo(Date value) {
            addCriterion("stu_registime =", value, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeNotEqualTo(Date value) {
            addCriterion("stu_registime <>", value, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeGreaterThan(Date value) {
            addCriterion("stu_registime >", value, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stu_registime >=", value, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeLessThan(Date value) {
            addCriterion("stu_registime <", value, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeLessThanOrEqualTo(Date value) {
            addCriterion("stu_registime <=", value, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeIn(List<Date> values) {
            addCriterion("stu_registime in", values, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeNotIn(List<Date> values) {
            addCriterion("stu_registime not in", values, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeBetween(Date value1, Date value2) {
            addCriterion("stu_registime between", value1, value2, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuRegistimeNotBetween(Date value1, Date value2) {
            addCriterion("stu_registime not between", value1, value2, "stuRegistime");
            return (Criteria) this;
        }

        public Criteria andStuImgIsNull() {
            addCriterion("stu_img is null");
            return (Criteria) this;
        }

        public Criteria andStuImgIsNotNull() {
            addCriterion("stu_img is not null");
            return (Criteria) this;
        }

        public Criteria andStuImgEqualTo(String value) {
            addCriterion("stu_img =", value, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgNotEqualTo(String value) {
            addCriterion("stu_img <>", value, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgGreaterThan(String value) {
            addCriterion("stu_img >", value, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgGreaterThanOrEqualTo(String value) {
            addCriterion("stu_img >=", value, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgLessThan(String value) {
            addCriterion("stu_img <", value, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgLessThanOrEqualTo(String value) {
            addCriterion("stu_img <=", value, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgLike(String value) {
            addCriterion("stu_img like", value, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgNotLike(String value) {
            addCriterion("stu_img not like", value, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgIn(List<String> values) {
            addCriterion("stu_img in", values, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgNotIn(List<String> values) {
            addCriterion("stu_img not in", values, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgBetween(String value1, String value2) {
            addCriterion("stu_img between", value1, value2, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuImgNotBetween(String value1, String value2) {
            addCriterion("stu_img not between", value1, value2, "stuImg");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNull() {
            addCriterion("stu_phone is null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNotNull() {
            addCriterion("stu_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneEqualTo(String value) {
            addCriterion("stu_phone =", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotEqualTo(String value) {
            addCriterion("stu_phone <>", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThan(String value) {
            addCriterion("stu_phone >", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("stu_phone >=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThan(String value) {
            addCriterion("stu_phone <", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThanOrEqualTo(String value) {
            addCriterion("stu_phone <=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLike(String value) {
            addCriterion("stu_phone like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotLike(String value) {
            addCriterion("stu_phone not like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIn(List<String> values) {
            addCriterion("stu_phone in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotIn(List<String> values) {
            addCriterion("stu_phone not in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneBetween(String value1, String value2) {
            addCriterion("stu_phone between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotBetween(String value1, String value2) {
            addCriterion("stu_phone not between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuEmailIsNull() {
            addCriterion("stu_email is null");
            return (Criteria) this;
        }

        public Criteria andStuEmailIsNotNull() {
            addCriterion("stu_email is not null");
            return (Criteria) this;
        }

        public Criteria andStuEmailEqualTo(String value) {
            addCriterion("stu_email =", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotEqualTo(String value) {
            addCriterion("stu_email <>", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailGreaterThan(String value) {
            addCriterion("stu_email >", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailGreaterThanOrEqualTo(String value) {
            addCriterion("stu_email >=", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLessThan(String value) {
            addCriterion("stu_email <", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLessThanOrEqualTo(String value) {
            addCriterion("stu_email <=", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLike(String value) {
            addCriterion("stu_email like", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotLike(String value) {
            addCriterion("stu_email not like", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailIn(List<String> values) {
            addCriterion("stu_email in", values, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotIn(List<String> values) {
            addCriterion("stu_email not in", values, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailBetween(String value1, String value2) {
            addCriterion("stu_email between", value1, value2, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotBetween(String value1, String value2) {
            addCriterion("stu_email not between", value1, value2, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuLocationIsNull() {
            addCriterion("stu_location is null");
            return (Criteria) this;
        }

        public Criteria andStuLocationIsNotNull() {
            addCriterion("stu_location is not null");
            return (Criteria) this;
        }

        public Criteria andStuLocationEqualTo(String value) {
            addCriterion("stu_location =", value, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationNotEqualTo(String value) {
            addCriterion("stu_location <>", value, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationGreaterThan(String value) {
            addCriterion("stu_location >", value, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationGreaterThanOrEqualTo(String value) {
            addCriterion("stu_location >=", value, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationLessThan(String value) {
            addCriterion("stu_location <", value, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationLessThanOrEqualTo(String value) {
            addCriterion("stu_location <=", value, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationLike(String value) {
            addCriterion("stu_location like", value, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationNotLike(String value) {
            addCriterion("stu_location not like", value, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationIn(List<String> values) {
            addCriterion("stu_location in", values, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationNotIn(List<String> values) {
            addCriterion("stu_location not in", values, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationBetween(String value1, String value2) {
            addCriterion("stu_location between", value1, value2, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuLocationNotBetween(String value1, String value2) {
            addCriterion("stu_location not between", value1, value2, "stuLocation");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityIsNull() {
            addCriterion("stu_speciality is null");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityIsNotNull() {
            addCriterion("stu_speciality is not null");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityEqualTo(String value) {
            addCriterion("stu_speciality =", value, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityNotEqualTo(String value) {
            addCriterion("stu_speciality <>", value, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityGreaterThan(String value) {
            addCriterion("stu_speciality >", value, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("stu_speciality >=", value, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityLessThan(String value) {
            addCriterion("stu_speciality <", value, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityLessThanOrEqualTo(String value) {
            addCriterion("stu_speciality <=", value, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityLike(String value) {
            addCriterion("stu_speciality like", value, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityNotLike(String value) {
            addCriterion("stu_speciality not like", value, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityIn(List<String> values) {
            addCriterion("stu_speciality in", values, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityNotIn(List<String> values) {
            addCriterion("stu_speciality not in", values, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityBetween(String value1, String value2) {
            addCriterion("stu_speciality between", value1, value2, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuSpecialityNotBetween(String value1, String value2) {
            addCriterion("stu_speciality not between", value1, value2, "stuSpeciality");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeIsNull() {
            addCriterion("stu_endtime is null");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeIsNotNull() {
            addCriterion("stu_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeEqualTo(Date value) {
            addCriterion("stu_endtime =", value, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeNotEqualTo(Date value) {
            addCriterion("stu_endtime <>", value, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeGreaterThan(Date value) {
            addCriterion("stu_endtime >", value, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stu_endtime >=", value, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeLessThan(Date value) {
            addCriterion("stu_endtime <", value, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("stu_endtime <=", value, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeIn(List<Date> values) {
            addCriterion("stu_endtime in", values, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeNotIn(List<Date> values) {
            addCriterion("stu_endtime not in", values, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeBetween(Date value1, Date value2) {
            addCriterion("stu_endtime between", value1, value2, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("stu_endtime not between", value1, value2, "stuEndtime");
            return (Criteria) this;
        }

        public Criteria andStuStartIsNull() {
            addCriterion("stu_start is null");
            return (Criteria) this;
        }

        public Criteria andStuStartIsNotNull() {
            addCriterion("stu_start is not null");
            return (Criteria) this;
        }

        public Criteria andStuStartEqualTo(Integer value) {
            addCriterion("stu_start =", value, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartNotEqualTo(Integer value) {
            addCriterion("stu_start <>", value, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartGreaterThan(Integer value) {
            addCriterion("stu_start >", value, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_start >=", value, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartLessThan(Integer value) {
            addCriterion("stu_start <", value, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartLessThanOrEqualTo(Integer value) {
            addCriterion("stu_start <=", value, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartIn(List<Integer> values) {
            addCriterion("stu_start in", values, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartNotIn(List<Integer> values) {
            addCriterion("stu_start not in", values, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartBetween(Integer value1, Integer value2) {
            addCriterion("stu_start between", value1, value2, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuStartNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_start not between", value1, value2, "stuStart");
            return (Criteria) this;
        }

        public Criteria andStuPraiseIsNull() {
            addCriterion("stu_praise is null");
            return (Criteria) this;
        }

        public Criteria andStuPraiseIsNotNull() {
            addCriterion("stu_praise is not null");
            return (Criteria) this;
        }

        public Criteria andStuPraiseEqualTo(Integer value) {
            addCriterion("stu_praise =", value, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseNotEqualTo(Integer value) {
            addCriterion("stu_praise <>", value, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseGreaterThan(Integer value) {
            addCriterion("stu_praise >", value, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_praise >=", value, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseLessThan(Integer value) {
            addCriterion("stu_praise <", value, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseLessThanOrEqualTo(Integer value) {
            addCriterion("stu_praise <=", value, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseIn(List<Integer> values) {
            addCriterion("stu_praise in", values, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseNotIn(List<Integer> values) {
            addCriterion("stu_praise not in", values, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseBetween(Integer value1, Integer value2) {
            addCriterion("stu_praise between", value1, value2, "stuPraise");
            return (Criteria) this;
        }

        public Criteria andStuPraiseNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_praise not between", value1, value2, "stuPraise");
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