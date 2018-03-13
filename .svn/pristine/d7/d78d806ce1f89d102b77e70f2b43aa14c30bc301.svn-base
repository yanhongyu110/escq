package com.jero.esc.po.pubinfo;

import java.util.ArrayList;
import java.util.List;

public class CommonTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommonTypeExample() {
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

        public Criteria andCtIdIsNull() {
            addCriterion("CT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCtIdIsNotNull() {
            addCriterion("CT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCtIdEqualTo(String value) {
            addCriterion("CT_ID =", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotEqualTo(String value) {
            addCriterion("CT_ID <>", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdGreaterThan(String value) {
            addCriterion("CT_ID >", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdGreaterThanOrEqualTo(String value) {
            addCriterion("CT_ID >=", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLessThan(String value) {
            addCriterion("CT_ID <", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLessThanOrEqualTo(String value) {
            addCriterion("CT_ID <=", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdLike(String value) {
            addCriterion("CT_ID like", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotLike(String value) {
            addCriterion("CT_ID not like", value, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdIn(List<String> values) {
            addCriterion("CT_ID in", values, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotIn(List<String> values) {
            addCriterion("CT_ID not in", values, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdBetween(String value1, String value2) {
            addCriterion("CT_ID between", value1, value2, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtIdNotBetween(String value1, String value2) {
            addCriterion("CT_ID not between", value1, value2, "ctId");
            return (Criteria) this;
        }

        public Criteria andCtTypeIsNull() {
            addCriterion("CT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCtTypeIsNotNull() {
            addCriterion("CT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCtTypeEqualTo(Integer value) {
            addCriterion("CT_TYPE =", value, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeNotEqualTo(Integer value) {
            addCriterion("CT_TYPE <>", value, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeGreaterThan(Integer value) {
            addCriterion("CT_TYPE >", value, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CT_TYPE >=", value, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeLessThan(Integer value) {
            addCriterion("CT_TYPE <", value, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeLessThanOrEqualTo(Integer value) {
            addCriterion("CT_TYPE <=", value, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeIn(List<Integer> values) {
            addCriterion("CT_TYPE in", values, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeNotIn(List<Integer> values) {
            addCriterion("CT_TYPE not in", values, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeBetween(Integer value1, Integer value2) {
            addCriterion("CT_TYPE between", value1, value2, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("CT_TYPE not between", value1, value2, "ctType");
            return (Criteria) this;
        }

        public Criteria andCtNameIsNull() {
            addCriterion("CT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCtNameIsNotNull() {
            addCriterion("CT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCtNameEqualTo(String value) {
            addCriterion("CT_NAME =", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameNotEqualTo(String value) {
            addCriterion("CT_NAME <>", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameGreaterThan(String value) {
            addCriterion("CT_NAME >", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameGreaterThanOrEqualTo(String value) {
            addCriterion("CT_NAME >=", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameLessThan(String value) {
            addCriterion("CT_NAME <", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameLessThanOrEqualTo(String value) {
            addCriterion("CT_NAME <=", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameLike(String value) {
            addCriterion("CT_NAME like", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameNotLike(String value) {
            addCriterion("CT_NAME not like", value, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameIn(List<String> values) {
            addCriterion("CT_NAME in", values, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameNotIn(List<String> values) {
            addCriterion("CT_NAME not in", values, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameBetween(String value1, String value2) {
            addCriterion("CT_NAME between", value1, value2, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtNameNotBetween(String value1, String value2) {
            addCriterion("CT_NAME not between", value1, value2, "ctName");
            return (Criteria) this;
        }

        public Criteria andCtFidIsNull() {
            addCriterion("CT_FID is null");
            return (Criteria) this;
        }

        public Criteria andCtFidIsNotNull() {
            addCriterion("CT_FID is not null");
            return (Criteria) this;
        }

        public Criteria andCtFidEqualTo(String value) {
            addCriterion("CT_FID =", value, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidNotEqualTo(String value) {
            addCriterion("CT_FID <>", value, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidGreaterThan(String value) {
            addCriterion("CT_FID >", value, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidGreaterThanOrEqualTo(String value) {
            addCriterion("CT_FID >=", value, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidLessThan(String value) {
            addCriterion("CT_FID <", value, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidLessThanOrEqualTo(String value) {
            addCriterion("CT_FID <=", value, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidLike(String value) {
            addCriterion("CT_FID like", value, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidNotLike(String value) {
            addCriterion("CT_FID not like", value, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidIn(List<String> values) {
            addCriterion("CT_FID in", values, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidNotIn(List<String> values) {
            addCriterion("CT_FID not in", values, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidBetween(String value1, String value2) {
            addCriterion("CT_FID between", value1, value2, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtFidNotBetween(String value1, String value2) {
            addCriterion("CT_FID not between", value1, value2, "ctFid");
            return (Criteria) this;
        }

        public Criteria andCtIsleafIsNull() {
            addCriterion("CT_ISLEAF is null");
            return (Criteria) this;
        }

        public Criteria andCtIsleafIsNotNull() {
            addCriterion("CT_ISLEAF is not null");
            return (Criteria) this;
        }

        public Criteria andCtIsleafEqualTo(Boolean value) {
            addCriterion("CT_ISLEAF =", value, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafNotEqualTo(Boolean value) {
            addCriterion("CT_ISLEAF <>", value, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafGreaterThan(Boolean value) {
            addCriterion("CT_ISLEAF >", value, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafGreaterThanOrEqualTo(Boolean value) {
            addCriterion("CT_ISLEAF >=", value, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafLessThan(Boolean value) {
            addCriterion("CT_ISLEAF <", value, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafLessThanOrEqualTo(Boolean value) {
            addCriterion("CT_ISLEAF <=", value, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafIn(List<Boolean> values) {
            addCriterion("CT_ISLEAF in", values, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafNotIn(List<Boolean> values) {
            addCriterion("CT_ISLEAF not in", values, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafBetween(Boolean value1, Boolean value2) {
            addCriterion("CT_ISLEAF between", value1, value2, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtIsleafNotBetween(Boolean value1, Boolean value2) {
            addCriterion("CT_ISLEAF not between", value1, value2, "ctIsleaf");
            return (Criteria) this;
        }

        public Criteria andCtSortIsNull() {
            addCriterion("CT_SORT is null");
            return (Criteria) this;
        }

        public Criteria andCtSortIsNotNull() {
            addCriterion("CT_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andCtSortEqualTo(Integer value) {
            addCriterion("CT_SORT =", value, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortNotEqualTo(Integer value) {
            addCriterion("CT_SORT <>", value, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortGreaterThan(Integer value) {
            addCriterion("CT_SORT >", value, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("CT_SORT >=", value, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortLessThan(Integer value) {
            addCriterion("CT_SORT <", value, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortLessThanOrEqualTo(Integer value) {
            addCriterion("CT_SORT <=", value, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortIn(List<Integer> values) {
            addCriterion("CT_SORT in", values, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortNotIn(List<Integer> values) {
            addCriterion("CT_SORT not in", values, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortBetween(Integer value1, Integer value2) {
            addCriterion("CT_SORT between", value1, value2, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtSortNotBetween(Integer value1, Integer value2) {
            addCriterion("CT_SORT not between", value1, value2, "ctSort");
            return (Criteria) this;
        }

        public Criteria andCtCommentIsNull() {
            addCriterion("CT_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andCtCommentIsNotNull() {
            addCriterion("CT_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andCtCommentEqualTo(String value) {
            addCriterion("CT_COMMENT =", value, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentNotEqualTo(String value) {
            addCriterion("CT_COMMENT <>", value, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentGreaterThan(String value) {
            addCriterion("CT_COMMENT >", value, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentGreaterThanOrEqualTo(String value) {
            addCriterion("CT_COMMENT >=", value, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentLessThan(String value) {
            addCriterion("CT_COMMENT <", value, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentLessThanOrEqualTo(String value) {
            addCriterion("CT_COMMENT <=", value, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentLike(String value) {
            addCriterion("CT_COMMENT like", value, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentNotLike(String value) {
            addCriterion("CT_COMMENT not like", value, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentIn(List<String> values) {
            addCriterion("CT_COMMENT in", values, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentNotIn(List<String> values) {
            addCriterion("CT_COMMENT not in", values, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentBetween(String value1, String value2) {
            addCriterion("CT_COMMENT between", value1, value2, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCtCommentNotBetween(String value1, String value2) {
            addCriterion("CT_COMMENT not between", value1, value2, "ctComment");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("COMPANY is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("COMPANY is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("COMPANY =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("COMPANY <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("COMPANY >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("COMPANY <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("COMPANY <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("COMPANY like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("COMPANY not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("COMPANY in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("COMPANY not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("COMPANY between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("COMPANY not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCtTemplateIsNull() {
            addCriterion("CT_TEMPLATE is null");
            return (Criteria) this;
        }

        public Criteria andCtTemplateIsNotNull() {
            addCriterion("CT_TEMPLATE is not null");
            return (Criteria) this;
        }

        public Criteria andCtTemplateEqualTo(String value) {
            addCriterion("CT_TEMPLATE =", value, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateNotEqualTo(String value) {
            addCriterion("CT_TEMPLATE <>", value, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateGreaterThan(String value) {
            addCriterion("CT_TEMPLATE >", value, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("CT_TEMPLATE >=", value, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateLessThan(String value) {
            addCriterion("CT_TEMPLATE <", value, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateLessThanOrEqualTo(String value) {
            addCriterion("CT_TEMPLATE <=", value, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateLike(String value) {
            addCriterion("CT_TEMPLATE like", value, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateNotLike(String value) {
            addCriterion("CT_TEMPLATE not like", value, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateIn(List<String> values) {
            addCriterion("CT_TEMPLATE in", values, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateNotIn(List<String> values) {
            addCriterion("CT_TEMPLATE not in", values, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateBetween(String value1, String value2) {
            addCriterion("CT_TEMPLATE between", value1, value2, "ctTemplate");
            return (Criteria) this;
        }

        public Criteria andCtTemplateNotBetween(String value1, String value2) {
            addCriterion("CT_TEMPLATE not between", value1, value2, "ctTemplate");
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