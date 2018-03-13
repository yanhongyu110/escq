package com.jero.esc.po.system;

public class SysResource {
    private Integer resourceId;

    private String resourceName;

    private String resourceUrl;

    private String resourceOperation;

    private String resourceRemark;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getResourceOperation() {
        return resourceOperation;
    }

    public void setResourceOperation(String resourceOperation) {
        this.resourceOperation = resourceOperation == null ? null : resourceOperation.trim();
    }

    public String getResourceRemark() {
        return resourceRemark;
    }

    public void setResourceRemark(String resourceRemark) {
        this.resourceRemark = resourceRemark == null ? null : resourceRemark.trim();
    }
}