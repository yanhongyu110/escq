package com.jero.esc.po.map;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxAdminExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public WxAdminExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
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

        public Criteria andWxAdminIdIsNull() {
            addCriterion("WX_ADMIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdIsNotNull() {
            addCriterion("WX_ADMIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdEqualTo(String value) {
            addCriterion("WX_ADMIN_ID =", value, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdNotEqualTo(String value) {
            addCriterion("WX_ADMIN_ID <>", value, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdGreaterThan(String value) {
            addCriterion("WX_ADMIN_ID >", value, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdGreaterThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_ID >=", value, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdLessThan(String value) {
            addCriterion("WX_ADMIN_ID <", value, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdLessThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_ID <=", value, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdLike(String value) {
            addCriterion("WX_ADMIN_ID like", value, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdNotLike(String value) {
            addCriterion("WX_ADMIN_ID not like", value, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdIn(List<String> values) {
            addCriterion("WX_ADMIN_ID in", values, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdNotIn(List<String> values) {
            addCriterion("WX_ADMIN_ID not in", values, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_ID between", value1, value2, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminIdNotBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_ID not between", value1, value2, "wxAdminId");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidIsNull() {
            addCriterion("WX_ADMIN_OPENID is null");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidIsNotNull() {
            addCriterion("WX_ADMIN_OPENID is not null");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidEqualTo(String value) {
            addCriterion("WX_ADMIN_OPENID =", value, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidNotEqualTo(String value) {
            addCriterion("WX_ADMIN_OPENID <>", value, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidGreaterThan(String value) {
            addCriterion("WX_ADMIN_OPENID >", value, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_OPENID >=", value, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidLessThan(String value) {
            addCriterion("WX_ADMIN_OPENID <", value, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidLessThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_OPENID <=", value, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidLike(String value) {
            addCriterion("WX_ADMIN_OPENID like", value, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidNotLike(String value) {
            addCriterion("WX_ADMIN_OPENID not like", value, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidIn(List<String> values) {
            addCriterion("WX_ADMIN_OPENID in", values, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidNotIn(List<String> values) {
            addCriterion("WX_ADMIN_OPENID not in", values, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_OPENID between", value1, value2, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminOpenidNotBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_OPENID not between", value1, value2, "wxAdminOpenid");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenIsNull() {
            addCriterion("WX_ADMIN_TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenIsNotNull() {
            addCriterion("WX_ADMIN_TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenEqualTo(String value) {
            addCriterion("WX_ADMIN_TOKEN =", value, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenNotEqualTo(String value) {
            addCriterion("WX_ADMIN_TOKEN <>", value, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenGreaterThan(String value) {
            addCriterion("WX_ADMIN_TOKEN >", value, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenGreaterThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_TOKEN >=", value, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenLessThan(String value) {
            addCriterion("WX_ADMIN_TOKEN <", value, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenLessThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_TOKEN <=", value, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenLike(String value) {
            addCriterion("WX_ADMIN_TOKEN like", value, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenNotLike(String value) {
            addCriterion("WX_ADMIN_TOKEN not like", value, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenIn(List<String> values) {
            addCriterion("WX_ADMIN_TOKEN in", values, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenNotIn(List<String> values) {
            addCriterion("WX_ADMIN_TOKEN not in", values, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_TOKEN between", value1, value2, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminTokenNotBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_TOKEN not between", value1, value2, "wxAdminToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenIsNull() {
            addCriterion("WX_ADMIN_R_TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenIsNotNull() {
            addCriterion("WX_ADMIN_R_TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenEqualTo(String value) {
            addCriterion("WX_ADMIN_R_TOKEN =", value, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenNotEqualTo(String value) {
            addCriterion("WX_ADMIN_R_TOKEN <>", value, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenGreaterThan(String value) {
            addCriterion("WX_ADMIN_R_TOKEN >", value, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenGreaterThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_R_TOKEN >=", value, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenLessThan(String value) {
            addCriterion("WX_ADMIN_R_TOKEN <", value, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenLessThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_R_TOKEN <=", value, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenLike(String value) {
            addCriterion("WX_ADMIN_R_TOKEN like", value, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenNotLike(String value) {
            addCriterion("WX_ADMIN_R_TOKEN not like", value, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenIn(List<String> values) {
            addCriterion("WX_ADMIN_R_TOKEN in", values, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenNotIn(List<String> values) {
            addCriterion("WX_ADMIN_R_TOKEN not in", values, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_R_TOKEN between", value1, value2, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminRTokenNotBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_R_TOKEN not between", value1, value2, "wxAdminRToken");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimIsNull() {
            addCriterion("WX_ADMIN_CREATETIM is null");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimIsNotNull() {
            addCriterion("WX_ADMIN_CREATETIM is not null");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimEqualTo(Date value) {
            addCriterion("WX_ADMIN_CREATETIM =", value, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimNotEqualTo(Date value) {
            addCriterion("WX_ADMIN_CREATETIM <>", value, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimGreaterThan(Date value) {
            addCriterion("WX_ADMIN_CREATETIM >", value, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimGreaterThanOrEqualTo(Date value) {
            addCriterion("WX_ADMIN_CREATETIM >=", value, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimLessThan(Date value) {
            addCriterion("WX_ADMIN_CREATETIM <", value, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimLessThanOrEqualTo(Date value) {
            addCriterion("WX_ADMIN_CREATETIM <=", value, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimIn(List<Date> values) {
            addCriterion("WX_ADMIN_CREATETIM in", values, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimNotIn(List<Date> values) {
            addCriterion("WX_ADMIN_CREATETIM not in", values, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimBetween(Date value1, Date value2) {
            addCriterion("WX_ADMIN_CREATETIM between", value1, value2, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminCreatetimNotBetween(Date value1, Date value2) {
            addCriterion("WX_ADMIN_CREATETIM not between", value1, value2, "wxAdminCreatetim");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeIsNull() {
            addCriterion("WX_ADMIN_UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeIsNotNull() {
            addCriterion("WX_ADMIN_UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeEqualTo(Date value) {
            addCriterion("WX_ADMIN_UPDATETIME =", value, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeNotEqualTo(Date value) {
            addCriterion("WX_ADMIN_UPDATETIME <>", value, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeGreaterThan(Date value) {
            addCriterion("WX_ADMIN_UPDATETIME >", value, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WX_ADMIN_UPDATETIME >=", value, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeLessThan(Date value) {
            addCriterion("WX_ADMIN_UPDATETIME <", value, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("WX_ADMIN_UPDATETIME <=", value, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeIn(List<Date> values) {
            addCriterion("WX_ADMIN_UPDATETIME in", values, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeNotIn(List<Date> values) {
            addCriterion("WX_ADMIN_UPDATETIME not in", values, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("WX_ADMIN_UPDATETIME between", value1, value2, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("WX_ADMIN_UPDATETIME not between", value1, value2, "wxAdminUpdatetime");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogIsNull() {
            addCriterion("WX_ADMIN_LOG is null");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogIsNotNull() {
            addCriterion("WX_ADMIN_LOG is not null");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogEqualTo(String value) {
            addCriterion("WX_ADMIN_LOG =", value, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogNotEqualTo(String value) {
            addCriterion("WX_ADMIN_LOG <>", value, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogGreaterThan(String value) {
            addCriterion("WX_ADMIN_LOG >", value, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogGreaterThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_LOG >=", value, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogLessThan(String value) {
            addCriterion("WX_ADMIN_LOG <", value, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogLessThanOrEqualTo(String value) {
            addCriterion("WX_ADMIN_LOG <=", value, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogLike(String value) {
            addCriterion("WX_ADMIN_LOG like", value, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogNotLike(String value) {
            addCriterion("WX_ADMIN_LOG not like", value, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogIn(List<String> values) {
            addCriterion("WX_ADMIN_LOG in", values, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogNotIn(List<String> values) {
            addCriterion("WX_ADMIN_LOG not in", values, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_LOG between", value1, value2, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminLogNotBetween(String value1, String value2) {
            addCriterion("WX_ADMIN_LOG not between", value1, value2, "wxAdminLog");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutIsNull() {
            addCriterion("WX_ADMIN_TIMEOUT is null");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutIsNotNull() {
            addCriterion("WX_ADMIN_TIMEOUT is not null");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutEqualTo(Integer value) {
            addCriterion("WX_ADMIN_TIMEOUT =", value, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutNotEqualTo(Integer value) {
            addCriterion("WX_ADMIN_TIMEOUT <>", value, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutGreaterThan(Integer value) {
            addCriterion("WX_ADMIN_TIMEOUT >", value, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("WX_ADMIN_TIMEOUT >=", value, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutLessThan(Integer value) {
            addCriterion("WX_ADMIN_TIMEOUT <", value, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutLessThanOrEqualTo(Integer value) {
            addCriterion("WX_ADMIN_TIMEOUT <=", value, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutIn(List<Integer> values) {
            addCriterion("WX_ADMIN_TIMEOUT in", values, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutNotIn(List<Integer> values) {
            addCriterion("WX_ADMIN_TIMEOUT not in", values, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutBetween(Integer value1, Integer value2) {
            addCriterion("WX_ADMIN_TIMEOUT between", value1, value2, "wxAdminTimeout");
            return (Criteria) this;
        }

        public Criteria andWxAdminTimeoutNotBetween(Integer value1, Integer value2) {
            addCriterion("WX_ADMIN_TIMEOUT not between", value1, value2, "wxAdminTimeout");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wx_admin
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
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