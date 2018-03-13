package com.jero.esc.po.pubinfo;

import java.util.List;

public class CommonType {

    private List<CommonType> children;

    private  CommonType commonType;

    private String ctId;

    private Integer ctType;

    private String ctName;

    private String ctFid;

    private Boolean ctIsleaf;

    private Integer ctSort;

    private String ctComment;

    private String company;

    private String ctTemplate;

    public String getCtId() {
        return ctId;
    }

    public void setCtId(String ctId) {
        this.ctId = ctId == null ? null : ctId.trim();
    }

    public Integer getCtType() {
        return ctType;
    }

    public void setCtType(Integer ctType) {
        this.ctType = ctType;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName == null ? null : ctName.trim();
    }

    public String getCtFid() {
        return ctFid;
    }

    public void setCtFid(String ctFid) {
        this.ctFid = ctFid == null ? null : ctFid.trim();
    }

    public Boolean getCtIsleaf() {
        return ctIsleaf;
    }

    public void setCtIsleaf(Boolean ctIsleaf) {
        this.ctIsleaf = ctIsleaf;
    }

    public Integer getCtSort() {
        return ctSort;
    }

    public void setCtSort(Integer ctSort) {
        this.ctSort = ctSort;
    }

    public String getCtComment() {
        return ctComment;
    }

    public void setCtComment(String ctComment) {
        this.ctComment = ctComment == null ? null : ctComment.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCtTemplate() {
        return ctTemplate;
    }

    public void setCtTemplate(String ctTemplate) {
        this.ctTemplate = ctTemplate == null ? null : ctTemplate.trim();
    }

    public List<CommonType> getChildren() {
        return children;
    }

    public void setChildren(List<CommonType> children) {
        this.children = children;
    }

    public CommonType getCommonType() {
        return commonType;
    }

    public void setCommonType(CommonType commonType) {
        this.commonType = commonType;
    }
}