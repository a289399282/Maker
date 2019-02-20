package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeveloperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeveloperExample() {
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

        public Criteria andDevPhoneIsNull() {
            addCriterion("dev_phone is null");
            return (Criteria) this;
        }

        public Criteria andDevPhoneIsNotNull() {
            addCriterion("dev_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDevPhoneEqualTo(String value) {
            addCriterion("dev_phone =", value, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneNotEqualTo(String value) {
            addCriterion("dev_phone <>", value, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneGreaterThan(String value) {
            addCriterion("dev_phone >", value, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("dev_phone >=", value, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneLessThan(String value) {
            addCriterion("dev_phone <", value, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneLessThanOrEqualTo(String value) {
            addCriterion("dev_phone <=", value, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneLike(String value) {
            addCriterion("dev_phone like", value, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneNotLike(String value) {
            addCriterion("dev_phone not like", value, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneIn(List<String> values) {
            addCriterion("dev_phone in", values, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneNotIn(List<String> values) {
            addCriterion("dev_phone not in", values, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneBetween(String value1, String value2) {
            addCriterion("dev_phone between", value1, value2, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevPhoneNotBetween(String value1, String value2) {
            addCriterion("dev_phone not between", value1, value2, "devPhone");
            return (Criteria) this;
        }

        public Criteria andDevNameIsNull() {
            addCriterion("dev_name is null");
            return (Criteria) this;
        }

        public Criteria andDevNameIsNotNull() {
            addCriterion("dev_name is not null");
            return (Criteria) this;
        }

        public Criteria andDevNameEqualTo(String value) {
            addCriterion("dev_name =", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotEqualTo(String value) {
            addCriterion("dev_name <>", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameGreaterThan(String value) {
            addCriterion("dev_name >", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameGreaterThanOrEqualTo(String value) {
            addCriterion("dev_name >=", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLessThan(String value) {
            addCriterion("dev_name <", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLessThanOrEqualTo(String value) {
            addCriterion("dev_name <=", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLike(String value) {
            addCriterion("dev_name like", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotLike(String value) {
            addCriterion("dev_name not like", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameIn(List<String> values) {
            addCriterion("dev_name in", values, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotIn(List<String> values) {
            addCriterion("dev_name not in", values, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameBetween(String value1, String value2) {
            addCriterion("dev_name between", value1, value2, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotBetween(String value1, String value2) {
            addCriterion("dev_name not between", value1, value2, "devName");
            return (Criteria) this;
        }

        public Criteria andDevPasswordIsNull() {
            addCriterion("dev_password is null");
            return (Criteria) this;
        }

        public Criteria andDevPasswordIsNotNull() {
            addCriterion("dev_password is not null");
            return (Criteria) this;
        }

        public Criteria andDevPasswordEqualTo(String value) {
            addCriterion("dev_password =", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordNotEqualTo(String value) {
            addCriterion("dev_password <>", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordGreaterThan(String value) {
            addCriterion("dev_password >", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("dev_password >=", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordLessThan(String value) {
            addCriterion("dev_password <", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordLessThanOrEqualTo(String value) {
            addCriterion("dev_password <=", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordLike(String value) {
            addCriterion("dev_password like", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordNotLike(String value) {
            addCriterion("dev_password not like", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordIn(List<String> values) {
            addCriterion("dev_password in", values, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordNotIn(List<String> values) {
            addCriterion("dev_password not in", values, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordBetween(String value1, String value2) {
            addCriterion("dev_password between", value1, value2, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordNotBetween(String value1, String value2) {
            addCriterion("dev_password not between", value1, value2, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5IsNull() {
            addCriterion("dev_passwordmd5 is null");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5IsNotNull() {
            addCriterion("dev_passwordmd5 is not null");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5EqualTo(String value) {
            addCriterion("dev_passwordmd5 =", value, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5NotEqualTo(String value) {
            addCriterion("dev_passwordmd5 <>", value, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5GreaterThan(String value) {
            addCriterion("dev_passwordmd5 >", value, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5GreaterThanOrEqualTo(String value) {
            addCriterion("dev_passwordmd5 >=", value, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5LessThan(String value) {
            addCriterion("dev_passwordmd5 <", value, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5LessThanOrEqualTo(String value) {
            addCriterion("dev_passwordmd5 <=", value, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5Like(String value) {
            addCriterion("dev_passwordmd5 like", value, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5NotLike(String value) {
            addCriterion("dev_passwordmd5 not like", value, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5In(List<String> values) {
            addCriterion("dev_passwordmd5 in", values, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5NotIn(List<String> values) {
            addCriterion("dev_passwordmd5 not in", values, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5Between(String value1, String value2) {
            addCriterion("dev_passwordmd5 between", value1, value2, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevPasswordmd5NotBetween(String value1, String value2) {
            addCriterion("dev_passwordmd5 not between", value1, value2, "devPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andDevNumberIsNull() {
            addCriterion("dev_number is null");
            return (Criteria) this;
        }

        public Criteria andDevNumberIsNotNull() {
            addCriterion("dev_number is not null");
            return (Criteria) this;
        }

        public Criteria andDevNumberEqualTo(String value) {
            addCriterion("dev_number =", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberNotEqualTo(String value) {
            addCriterion("dev_number <>", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberGreaterThan(String value) {
            addCriterion("dev_number >", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberGreaterThanOrEqualTo(String value) {
            addCriterion("dev_number >=", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberLessThan(String value) {
            addCriterion("dev_number <", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberLessThanOrEqualTo(String value) {
            addCriterion("dev_number <=", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberLike(String value) {
            addCriterion("dev_number like", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberNotLike(String value) {
            addCriterion("dev_number not like", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberIn(List<String> values) {
            addCriterion("dev_number in", values, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberNotIn(List<String> values) {
            addCriterion("dev_number not in", values, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberBetween(String value1, String value2) {
            addCriterion("dev_number between", value1, value2, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberNotBetween(String value1, String value2) {
            addCriterion("dev_number not between", value1, value2, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevSchoolIsNull() {
            addCriterion("dev_school is null");
            return (Criteria) this;
        }

        public Criteria andDevSchoolIsNotNull() {
            addCriterion("dev_school is not null");
            return (Criteria) this;
        }

        public Criteria andDevSchoolEqualTo(String value) {
            addCriterion("dev_school =", value, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolNotEqualTo(String value) {
            addCriterion("dev_school <>", value, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolGreaterThan(String value) {
            addCriterion("dev_school >", value, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("dev_school >=", value, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolLessThan(String value) {
            addCriterion("dev_school <", value, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolLessThanOrEqualTo(String value) {
            addCriterion("dev_school <=", value, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolLike(String value) {
            addCriterion("dev_school like", value, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolNotLike(String value) {
            addCriterion("dev_school not like", value, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolIn(List<String> values) {
            addCriterion("dev_school in", values, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolNotIn(List<String> values) {
            addCriterion("dev_school not in", values, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolBetween(String value1, String value2) {
            addCriterion("dev_school between", value1, value2, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevSchoolNotBetween(String value1, String value2) {
            addCriterion("dev_school not between", value1, value2, "devSchool");
            return (Criteria) this;
        }

        public Criteria andDevTruenameIsNull() {
            addCriterion("dev_truename is null");
            return (Criteria) this;
        }

        public Criteria andDevTruenameIsNotNull() {
            addCriterion("dev_truename is not null");
            return (Criteria) this;
        }

        public Criteria andDevTruenameEqualTo(String value) {
            addCriterion("dev_truename =", value, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameNotEqualTo(String value) {
            addCriterion("dev_truename <>", value, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameGreaterThan(String value) {
            addCriterion("dev_truename >", value, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameGreaterThanOrEqualTo(String value) {
            addCriterion("dev_truename >=", value, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameLessThan(String value) {
            addCriterion("dev_truename <", value, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameLessThanOrEqualTo(String value) {
            addCriterion("dev_truename <=", value, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameLike(String value) {
            addCriterion("dev_truename like", value, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameNotLike(String value) {
            addCriterion("dev_truename not like", value, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameIn(List<String> values) {
            addCriterion("dev_truename in", values, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameNotIn(List<String> values) {
            addCriterion("dev_truename not in", values, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameBetween(String value1, String value2) {
            addCriterion("dev_truename between", value1, value2, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevTruenameNotBetween(String value1, String value2) {
            addCriterion("dev_truename not between", value1, value2, "devTruename");
            return (Criteria) this;
        }

        public Criteria andDevIdcardIsNull() {
            addCriterion("dev_idcard is null");
            return (Criteria) this;
        }

        public Criteria andDevIdcardIsNotNull() {
            addCriterion("dev_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdcardEqualTo(String value) {
            addCriterion("dev_idcard =", value, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardNotEqualTo(String value) {
            addCriterion("dev_idcard <>", value, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardGreaterThan(String value) {
            addCriterion("dev_idcard >", value, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("dev_idcard >=", value, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardLessThan(String value) {
            addCriterion("dev_idcard <", value, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardLessThanOrEqualTo(String value) {
            addCriterion("dev_idcard <=", value, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardLike(String value) {
            addCriterion("dev_idcard like", value, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardNotLike(String value) {
            addCriterion("dev_idcard not like", value, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardIn(List<String> values) {
            addCriterion("dev_idcard in", values, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardNotIn(List<String> values) {
            addCriterion("dev_idcard not in", values, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardBetween(String value1, String value2) {
            addCriterion("dev_idcard between", value1, value2, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevIdcardNotBetween(String value1, String value2) {
            addCriterion("dev_idcard not between", value1, value2, "devIdcard");
            return (Criteria) this;
        }

        public Criteria andDevTrueIsNull() {
            addCriterion("dev_true is null");
            return (Criteria) this;
        }

        public Criteria andDevTrueIsNotNull() {
            addCriterion("dev_true is not null");
            return (Criteria) this;
        }

        public Criteria andDevTrueEqualTo(Integer value) {
            addCriterion("dev_true =", value, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueNotEqualTo(Integer value) {
            addCriterion("dev_true <>", value, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueGreaterThan(Integer value) {
            addCriterion("dev_true >", value, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueGreaterThanOrEqualTo(Integer value) {
            addCriterion("dev_true >=", value, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueLessThan(Integer value) {
            addCriterion("dev_true <", value, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueLessThanOrEqualTo(Integer value) {
            addCriterion("dev_true <=", value, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueIn(List<Integer> values) {
            addCriterion("dev_true in", values, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueNotIn(List<Integer> values) {
            addCriterion("dev_true not in", values, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueBetween(Integer value1, Integer value2) {
            addCriterion("dev_true between", value1, value2, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevTrueNotBetween(Integer value1, Integer value2) {
            addCriterion("dev_true not between", value1, value2, "devTrue");
            return (Criteria) this;
        }

        public Criteria andDevImgIsNull() {
            addCriterion("dev_img is null");
            return (Criteria) this;
        }

        public Criteria andDevImgIsNotNull() {
            addCriterion("dev_img is not null");
            return (Criteria) this;
        }

        public Criteria andDevImgEqualTo(String value) {
            addCriterion("dev_img =", value, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgNotEqualTo(String value) {
            addCriterion("dev_img <>", value, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgGreaterThan(String value) {
            addCriterion("dev_img >", value, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgGreaterThanOrEqualTo(String value) {
            addCriterion("dev_img >=", value, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgLessThan(String value) {
            addCriterion("dev_img <", value, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgLessThanOrEqualTo(String value) {
            addCriterion("dev_img <=", value, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgLike(String value) {
            addCriterion("dev_img like", value, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgNotLike(String value) {
            addCriterion("dev_img not like", value, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgIn(List<String> values) {
            addCriterion("dev_img in", values, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgNotIn(List<String> values) {
            addCriterion("dev_img not in", values, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgBetween(String value1, String value2) {
            addCriterion("dev_img between", value1, value2, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevImgNotBetween(String value1, String value2) {
            addCriterion("dev_img not between", value1, value2, "devImg");
            return (Criteria) this;
        }

        public Criteria andDevEmailIsNull() {
            addCriterion("dev_email is null");
            return (Criteria) this;
        }

        public Criteria andDevEmailIsNotNull() {
            addCriterion("dev_email is not null");
            return (Criteria) this;
        }

        public Criteria andDevEmailEqualTo(String value) {
            addCriterion("dev_email =", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailNotEqualTo(String value) {
            addCriterion("dev_email <>", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailGreaterThan(String value) {
            addCriterion("dev_email >", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailGreaterThanOrEqualTo(String value) {
            addCriterion("dev_email >=", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailLessThan(String value) {
            addCriterion("dev_email <", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailLessThanOrEqualTo(String value) {
            addCriterion("dev_email <=", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailLike(String value) {
            addCriterion("dev_email like", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailNotLike(String value) {
            addCriterion("dev_email not like", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailIn(List<String> values) {
            addCriterion("dev_email in", values, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailNotIn(List<String> values) {
            addCriterion("dev_email not in", values, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailBetween(String value1, String value2) {
            addCriterion("dev_email between", value1, value2, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailNotBetween(String value1, String value2) {
            addCriterion("dev_email not between", value1, value2, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevLocationIsNull() {
            addCriterion("dev_location is null");
            return (Criteria) this;
        }

        public Criteria andDevLocationIsNotNull() {
            addCriterion("dev_location is not null");
            return (Criteria) this;
        }

        public Criteria andDevLocationEqualTo(String value) {
            addCriterion("dev_location =", value, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationNotEqualTo(String value) {
            addCriterion("dev_location <>", value, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationGreaterThan(String value) {
            addCriterion("dev_location >", value, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationGreaterThanOrEqualTo(String value) {
            addCriterion("dev_location >=", value, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationLessThan(String value) {
            addCriterion("dev_location <", value, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationLessThanOrEqualTo(String value) {
            addCriterion("dev_location <=", value, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationLike(String value) {
            addCriterion("dev_location like", value, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationNotLike(String value) {
            addCriterion("dev_location not like", value, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationIn(List<String> values) {
            addCriterion("dev_location in", values, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationNotIn(List<String> values) {
            addCriterion("dev_location not in", values, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationBetween(String value1, String value2) {
            addCriterion("dev_location between", value1, value2, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevLocationNotBetween(String value1, String value2) {
            addCriterion("dev_location not between", value1, value2, "devLocation");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityIsNull() {
            addCriterion("dev_speciality is null");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityIsNotNull() {
            addCriterion("dev_speciality is not null");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityEqualTo(String value) {
            addCriterion("dev_speciality =", value, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityNotEqualTo(String value) {
            addCriterion("dev_speciality <>", value, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityGreaterThan(String value) {
            addCriterion("dev_speciality >", value, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("dev_speciality >=", value, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityLessThan(String value) {
            addCriterion("dev_speciality <", value, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityLessThanOrEqualTo(String value) {
            addCriterion("dev_speciality <=", value, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityLike(String value) {
            addCriterion("dev_speciality like", value, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityNotLike(String value) {
            addCriterion("dev_speciality not like", value, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityIn(List<String> values) {
            addCriterion("dev_speciality in", values, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityNotIn(List<String> values) {
            addCriterion("dev_speciality not in", values, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityBetween(String value1, String value2) {
            addCriterion("dev_speciality between", value1, value2, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevSpecialityNotBetween(String value1, String value2) {
            addCriterion("dev_speciality not between", value1, value2, "devSpeciality");
            return (Criteria) this;
        }

        public Criteria andDevBackIsNull() {
            addCriterion("dev_back is null");
            return (Criteria) this;
        }

        public Criteria andDevBackIsNotNull() {
            addCriterion("dev_back is not null");
            return (Criteria) this;
        }

        public Criteria andDevBackEqualTo(Integer value) {
            addCriterion("dev_back =", value, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackNotEqualTo(Integer value) {
            addCriterion("dev_back <>", value, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackGreaterThan(Integer value) {
            addCriterion("dev_back >", value, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackGreaterThanOrEqualTo(Integer value) {
            addCriterion("dev_back >=", value, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackLessThan(Integer value) {
            addCriterion("dev_back <", value, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackLessThanOrEqualTo(Integer value) {
            addCriterion("dev_back <=", value, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackIn(List<Integer> values) {
            addCriterion("dev_back in", values, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackNotIn(List<Integer> values) {
            addCriterion("dev_back not in", values, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackBetween(Integer value1, Integer value2) {
            addCriterion("dev_back between", value1, value2, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevBackNotBetween(Integer value1, Integer value2) {
            addCriterion("dev_back not between", value1, value2, "devBack");
            return (Criteria) this;
        }

        public Criteria andDevPraiseIsNull() {
            addCriterion("dev_praise is null");
            return (Criteria) this;
        }

        public Criteria andDevPraiseIsNotNull() {
            addCriterion("dev_praise is not null");
            return (Criteria) this;
        }

        public Criteria andDevPraiseEqualTo(Integer value) {
            addCriterion("dev_praise =", value, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseNotEqualTo(Integer value) {
            addCriterion("dev_praise <>", value, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseGreaterThan(Integer value) {
            addCriterion("dev_praise >", value, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseGreaterThanOrEqualTo(Integer value) {
            addCriterion("dev_praise >=", value, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseLessThan(Integer value) {
            addCriterion("dev_praise <", value, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseLessThanOrEqualTo(Integer value) {
            addCriterion("dev_praise <=", value, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseIn(List<Integer> values) {
            addCriterion("dev_praise in", values, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseNotIn(List<Integer> values) {
            addCriterion("dev_praise not in", values, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseBetween(Integer value1, Integer value2) {
            addCriterion("dev_praise between", value1, value2, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevPraiseNotBetween(Integer value1, Integer value2) {
            addCriterion("dev_praise not between", value1, value2, "devPraise");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeIsNull() {
            addCriterion("dev_registime is null");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeIsNotNull() {
            addCriterion("dev_registime is not null");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeEqualTo(Date value) {
            addCriterion("dev_registime =", value, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeNotEqualTo(Date value) {
            addCriterion("dev_registime <>", value, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeGreaterThan(Date value) {
            addCriterion("dev_registime >", value, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dev_registime >=", value, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeLessThan(Date value) {
            addCriterion("dev_registime <", value, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeLessThanOrEqualTo(Date value) {
            addCriterion("dev_registime <=", value, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeIn(List<Date> values) {
            addCriterion("dev_registime in", values, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeNotIn(List<Date> values) {
            addCriterion("dev_registime not in", values, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeBetween(Date value1, Date value2) {
            addCriterion("dev_registime between", value1, value2, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevRegistimeNotBetween(Date value1, Date value2) {
            addCriterion("dev_registime not between", value1, value2, "devRegistime");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeIsNull() {
            addCriterion("dev_idchange is null");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeIsNotNull() {
            addCriterion("dev_idchange is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeEqualTo(Integer value) {
            addCriterion("dev_idchange =", value, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeNotEqualTo(Integer value) {
            addCriterion("dev_idchange <>", value, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeGreaterThan(Integer value) {
            addCriterion("dev_idchange >", value, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dev_idchange >=", value, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeLessThan(Integer value) {
            addCriterion("dev_idchange <", value, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeLessThanOrEqualTo(Integer value) {
            addCriterion("dev_idchange <=", value, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeIn(List<Integer> values) {
            addCriterion("dev_idchange in", values, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeNotIn(List<Integer> values) {
            addCriterion("dev_idchange not in", values, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeBetween(Integer value1, Integer value2) {
            addCriterion("dev_idchange between", value1, value2, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevIdchangeNotBetween(Integer value1, Integer value2) {
            addCriterion("dev_idchange not between", value1, value2, "devIdchange");
            return (Criteria) this;
        }

        public Criteria andDevCancellationIsNull() {
            addCriterion("dev_cancellation is null");
            return (Criteria) this;
        }

        public Criteria andDevCancellationIsNotNull() {
            addCriterion("dev_cancellation is not null");
            return (Criteria) this;
        }

        public Criteria andDevCancellationEqualTo(Integer value) {
            addCriterion("dev_cancellation =", value, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationNotEqualTo(Integer value) {
            addCriterion("dev_cancellation <>", value, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationGreaterThan(Integer value) {
            addCriterion("dev_cancellation >", value, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationGreaterThanOrEqualTo(Integer value) {
            addCriterion("dev_cancellation >=", value, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationLessThan(Integer value) {
            addCriterion("dev_cancellation <", value, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationLessThanOrEqualTo(Integer value) {
            addCriterion("dev_cancellation <=", value, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationIn(List<Integer> values) {
            addCriterion("dev_cancellation in", values, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationNotIn(List<Integer> values) {
            addCriterion("dev_cancellation not in", values, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationBetween(Integer value1, Integer value2) {
            addCriterion("dev_cancellation between", value1, value2, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationNotBetween(Integer value1, Integer value2) {
            addCriterion("dev_cancellation not between", value1, value2, "devCancellation");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeIsNull() {
            addCriterion("dev_cancellationtime is null");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeIsNotNull() {
            addCriterion("dev_cancellationtime is not null");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeEqualTo(Date value) {
            addCriterion("dev_cancellationtime =", value, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeNotEqualTo(Date value) {
            addCriterion("dev_cancellationtime <>", value, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeGreaterThan(Date value) {
            addCriterion("dev_cancellationtime >", value, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dev_cancellationtime >=", value, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeLessThan(Date value) {
            addCriterion("dev_cancellationtime <", value, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeLessThanOrEqualTo(Date value) {
            addCriterion("dev_cancellationtime <=", value, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeIn(List<Date> values) {
            addCriterion("dev_cancellationtime in", values, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeNotIn(List<Date> values) {
            addCriterion("dev_cancellationtime not in", values, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeBetween(Date value1, Date value2) {
            addCriterion("dev_cancellationtime between", value1, value2, "devCancellationtime");
            return (Criteria) this;
        }

        public Criteria andDevCancellationtimeNotBetween(Date value1, Date value2) {
            addCriterion("dev_cancellationtime not between", value1, value2, "devCancellationtime");
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