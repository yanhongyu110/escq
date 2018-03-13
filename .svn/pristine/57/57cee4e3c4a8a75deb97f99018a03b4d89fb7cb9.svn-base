package com.jero.esc.po.checkinfo;

import com.jero.esc.common.utils.fastvalidate.FastValidateAnnotation;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;

import java.util.Date;

public class PersonCheckname {
    private String pcnId;

    @FastValidateAnnotation(name = "真实名",validateType = FastValidateType.CHINESE)
    private String pcnRelname;

    @FastValidateAnnotation(name = "身份证号",validateType = FastValidateType.PASSID)
    private String pcnIdnumber;

    @FastValidateAnnotation(name = "前面照片")
    private String pcnFrontid;

    @FastValidateAnnotation(name = "后面照片")
    private String pcnReverseid;

    @FastValidateAnnotation(name = "介绍")
    private String pcnIntroduce;

    @FastValidateAnnotation(name = "登陆账号外键")
    private String logId;

    private Date pcnCreatetime;

    @FastValidateAnnotation(name = "状态",validateType = FastValidateType.NUM)
    //状态   0:待审核     1:未通过       2:通过
    private Integer pcnState;

    private String pcnComment;

    public String getPcnId() {
        return pcnId;
    }

    public void setPcnId(String pcnId) {
        this.pcnId = pcnId == null ? null : pcnId.trim();
    }

    public String getPcnRelname() {
        return pcnRelname;
    }

    public void setPcnRelname(String pcnRelname) {
        this.pcnRelname = pcnRelname == null ? null : pcnRelname.trim();
    }

    public String getPcnIdnumber() {
        return pcnIdnumber;
    }

    public void setPcnIdnumber(String pcnIdnumber) {
        this.pcnIdnumber = pcnIdnumber == null ? null : pcnIdnumber.trim();
    }

    public String getPcnFrontid() {
        return pcnFrontid;
    }

    public void setPcnFrontid(String pcnFrontid) {
        this.pcnFrontid = pcnFrontid == null ? null : pcnFrontid.trim();
    }

    public String getPcnReverseid() {
        return pcnReverseid;
    }

    public void setPcnReverseid(String pcnReverseid) {
        this.pcnReverseid = pcnReverseid == null ? null : pcnReverseid.trim();
    }

    public String getPcnIntroduce() {
        return pcnIntroduce;
    }

    public void setPcnIntroduce(String pcnIntroduce) {
        this.pcnIntroduce = pcnIntroduce == null ? null : pcnIntroduce.trim();
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public Date getPcnCreatetime() {
        return pcnCreatetime;
    }

    public void setPcnCreatetime(Date pcnCreatetime) {
        this.pcnCreatetime = pcnCreatetime;
    }

    public Integer getPcnState() {
        return pcnState;
    }

    public void setPcnState(Integer pcnState) {
        this.pcnState = pcnState;
    }

    public String getPcnComment() {
        return pcnComment;
    }

    public void setPcnComment(String pcnComment) {
        this.pcnComment = pcnComment == null ? null : pcnComment.trim();
    }
}