package com.jero.esc.po.details;

import java.util.Date;

public class MegDetails {
    private String mdId;

    private String smId;

    private String logId;

    private Date mdCreatetime;

    private Boolean mdIsdelete;

    private String mdComment;
    
    /** 操作者Id */
    private String operatorId;
    
    /** 操作者类型 2为服务商 */
    private int operatorType;

    /** 消息类型 1:关注,2点赞,3收藏4:约见 */
    private int mdType;
    
    /** 是否已查看 */
    private int mdIsSee;
    
    /**  
	 * 获取 mdIsSee  
	 * @return mdIsSee mdIsSee  
	 */
	public int getMdIsSee() {
		return mdIsSee;
	}
	/**  
	 * 设置 mdIsSee  
	 * @param mdIsSee mdIsSee  
	 */
	public void setMdIsSee(int mdIsSee) {
		this.mdIsSee = mdIsSee;
	}
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
	public String getMdId() {
        return mdId;
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

	public void setMdId(String mdId) {
        this.mdId = mdId == null ? null : mdId.trim();
    }

    public String getSmId() {
        return smId;
    }

    public void setSmId(String smId) {
        this.smId = smId == null ? null : smId.trim();
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
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
        this.mdComment = mdComment == null ? null : mdComment.trim();
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