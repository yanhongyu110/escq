package com.jero.esc.po.pubinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CompanyDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyDetailsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("COMPANY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("COMPANY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("COMPANY_NAME =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("COMPANY_NAME <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("COMPANY_NAME >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("COMPANY_NAME <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NAME <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("COMPANY_NAME like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("COMPANY_NAME not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("COMPANY_NAME in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("COMPANY_NAME not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NAME not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceIsNull() {
            addCriterion("COMPANY_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceIsNotNull() {
            addCriterion("COMPANY_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceEqualTo(String value) {
            addCriterion("COMPANY_PROVINCE =", value, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceNotEqualTo(String value) {
            addCriterion("COMPANY_PROVINCE <>", value, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceGreaterThan(String value) {
            addCriterion("COMPANY_PROVINCE >", value, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_PROVINCE >=", value, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceLessThan(String value) {
            addCriterion("COMPANY_PROVINCE <", value, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_PROVINCE <=", value, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceLike(String value) {
            addCriterion("COMPANY_PROVINCE like", value, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceNotLike(String value) {
            addCriterion("COMPANY_PROVINCE not like", value, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceIn(List<String> values) {
            addCriterion("COMPANY_PROVINCE in", values, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceNotIn(List<String> values) {
            addCriterion("COMPANY_PROVINCE not in", values, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceBetween(String value1, String value2) {
            addCriterion("COMPANY_PROVINCE between", value1, value2, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyProvinceNotBetween(String value1, String value2) {
            addCriterion("COMPANY_PROVINCE not between", value1, value2, "companyProvince");
            return (Criteria) this;
        }

        public Criteria andCompanyCityIsNull() {
            addCriterion("COMPANY_CITY is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCityIsNotNull() {
            addCriterion("COMPANY_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCityEqualTo(String value) {
            addCriterion("COMPANY_CITY =", value, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityNotEqualTo(String value) {
            addCriterion("COMPANY_CITY <>", value, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityGreaterThan(String value) {
            addCriterion("COMPANY_CITY >", value, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_CITY >=", value, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityLessThan(String value) {
            addCriterion("COMPANY_CITY <", value, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_CITY <=", value, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityLike(String value) {
            addCriterion("COMPANY_CITY like", value, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityNotLike(String value) {
            addCriterion("COMPANY_CITY not like", value, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityIn(List<String> values) {
            addCriterion("COMPANY_CITY in", values, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityNotIn(List<String> values) {
            addCriterion("COMPANY_CITY not in", values, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityBetween(String value1, String value2) {
            addCriterion("COMPANY_CITY between", value1, value2, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyCityNotBetween(String value1, String value2) {
            addCriterion("COMPANY_CITY not between", value1, value2, "companyCity");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonIsNull() {
            addCriterion("COMPANY_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonIsNotNull() {
            addCriterion("COMPANY_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonEqualTo(String value) {
            addCriterion("COMPANY_PERSON =", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonNotEqualTo(String value) {
            addCriterion("COMPANY_PERSON <>", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonGreaterThan(String value) {
            addCriterion("COMPANY_PERSON >", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_PERSON >=", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonLessThan(String value) {
            addCriterion("COMPANY_PERSON <", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_PERSON <=", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonLike(String value) {
            addCriterion("COMPANY_PERSON like", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonNotLike(String value) {
            addCriterion("COMPANY_PERSON not like", value, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonIn(List<String> values) {
            addCriterion("COMPANY_PERSON in", values, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonNotIn(List<String> values) {
            addCriterion("COMPANY_PERSON not in", values, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonBetween(String value1, String value2) {
            addCriterion("COMPANY_PERSON between", value1, value2, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyPersonNotBetween(String value1, String value2) {
            addCriterion("COMPANY_PERSON not between", value1, value2, "companyPerson");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalIsNull() {
            addCriterion("COMPANY_REGISTER_CAPITAL is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalIsNotNull() {
            addCriterion("COMPANY_REGISTER_CAPITAL is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalEqualTo(String value) {
            addCriterion("COMPANY_REGISTER_CAPITAL =", value, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalNotEqualTo(String value) {
            addCriterion("COMPANY_REGISTER_CAPITAL <>", value, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalGreaterThan(String value) {
            addCriterion("COMPANY_REGISTER_CAPITAL >", value, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_REGISTER_CAPITAL >=", value, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalLessThan(String value) {
            addCriterion("COMPANY_REGISTER_CAPITAL <", value, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_REGISTER_CAPITAL <=", value, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalLike(String value) {
            addCriterion("COMPANY_REGISTER_CAPITAL like", value, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalNotLike(String value) {
            addCriterion("COMPANY_REGISTER_CAPITAL not like", value, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalIn(List<String> values) {
            addCriterion("COMPANY_REGISTER_CAPITAL in", values, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalNotIn(List<String> values) {
            addCriterion("COMPANY_REGISTER_CAPITAL not in", values, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalBetween(String value1, String value2) {
            addCriterion("COMPANY_REGISTER_CAPITAL between", value1, value2, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterCapitalNotBetween(String value1, String value2) {
            addCriterion("COMPANY_REGISTER_CAPITAL not between", value1, value2, "companyRegisterCapital");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateIsNull() {
            addCriterion("COMPANY_REGISTER_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateIsNotNull() {
            addCriterion("COMPANY_REGISTER_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateEqualTo(Date value) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE =", value, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE <>", value, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateGreaterThan(Date value) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE >", value, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE >=", value, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateLessThan(Date value) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE <", value, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE <=", value, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateIn(List<Date> values) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE in", values, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE not in", values, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE between", value1, value2, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyRegisterDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("COMPANY_REGISTER_DATE not between", value1, value2, "companyRegisterDate");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIsNull() {
            addCriterion("COMPANY_TEL is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIsNotNull() {
            addCriterion("COMPANY_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEqualTo(String value) {
            addCriterion("COMPANY_TEL =", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotEqualTo(String value) {
            addCriterion("COMPANY_TEL <>", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelGreaterThan(String value) {
            addCriterion("COMPANY_TEL >", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_TEL >=", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLessThan(String value) {
            addCriterion("COMPANY_TEL <", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_TEL <=", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLike(String value) {
            addCriterion("COMPANY_TEL like", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotLike(String value) {
            addCriterion("COMPANY_TEL not like", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIn(List<String> values) {
            addCriterion("COMPANY_TEL in", values, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotIn(List<String> values) {
            addCriterion("COMPANY_TEL not in", values, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelBetween(String value1, String value2) {
            addCriterion("COMPANY_TEL between", value1, value2, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotBetween(String value1, String value2) {
            addCriterion("COMPANY_TEL not between", value1, value2, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("COMPANY_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("COMPANY_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("COMPANY_ADDRESS =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("COMPANY_ADDRESS <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("COMPANY_ADDRESS >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_ADDRESS >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("COMPANY_ADDRESS <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_ADDRESS <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("COMPANY_ADDRESS like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("COMPANY_ADDRESS not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("COMPANY_ADDRESS in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("COMPANY_ADDRESS not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("COMPANY_ADDRESS between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("COMPANY_ADDRESS not between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailIsNull() {
            addCriterion("COMPANY_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailIsNotNull() {
            addCriterion("COMPANY_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailEqualTo(String value) {
            addCriterion("COMPANY_EMAIL =", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailNotEqualTo(String value) {
            addCriterion("COMPANY_EMAIL <>", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailGreaterThan(String value) {
            addCriterion("COMPANY_EMAIL >", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_EMAIL >=", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailLessThan(String value) {
            addCriterion("COMPANY_EMAIL <", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_EMAIL <=", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailLike(String value) {
            addCriterion("COMPANY_EMAIL like", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailNotLike(String value) {
            addCriterion("COMPANY_EMAIL not like", value, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailIn(List<String> values) {
            addCriterion("COMPANY_EMAIL in", values, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailNotIn(List<String> values) {
            addCriterion("COMPANY_EMAIL not in", values, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailBetween(String value1, String value2) {
            addCriterion("COMPANY_EMAIL between", value1, value2, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyEmailNotBetween(String value1, String value2) {
            addCriterion("COMPANY_EMAIL not between", value1, value2, "companyEmail");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressIsNull() {
            addCriterion("COMPANY_NET_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressIsNotNull() {
            addCriterion("COMPANY_NET_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressEqualTo(String value) {
            addCriterion("COMPANY_NET_ADDRESS =", value, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressNotEqualTo(String value) {
            addCriterion("COMPANY_NET_ADDRESS <>", value, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressGreaterThan(String value) {
            addCriterion("COMPANY_NET_ADDRESS >", value, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_NET_ADDRESS >=", value, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressLessThan(String value) {
            addCriterion("COMPANY_NET_ADDRESS <", value, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_NET_ADDRESS <=", value, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressLike(String value) {
            addCriterion("COMPANY_NET_ADDRESS like", value, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressNotLike(String value) {
            addCriterion("COMPANY_NET_ADDRESS not like", value, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressIn(List<String> values) {
            addCriterion("COMPANY_NET_ADDRESS in", values, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressNotIn(List<String> values) {
            addCriterion("COMPANY_NET_ADDRESS not in", values, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressBetween(String value1, String value2) {
            addCriterion("COMPANY_NET_ADDRESS between", value1, value2, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyNetAddressNotBetween(String value1, String value2) {
            addCriterion("COMPANY_NET_ADDRESS not between", value1, value2, "companyNetAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNull() {
            addCriterion("COMPANY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIsNotNull() {
            addCriterion("COMPANY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeEqualTo(String value) {
            addCriterion("COMPANY_TYPE =", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotEqualTo(String value) {
            addCriterion("COMPANY_TYPE <>", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThan(String value) {
            addCriterion("COMPANY_TYPE >", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_TYPE >=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThan(String value) {
            addCriterion("COMPANY_TYPE <", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_TYPE <=", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeLike(String value) {
            addCriterion("COMPANY_TYPE like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotLike(String value) {
            addCriterion("COMPANY_TYPE not like", value, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeIn(List<String> values) {
            addCriterion("COMPANY_TYPE in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotIn(List<String> values) {
            addCriterion("COMPANY_TYPE not in", values, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeBetween(String value1, String value2) {
            addCriterion("COMPANY_TYPE between", value1, value2, "companyType");
            return (Criteria) this;
        }

        public Criteria andCompanyTypeNotBetween(String value1, String value2) {
            addCriterion("COMPANY_TYPE not between", value1, value2, "companyType");
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