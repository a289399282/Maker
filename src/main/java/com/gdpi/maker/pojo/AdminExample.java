package com.gdpi.maker.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdIdIsNull() {
            addCriterion("ad_id is null");
            return (Criteria) this;
        }

        public Criteria andAdIdIsNotNull() {
            addCriterion("ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdEqualTo(String value) {
            addCriterion("ad_id =", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotEqualTo(String value) {
            addCriterion("ad_id <>", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThan(String value) {
            addCriterion("ad_id >", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThanOrEqualTo(String value) {
            addCriterion("ad_id >=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThan(String value) {
            addCriterion("ad_id <", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThanOrEqualTo(String value) {
            addCriterion("ad_id <=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLike(String value) {
            addCriterion("ad_id like", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotLike(String value) {
            addCriterion("ad_id not like", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdIn(List<String> values) {
            addCriterion("ad_id in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotIn(List<String> values) {
            addCriterion("ad_id not in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdBetween(String value1, String value2) {
            addCriterion("ad_id between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotBetween(String value1, String value2) {
            addCriterion("ad_id not between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNull() {
            addCriterion("ad_name is null");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNotNull() {
            addCriterion("ad_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdNameEqualTo(String value) {
            addCriterion("ad_name =", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotEqualTo(String value) {
            addCriterion("ad_name <>", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThan(String value) {
            addCriterion("ad_name >", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_name >=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThan(String value) {
            addCriterion("ad_name <", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThanOrEqualTo(String value) {
            addCriterion("ad_name <=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLike(String value) {
            addCriterion("ad_name like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotLike(String value) {
            addCriterion("ad_name not like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameIn(List<String> values) {
            addCriterion("ad_name in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotIn(List<String> values) {
            addCriterion("ad_name not in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameBetween(String value1, String value2) {
            addCriterion("ad_name between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotBetween(String value1, String value2) {
            addCriterion("ad_name not between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdPhoneIsNull() {
            addCriterion("ad_phone is null");
            return (Criteria) this;
        }

        public Criteria andAdPhoneIsNotNull() {
            addCriterion("ad_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAdPhoneEqualTo(String value) {
            addCriterion("ad_phone =", value, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneNotEqualTo(String value) {
            addCriterion("ad_phone <>", value, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneGreaterThan(String value) {
            addCriterion("ad_phone >", value, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ad_phone >=", value, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneLessThan(String value) {
            addCriterion("ad_phone <", value, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneLessThanOrEqualTo(String value) {
            addCriterion("ad_phone <=", value, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneLike(String value) {
            addCriterion("ad_phone like", value, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneNotLike(String value) {
            addCriterion("ad_phone not like", value, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneIn(List<String> values) {
            addCriterion("ad_phone in", values, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneNotIn(List<String> values) {
            addCriterion("ad_phone not in", values, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneBetween(String value1, String value2) {
            addCriterion("ad_phone between", value1, value2, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPhoneNotBetween(String value1, String value2) {
            addCriterion("ad_phone not between", value1, value2, "adPhone");
            return (Criteria) this;
        }

        public Criteria andAdPasswordIsNull() {
            addCriterion("ad_password is null");
            return (Criteria) this;
        }

        public Criteria andAdPasswordIsNotNull() {
            addCriterion("ad_password is not null");
            return (Criteria) this;
        }

        public Criteria andAdPasswordEqualTo(String value) {
            addCriterion("ad_password =", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordNotEqualTo(String value) {
            addCriterion("ad_password <>", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordGreaterThan(String value) {
            addCriterion("ad_password >", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("ad_password >=", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordLessThan(String value) {
            addCriterion("ad_password <", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordLessThanOrEqualTo(String value) {
            addCriterion("ad_password <=", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordLike(String value) {
            addCriterion("ad_password like", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordNotLike(String value) {
            addCriterion("ad_password not like", value, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordIn(List<String> values) {
            addCriterion("ad_password in", values, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordNotIn(List<String> values) {
            addCriterion("ad_password not in", values, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordBetween(String value1, String value2) {
            addCriterion("ad_password between", value1, value2, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordNotBetween(String value1, String value2) {
            addCriterion("ad_password not between", value1, value2, "adPassword");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5IsNull() {
            addCriterion("ad_passwordmd5 is null");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5IsNotNull() {
            addCriterion("ad_passwordmd5 is not null");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5EqualTo(String value) {
            addCriterion("ad_passwordmd5 =", value, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5NotEqualTo(String value) {
            addCriterion("ad_passwordmd5 <>", value, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5GreaterThan(String value) {
            addCriterion("ad_passwordmd5 >", value, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5GreaterThanOrEqualTo(String value) {
            addCriterion("ad_passwordmd5 >=", value, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5LessThan(String value) {
            addCriterion("ad_passwordmd5 <", value, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5LessThanOrEqualTo(String value) {
            addCriterion("ad_passwordmd5 <=", value, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5Like(String value) {
            addCriterion("ad_passwordmd5 like", value, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5NotLike(String value) {
            addCriterion("ad_passwordmd5 not like", value, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5In(List<String> values) {
            addCriterion("ad_passwordmd5 in", values, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5NotIn(List<String> values) {
            addCriterion("ad_passwordmd5 not in", values, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5Between(String value1, String value2) {
            addCriterion("ad_passwordmd5 between", value1, value2, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdPasswordmd5NotBetween(String value1, String value2) {
            addCriterion("ad_passwordmd5 not between", value1, value2, "adPasswordmd5");
            return (Criteria) this;
        }

        public Criteria andAdTruenameIsNull() {
            addCriterion("ad_truename is null");
            return (Criteria) this;
        }

        public Criteria andAdTruenameIsNotNull() {
            addCriterion("ad_truename is not null");
            return (Criteria) this;
        }

        public Criteria andAdTruenameEqualTo(String value) {
            addCriterion("ad_truename =", value, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameNotEqualTo(String value) {
            addCriterion("ad_truename <>", value, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameGreaterThan(String value) {
            addCriterion("ad_truename >", value, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_truename >=", value, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameLessThan(String value) {
            addCriterion("ad_truename <", value, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameLessThanOrEqualTo(String value) {
            addCriterion("ad_truename <=", value, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameLike(String value) {
            addCriterion("ad_truename like", value, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameNotLike(String value) {
            addCriterion("ad_truename not like", value, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameIn(List<String> values) {
            addCriterion("ad_truename in", values, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameNotIn(List<String> values) {
            addCriterion("ad_truename not in", values, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameBetween(String value1, String value2) {
            addCriterion("ad_truename between", value1, value2, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdTruenameNotBetween(String value1, String value2) {
            addCriterion("ad_truename not between", value1, value2, "adTruename");
            return (Criteria) this;
        }

        public Criteria andAdIdcardIsNull() {
            addCriterion("ad_idcard is null");
            return (Criteria) this;
        }

        public Criteria andAdIdcardIsNotNull() {
            addCriterion("ad_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdcardEqualTo(String value) {
            addCriterion("ad_idcard =", value, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardNotEqualTo(String value) {
            addCriterion("ad_idcard <>", value, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardGreaterThan(String value) {
            addCriterion("ad_idcard >", value, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("ad_idcard >=", value, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardLessThan(String value) {
            addCriterion("ad_idcard <", value, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardLessThanOrEqualTo(String value) {
            addCriterion("ad_idcard <=", value, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardLike(String value) {
            addCriterion("ad_idcard like", value, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardNotLike(String value) {
            addCriterion("ad_idcard not like", value, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardIn(List<String> values) {
            addCriterion("ad_idcard in", values, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardNotIn(List<String> values) {
            addCriterion("ad_idcard not in", values, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardBetween(String value1, String value2) {
            addCriterion("ad_idcard between", value1, value2, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdIdcardNotBetween(String value1, String value2) {
            addCriterion("ad_idcard not between", value1, value2, "adIdcard");
            return (Criteria) this;
        }

        public Criteria andAdTrueIsNull() {
            addCriterion("ad_true is null");
            return (Criteria) this;
        }

        public Criteria andAdTrueIsNotNull() {
            addCriterion("ad_true is not null");
            return (Criteria) this;
        }

        public Criteria andAdTrueEqualTo(Integer value) {
            addCriterion("ad_true =", value, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueNotEqualTo(Integer value) {
            addCriterion("ad_true <>", value, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueGreaterThan(Integer value) {
            addCriterion("ad_true >", value, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_true >=", value, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueLessThan(Integer value) {
            addCriterion("ad_true <", value, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueLessThanOrEqualTo(Integer value) {
            addCriterion("ad_true <=", value, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueIn(List<Integer> values) {
            addCriterion("ad_true in", values, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueNotIn(List<Integer> values) {
            addCriterion("ad_true not in", values, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueBetween(Integer value1, Integer value2) {
            addCriterion("ad_true between", value1, value2, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdTrueNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_true not between", value1, value2, "adTrue");
            return (Criteria) this;
        }

        public Criteria andAdEmailIsNull() {
            addCriterion("ad_email is null");
            return (Criteria) this;
        }

        public Criteria andAdEmailIsNotNull() {
            addCriterion("ad_email is not null");
            return (Criteria) this;
        }

        public Criteria andAdEmailEqualTo(String value) {
            addCriterion("ad_email =", value, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailNotEqualTo(String value) {
            addCriterion("ad_email <>", value, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailGreaterThan(String value) {
            addCriterion("ad_email >", value, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailGreaterThanOrEqualTo(String value) {
            addCriterion("ad_email >=", value, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailLessThan(String value) {
            addCriterion("ad_email <", value, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailLessThanOrEqualTo(String value) {
            addCriterion("ad_email <=", value, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailLike(String value) {
            addCriterion("ad_email like", value, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailNotLike(String value) {
            addCriterion("ad_email not like", value, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailIn(List<String> values) {
            addCriterion("ad_email in", values, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailNotIn(List<String> values) {
            addCriterion("ad_email not in", values, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailBetween(String value1, String value2) {
            addCriterion("ad_email between", value1, value2, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdEmailNotBetween(String value1, String value2) {
            addCriterion("ad_email not between", value1, value2, "adEmail");
            return (Criteria) this;
        }

        public Criteria andAdImgIsNull() {
            addCriterion("ad_img is null");
            return (Criteria) this;
        }

        public Criteria andAdImgIsNotNull() {
            addCriterion("ad_img is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgEqualTo(String value) {
            addCriterion("ad_img =", value, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgNotEqualTo(String value) {
            addCriterion("ad_img <>", value, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgGreaterThan(String value) {
            addCriterion("ad_img >", value, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgGreaterThanOrEqualTo(String value) {
            addCriterion("ad_img >=", value, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgLessThan(String value) {
            addCriterion("ad_img <", value, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgLessThanOrEqualTo(String value) {
            addCriterion("ad_img <=", value, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgLike(String value) {
            addCriterion("ad_img like", value, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgNotLike(String value) {
            addCriterion("ad_img not like", value, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgIn(List<String> values) {
            addCriterion("ad_img in", values, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgNotIn(List<String> values) {
            addCriterion("ad_img not in", values, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgBetween(String value1, String value2) {
            addCriterion("ad_img between", value1, value2, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdImgNotBetween(String value1, String value2) {
            addCriterion("ad_img not between", value1, value2, "adImg");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeIsNull() {
            addCriterion("ad_registime is null");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeIsNotNull() {
            addCriterion("ad_registime is not null");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeEqualTo(Date value) {
            addCriterion("ad_registime =", value, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeNotEqualTo(Date value) {
            addCriterion("ad_registime <>", value, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeGreaterThan(Date value) {
            addCriterion("ad_registime >", value, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ad_registime >=", value, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeLessThan(Date value) {
            addCriterion("ad_registime <", value, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeLessThanOrEqualTo(Date value) {
            addCriterion("ad_registime <=", value, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeIn(List<Date> values) {
            addCriterion("ad_registime in", values, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeNotIn(List<Date> values) {
            addCriterion("ad_registime not in", values, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeBetween(Date value1, Date value2) {
            addCriterion("ad_registime between", value1, value2, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdRegistimeNotBetween(Date value1, Date value2) {
            addCriterion("ad_registime not between", value1, value2, "adRegistime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeIsNull() {
            addCriterion("ad_endtime is null");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeIsNotNull() {
            addCriterion("ad_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeEqualTo(Date value) {
            addCriterion("ad_endtime =", value, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeNotEqualTo(Date value) {
            addCriterion("ad_endtime <>", value, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeGreaterThan(Date value) {
            addCriterion("ad_endtime >", value, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ad_endtime >=", value, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeLessThan(Date value) {
            addCriterion("ad_endtime <", value, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("ad_endtime <=", value, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeIn(List<Date> values) {
            addCriterion("ad_endtime in", values, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeNotIn(List<Date> values) {
            addCriterion("ad_endtime not in", values, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeBetween(Date value1, Date value2) {
            addCriterion("ad_endtime between", value1, value2, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("ad_endtime not between", value1, value2, "adEndtime");
            return (Criteria) this;
        }

        public Criteria andAdStartIsNull() {
            addCriterion("ad_start is null");
            return (Criteria) this;
        }

        public Criteria andAdStartIsNotNull() {
            addCriterion("ad_start is not null");
            return (Criteria) this;
        }

        public Criteria andAdStartEqualTo(Integer value) {
            addCriterion("ad_start =", value, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartNotEqualTo(Integer value) {
            addCriterion("ad_start <>", value, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartGreaterThan(Integer value) {
            addCriterion("ad_start >", value, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_start >=", value, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartLessThan(Integer value) {
            addCriterion("ad_start <", value, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartLessThanOrEqualTo(Integer value) {
            addCriterion("ad_start <=", value, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartIn(List<Integer> values) {
            addCriterion("ad_start in", values, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartNotIn(List<Integer> values) {
            addCriterion("ad_start not in", values, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartBetween(Integer value1, Integer value2) {
            addCriterion("ad_start between", value1, value2, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdStartNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_start not between", value1, value2, "adStart");
            return (Criteria) this;
        }

        public Criteria andAdPowerIsNull() {
            addCriterion("ad_power is null");
            return (Criteria) this;
        }

        public Criteria andAdPowerIsNotNull() {
            addCriterion("ad_power is not null");
            return (Criteria) this;
        }

        public Criteria andAdPowerEqualTo(Integer value) {
            addCriterion("ad_power =", value, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerNotEqualTo(Integer value) {
            addCriterion("ad_power <>", value, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerGreaterThan(Integer value) {
            addCriterion("ad_power >", value, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_power >=", value, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerLessThan(Integer value) {
            addCriterion("ad_power <", value, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerLessThanOrEqualTo(Integer value) {
            addCriterion("ad_power <=", value, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerIn(List<Integer> values) {
            addCriterion("ad_power in", values, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerNotIn(List<Integer> values) {
            addCriterion("ad_power not in", values, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerBetween(Integer value1, Integer value2) {
            addCriterion("ad_power between", value1, value2, "adPower");
            return (Criteria) this;
        }

        public Criteria andAdPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_power not between", value1, value2, "adPower");
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