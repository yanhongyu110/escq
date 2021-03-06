package com.jero.esc.vo.userinfo;

import java.util.Date;

import com.jero.esc.common.utils.DateUtil;

/**
 * @copyright 上善云图信息技术有限公司
 * @author gb
 * @version v1.0
 * @date 2016年12月28日
 * @description
 */
public class SystemMesVo {
	// 系统消息表
	private String smId;

	private String smTitle; 

	private String smContent;

	private Date smCreatetime;

	private String adminId;

	private Integer smType;

	private Boolean smIsdelete;

	private String smComment;
	// 消息详情表
	private String mdId;

	private String mdsmId;

	private String logId;

	private Date mdCreatetime;

	private Boolean mdIsdelete;

	private String mdComment;

	private  String company;

    /** 操作者Id */
    private String operatorId;
    
    private int operatorType;
    
    private int mdType;
    
    
	/**  
	 * 获取 mdType  
	 * @return mdType mdType  
	 */
	public int getMdType() {
		return mdType;
	}

	/**  
	 * 设置 mdType  
	 * @param mdType mdType  
	 */
	public void setMdType(int mdType) {
		this.mdType = mdType;
	}

	/**  
	 * 获取 operatorType  
	 * @return operatorType operatorType  
	 */
	public int getOperatorType() {
		return operatorType;
	}

	/**  
	 * 设置 operatorType  
	 * @param operatorType operatorType  
	 */
	public void setOperatorType(int operatorType) {
		this.operatorType = operatorType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMdsmId() {
		return mdsmId;
	}

	public void setMdsmId(String mdsmId) {
		this.mdsmId = mdsmId;
	}

	public String getSmTitle() {
		return smTitle;
	}

	public void setSmTitle(String smTitle) {
		this.smTitle = smTitle;
	}

	public String getSmContent() {
		return smContent;
	}

	public void setSmContent(String smContent) {
		this.smContent = smContent;
	}

	public Date getSmCreatetime() {
		return smCreatetime;
	}
	public String getSmCreatetimeStr() {
		return DateUtil.dateToFullString(smCreatetime);
	}
	
	public void setSmCreatetime(Date smCreatetime) {
		this.smCreatetime = smCreatetime;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public Integer getSmType() {
		return smType;
	}

	public void setSmType(Integer smType) {
		this.smType = smType;
	}

	public Boolean getSmIsdelete() {
		return smIsdelete;
	}

	public void setSmIsdelete(Boolean smIsdelete) {
		this.smIsdelete = smIsdelete;
	}

	public String getSmComment() {
		return smComment;
	}

	public void setSmComment(String smComment) {
		this.smComment = smComment;
	}

	public String getMdId() {
		return mdId;
	}

	public void setMdId(String mdId) {
		this.mdId = mdId;
	}

	public String getSmId() {
		return smId;
	}

	public void setSmId(String smId) {
		this.smId = smId;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public Date getMdCreatetime() {
		return mdCreatetime;
	}

	public void setMdCreatetime(Date mdCreatetime) {
		this.mdCreatetime = mdCreatetime;
	}

	public Boolean getMdIsdelete() {
		return mdIsdelete;
	}

	public void setMdIsdelete(Boolean mdIsdelete) {
		this.mdIsdelete = mdIsdelete;
	}

	public String getMdComment() {
		return mdComment;
	}

	public void setMdComment(String mdComment) {
		this.mdComment = mdComment;
	}

	/**  
	 * 获取 operatorId  
	 * @return operatorId operatorId  
	 */
	public String getOperatorId() {
		return operatorId;
	}

	/**  
	 * 设置 operatorId  
	 * @param operatorId operatorId  
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
}
