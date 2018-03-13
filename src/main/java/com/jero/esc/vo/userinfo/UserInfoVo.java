package com.jero.esc.vo.userinfo;

import java.util.Date;

import com.jero.esc.common.utils.fastvalidate.FastValidateAnnotation;

/**
 * @copyright 上善云图信息技术有限公司
 * @author gb
 * @version v1.0
 * @date 2016年12月8日
 * @description 
*/
public class UserInfoVo {
	//个人基本信息表
	private String userId;
	
	private String userLogId;
	
	private String userRealName;
	
	 @FastValidateAnnotation(name = "微信号")
	private String userWechat;
	
	@FastValidateAnnotation(name = "照片")
	private String userPhoto;
	
	private String userComment;

	//	登录信息表
	private String logId;       
    
	private String logCell;     
	                            
	private String logEmail;    
	                            
	@FastValidateAnnotation(name = "昵称")
	private String logName;     
	                            
	private String logPass;     
	                            
	private Date logCreatetime; 
	                            
	private Boolean logIsdelete;
	                            
	private Integer logState;   
	                            
	private Integer logType;    
	                            
	private String logRegip;    
	                            
	private Boolean logIslog;   
	                            
	private String logComment;
	private String logMode;
	/**  
	 * 获取 logMode  
	 * @return logMode logMode  
	 */
	public String getLogMode() {
		return logMode;
	}

	/**  
	 * 设置 logMode  
	 * @param logMode logMode  
	 */
	public void setLogMode(String logMode) {
		this.logMode = logMode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(String userLogId) {
		this.userLogId = userLogId;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserWechat() {
		return userWechat;
	}

	public void setUserWechat(String userWechat) {
		this.userWechat = userWechat;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
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
