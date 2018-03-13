package com.jero.esc.po.pubinfo;

import java.util.Date;

public class CompanyDetails {
    private String id;

    private String companyName;

    private String companyProvince;

    private String companyCity;

    private String companyPerson;

    private String companyRegisterCapital;

    private Date companyRegisterDate;

    private String companyTel;

    private String companyAddress;

    private String companyEmail;

    private String companyNetAddress;

    private String companyType;

    private String companyBusinissScope;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyProvince() {
        return companyProvince;
    }

    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince == null ? null : companyProvince.trim();
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity == null ? null : companyCity.trim();
    }

    public String getCompanyPerson() {
        return companyPerson;
    }

    public void setCompanyPerson(String companyPerson) {
        this.companyPerson = companyPerson == null ? null : companyPerson.trim();
    }

    public String getCompanyRegisterCapital() {
        return companyRegisterCapital;
    }

    public void setCompanyRegisterCapital(String companyRegisterCapital) {
        this.companyRegisterCapital = companyRegisterCapital == null ? null : companyRegisterCapital.trim();
    }

    public Date getCompanyRegisterDate() {
        return companyRegisterDate;
    }

    public void setCompanyRegisterDate(Date companyRegisterDate) {
        this.companyRegisterDate = companyRegisterDate;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel == null ? null : companyTel.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail == null ? null : companyEmail.trim();
    }

    public String getCompanyNetAddress() {
        return companyNetAddress;
    }

    public void setCompanyNetAddress(String companyNetAddress) {
        this.companyNetAddress = companyNetAddress == null ? null : companyNetAddress.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getCompanyBusinissScope() {
        return companyBusinissScope;
    }

    public void setCompanyBusinissScope(String companyBusinissScope) {
        this.companyBusinissScope = companyBusinissScope == null ? null : companyBusinissScope.trim();
    }
}