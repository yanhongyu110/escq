package com.jero.esc.vo.userinfo;

import java.util.Date;

public class AccountVo {
	//账户信息表
	private String accId;

    private String accLogId;

    private Float accBalance;

    private Float accPoint;

    private Float accBlockbalance;

    private String accPaypass;

    private String accDefaultcard;

    private String accComment;
    
    //登陆账号信息表
    private String logId;

    private String logCell;

    private String logEmail;

    private String logName;

    private String logPass;

    private Date logCreatetime;

    private Boolean logIsdelete;

    private Integer logState;

    private Integer logType;

    private String logRegip;

    private Boolean logIslog;

    private String logComment;
    
    //账号收支明细表
    private String apdId;
    
    private String apdLogId;

    private Integer apdIotype;

    private Integer apdPaytype;

    private Date apdCreatetime;

    private Float apdAmount;

    private Integer apdDealtype;

    private String apdAdminorderno;

    private String apdDealno;

    private String apdComment;
    
    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId == null ? null : accId.trim();
    }

    public String getAccLogId() {
        return accLogId;
    }

    public void setAccLogId(String accLogId) {
        this.accLogId = accLogId == null ? null : accLogId.trim();
    }

    public Float getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(Float accBalance) {
        this.accBalance = accBalance;
    }

    public Float getAccPoint() {
        return accPoint;
    }

    public void setAccPoint(Float accPoint) {
        this.accPoint = accPoint;
    }

    public Float getAccBlockbalance() {
        return accBlockbalance;
    }

    public void setAccBlockbalance(Float accBlockbalance) {
        this.accBlockbalance = accBlockbalance;
    }

    public String getAccPaypass() {
        return accPaypass;
    }

    public void setAccPaypass(String accPaypass) {
        this.accPaypass = accPaypass == null ? null : accPaypass.trim();
    }

    public String getAccDefaultcard() {
        return accDefaultcard;
    }

    public void setAccDefaultcard(String accDefaultcard) {
        this.accDefaultcard = accDefaultcard == null ? null : accDefaultcard.trim();
    }

    public String getAccComment() {
        return accComment;
    }

    public void setAccComment(String accComment) {
        this.accComment = accComment == null ? null : accComment.trim();
    }
    
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getLogCell() {
        return logCell;
    }

    public void setLogCell(String logCell) {
        this.logCell = logCell == null ? null : logCell.trim();
    }

    public String getLogEmail() {
        return logEmail;
    }

    public void setLogEmail(String logEmail) {
        this.logEmail = logEmail == null ? null : logEmail.trim();
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }

    public String getLogPass() {
        return logPass;
    }

    public void setLogPass(String logPass) {
        this.logPass = logPass == null ? null : logPass.trim();
    }

    public Date getLogCreatetime() {
        return logCreatetime;
    }

    public void setLogCreatetime(Date logCreatetime) {
        this.logCreatetime = logCreatetime;
    }

    public Boolean getLogIsdelete() {
        return logIsdelete;
    }

    public void setLogIsdelete(Boolean logIsdelete) {
        this.logIsdelete = logIsdelete;
    }

    public Integer getLogState() {
        return logState;
    }

    public void setLogState(Integer logState) {
        this.logState = logState;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getLogRegip() {
        return logRegip;
    }

    public void setLogRegip(String logRegip) {
        this.logRegip = logRegip == null ? null : logRegip.trim();
    }

    public Boolean getLogIslog() {
        return logIslog;
    }

    public void setLogIslog(Boolean logIslog) {
        this.logIslog = logIslog;
    }

    public String getLogComment() {
        return logComment;
    }

    public void setLogComment(String logComment) {
        this.logComment = logComment == null ? null : logComment.trim();
    }
    
    public String getApdId() {
        return apdId;
    }

    public void setApdId(String apdId) {
        this.apdId = apdId == null ? null : apdId.trim();
    }

    public String getApdLogId() {
        return apdLogId;
    }

    public void setApdLogId(String apdLogId) {
        this.apdLogId = apdLogId == null ? null : apdLogId.trim();
    }

    public Integer getApdIotype() {
        return apdIotype;
    }

    public void setApdIotype(Integer apdIotype) {
        this.apdIotype = apdIotype;
    }

    public Integer getApdPaytype() {
        return apdPaytype;
    }

    public void setApdPaytype(Integer apdPaytype) {
        this.apdPaytype = apdPaytype;
    }

    public Date getApdCreatetime() {
        return apdCreatetime;
    }

    public void setApdCreatetime(Date apdCreatetime) {
        this.apdCreatetime = apdCreatetime;
    }

    public Float getApdAmount() {
        return apdAmount;
    }

    public void setApdAmount(Float apdAmount) {
        this.apdAmount = apdAmount;
    }

    public Integer getApdDealtype() {
        return apdDealtype;
    }

    public void setApdDealtype(Integer apdDealtype) {
        this.apdDealtype = apdDealtype;
    }

    public String getApdAdminorderno() {
        return apdAdminorderno;
    }

    public void setApdAdminorderno(String apdAdminorderno) {
        this.apdAdminorderno = apdAdminorderno == null ? null : apdAdminorderno.trim();
    }

    public String getApdDealno() {
        return apdDealno;
    }

    public void setApdDealno(String apdDealno) {
        this.apdDealno = apdDealno == null ? null : apdDealno.trim();
    }

    public String getApdComment() {
        return apdComment;
    }

    public void setApdComment(String apdComment) {
        this.apdComment = apdComment == null ? null : apdComment.trim();
    }
}
