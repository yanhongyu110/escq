package com.jero.esc.po.map;

import java.util.ArrayList;
import java.util.List;

public class PointExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table point
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table point
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table point
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
     *
     * @mbggenerated
     */
    public PointExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
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
     * This method corresponds to the database table point
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
     * This method corresponds to the database table point
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table point
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
     * This class corresponds to the database table point
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

        public Criteria andPointIdIsNull() {
            addCriterion("POINT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNotNull() {
            addCriterion("POINT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPointIdEqualTo(String value) {
            addCriterion("POINT_ID =", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotEqualTo(String value) {
            addCriterion("POINT_ID <>", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThan(String value) {
            addCriterion("POINT_ID >", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThanOrEqualTo(String value) {
            addCriterion("POINT_ID >=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThan(String value) {
            addCriterion("POINT_ID <", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThanOrEqualTo(String value) {
            addCriterion("POINT_ID <=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLike(String value) {
            addCriterion("POINT_ID like", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotLike(String value) {
            addCriterion("POINT_ID not like", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdIn(List<String> values) {
            addCriterion("POINT_ID in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotIn(List<String> values) {
            addCriterion("POINT_ID not in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdBetween(String value1, String value2) {
            addCriterion("POINT_ID between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotBetween(String value1, String value2) {
            addCriterion("POINT_ID not between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdIsNull() {
            addCriterion("POINT_LBS_ID is null");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdIsNotNull() {
            addCriterion("POINT_LBS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdEqualTo(String value) {
            addCriterion("POINT_LBS_ID =", value, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdNotEqualTo(String value) {
            addCriterion("POINT_LBS_ID <>", value, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdGreaterThan(String value) {
            addCriterion("POINT_LBS_ID >", value, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdGreaterThanOrEqualTo(String value) {
            addCriterion("POINT_LBS_ID >=", value, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdLessThan(String value) {
            addCriterion("POINT_LBS_ID <", value, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdLessThanOrEqualTo(String value) {
            addCriterion("POINT_LBS_ID <=", value, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdLike(String value) {
            addCriterion("POINT_LBS_ID like", value, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdNotLike(String value) {
            addCriterion("POINT_LBS_ID not like", value, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdIn(List<String> values) {
            addCriterion("POINT_LBS_ID in", values, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdNotIn(List<String> values) {
            addCriterion("POINT_LBS_ID not in", values, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdBetween(String value1, String value2) {
            addCriterion("POINT_LBS_ID between", value1, value2, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointLbsIdNotBetween(String value1, String value2) {
            addCriterion("POINT_LBS_ID not between", value1, value2, "pointLbsId");
            return (Criteria) this;
        }

        public Criteria andPointProviderIsNull() {
            addCriterion("POINT_PROVIDER is null");
            return (Criteria) this;
        }

        public Criteria andPointProviderIsNotNull() {
            addCriterion("POINT_PROVIDER is not null");
            return (Criteria) this;
        }

        public Criteria andPointProviderEqualTo(String value) {
            addCriterion("POINT_PROVIDER =", value, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderNotEqualTo(String value) {
            addCriterion("POINT_PROVIDER <>", value, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderGreaterThan(String value) {
            addCriterion("POINT_PROVIDER >", value, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderGreaterThanOrEqualTo(String value) {
            addCriterion("POINT_PROVIDER >=", value, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderLessThan(String value) {
            addCriterion("POINT_PROVIDER <", value, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderLessThanOrEqualTo(String value) {
            addCriterion("POINT_PROVIDER <=", value, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderLike(String value) {
            addCriterion("POINT_PROVIDER like", value, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderNotLike(String value) {
            addCriterion("POINT_PROVIDER not like", value, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderIn(List<String> values) {
            addCriterion("POINT_PROVIDER in", values, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderNotIn(List<String> values) {
            addCriterion("POINT_PROVIDER not in", values, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderBetween(String value1, String value2) {
            addCriterion("POINT_PROVIDER between", value1, value2, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointProviderNotBetween(String value1, String value2) {
            addCriterion("POINT_PROVIDER not between", value1, value2, "pointProvider");
            return (Criteria) this;
        }

        public Criteria andPointLatIsNull() {
            addCriterion("POINT_LAT is null");
            return (Criteria) this;
        }

        public Criteria andPointLatIsNotNull() {
            addCriterion("POINT_LAT is not null");
            return (Criteria) this;
        }

        public Criteria andPointLatEqualTo(Float value) {
            addCriterion("POINT_LAT =", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatNotEqualTo(Float value) {
            addCriterion("POINT_LAT <>", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatGreaterThan(Float value) {
            addCriterion("POINT_LAT >", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatGreaterThanOrEqualTo(Float value) {
            addCriterion("POINT_LAT >=", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatLessThan(Float value) {
            addCriterion("POINT_LAT <", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatLessThanOrEqualTo(Float value) {
            addCriterion("POINT_LAT <=", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatIn(List<Float> values) {
            addCriterion("POINT_LAT in", values, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatNotIn(List<Float> values) {
            addCriterion("POINT_LAT not in", values, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatBetween(Float value1, Float value2) {
            addCriterion("POINT_LAT between", value1, value2, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatNotBetween(Float value1, Float value2) {
            addCriterion("POINT_LAT not between", value1, value2, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLngIsNull() {
            addCriterion("POINT_LNG is null");
            return (Criteria) this;
        }

        public Criteria andPointLngIsNotNull() {
            addCriterion("POINT_LNG is not null");
            return (Criteria) this;
        }

        public Criteria andPointLngEqualTo(Float value) {
            addCriterion("POINT_LNG =", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngNotEqualTo(Float value) {
            addCriterion("POINT_LNG <>", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngGreaterThan(Float value) {
            addCriterion("POINT_LNG >", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngGreaterThanOrEqualTo(Float value) {
            addCriterion("POINT_LNG >=", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngLessThan(Float value) {
            addCriterion("POINT_LNG <", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngLessThanOrEqualTo(Float value) {
            addCriterion("POINT_LNG <=", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngIn(List<Float> values) {
            addCriterion("POINT_LNG in", values, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngNotIn(List<Float> values) {
            addCriterion("POINT_LNG not in", values, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngBetween(Float value1, Float value2) {
            addCriterion("POINT_LNG between", value1, value2, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngNotBetween(Float value1, Float value2) {
            addCriterion("POINT_LNG not between", value1, value2, "pointLng");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table point
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
     * This class corresponds to the database table point
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