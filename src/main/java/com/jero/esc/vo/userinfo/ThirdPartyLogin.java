package com.jero.esc.vo.userinfo;

/**
 * 
 * <pre>
 * <b> 三方登录实体类 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2018-1-17上午10:24:22
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018-1-17上午10:24:22         new file.
 * </pre>
 */
public class ThirdPartyLogin {

	private String id;
	private String telephone;
	/** 类型 1微信 2qq */
	private String type;
	/** 第三方登录唯一标志 */
	private String mediaId;
	private String logId;
	
	public ThirdPartyLogin() {
		super();
	}
	/**  
	 * 获取 id  
	 * @return id id  
	 */
	public String getId() {
		return id;
	}
	/**  
	 * 设置 id  
	 * @param id id  
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**  
	 * 获取 telephone  
	 * @return telephone telephone  
	 */
	public String getTelephone() {
		return telephone;
	}
	/**  
	 * 设置 telephone  
	 * @param telephone telephone  
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**  
	 * 获取 type  
	 * @return type type  
	 */
	public String getType() {
		return type;
	}
	/**  
	 * 设置 type  
	 * @param type type  
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**  
	 * 获取 mediaId  
	 * @return mediaId mediaId  
	 */
	public String getMediaId() {
		return mediaId;
	}
	/**  
	 * 设置 mediaId  
	 * @param mediaId mediaId  
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	/**  
	 * 获取 logId  
	 * @return logId logId  
	 */
	public String getLogId() {
		return logId;
	}
	/**  
	 * 设置 logId  
	 * @param logId logId  
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}
}
