package com.jero.esc.vo.pay;


import java.util.Date;

public class AccountDrawVo {
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

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getAccLogId() {
		return accLogId;
	}

	public void setAccLogId(String accLogId) {
		this.accLogId = accLogId;
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
		this.accPaypass = accPaypass;
	}

	public String getAccDefaultcard() {
		return accDefaultcard;
	}

	public void setAccDefaultcard(String accDefaultcard) {
		this.accDefaultcard = accDefaultcard;
	}

	public String getAccComment() {
		return accComment;
	}

	public void setAccComment(String accComment) {
		this.accComment = accComment;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogCell() {
		return logCell;
	}

	public void setLogCell(String logCell) {
		this.logCell = logCell;
	}

	public String getLogEmail() {
		return logEmail;
	}

	public void setLogEmail(String logEmail) {
		this.logEmail = logEmail;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getLogPass() {
		return logPass;
	}

	public void setLogPass(String logPass) {
		this.logPass = logPass;
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
		this.logRegip = logRegip;
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
		this.logComment = logComment;
	}
    
}
