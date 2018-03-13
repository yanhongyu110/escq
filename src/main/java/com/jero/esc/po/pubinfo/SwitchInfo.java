package com.jero.esc.po.pubinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class SwitchInfo {
    private String switchId;

    private String switchName;

    private Integer switchPos;

    private String switchImg;

    private Date switchCreatetime;

    private String adminId;

    private String switchComment;

    public String getSwitchId() {
        return switchId;
    }

    public void setSwitchId(String switchId) {
        this.switchId = switchId == null ? null : switchId.trim();
    }

    public String getSwitchName() {
        return switchName;
    }

    public void setSwitchName(String switchName) {
        this.switchName = switchName == null ? null : switchName.trim();
    }

    public Integer getSwitchPos() {
        return switchPos;
    }

    public void setSwitchPos(Integer switchPos) {
        this.switchPos = switchPos;
    }

    public String getSwitchImg() {
        return switchImg;
    }

    public void setSwitchImg(String switchImg) {
        this.switchImg = switchImg == null ? null : switchImg.trim();
    }

    public Date getSwitchCreatetime() {
        return switchCreatetime;
    }

    public void setSwitchCreatetime(Date switchCreatetime) {
        this.switchCreatetime = switchCreatetime;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getSwitchComment() {
        return switchComment;
    }

    public void setSwitchComment(String switchComment) {
        this.switchComment = switchComment == null ? null : switchComment.trim();
    }
    private  String company;
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    //  特殊的获取  对象图片数组方式
    private List<JSONObject> switchImgObjArr;
    public void setSwitchImgObjArr(List<JSONObject> switchImgObjArr) {
        this.switchImgObjArr = switchImgObjArr;
    }
    public List<JSONObject> getSwitchImgObjArr(){
        List<Object> objects = JSON.parseArray(switchImg);
        List<JSONObject> jsonobjects = new ArrayList<JSONObject>();
        for (Object object : objects) {
        	jsonobjects.add((JSONObject)object);
		}
        return jsonobjects;
    }



}