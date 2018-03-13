package com.jero.esc.po.pubinfo;

import java.util.Date;


public class CommonTypeImg {
	/** 主键id */
	private String id;
	/** 图片路径 */
	private String path;
	/** 类型id */
	private String commonTypeId;
	/** 创建时间 */
	private Date createTime;
	/** 创建人id */
	private String adminId;
	
	/**
	 * 
	 *<pre>
	 *<b> 空参构造 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-1 下午2:33:16
	 *</pre>
	 */
	public CommonTypeImg() {
		super();
	}
	/**
	 * 
	 *<pre>
	 *<b> 有参构造 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-1 下午2:33:28
	 *@param id
	 *@param path
	 *@param commonTypeId
	 *</pre>
	 */
	public CommonTypeImg(String id, String path, String commonTypeId) {
		super();
		this.id = id;
		this.path = path;
		this.commonTypeId = commonTypeId;
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
	 * 获取 path  
	 * @return path path  
	 */
	public String getPath() {
		return path;
	}
	/**  
	 * 设置 path  
	 * @param path path  
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**  
	 * 获取 commonTypeId  
	 * @return commonTypeId commonTypeId  
	 */
	public String getCommonTypeId() {
		return commonTypeId;
	}
	/**  
	 * 设置 commonTypeId  
	 * @param commonTypeId commonTypeId  
	 */
	public void setCommonTypeId(String commonTypeId) {
		this.commonTypeId = commonTypeId;
	}
	/**  
	 * 获取 createTime  
	 * @return createTime createTime  
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**  
	 * 设置 createTime  
	 * @param createTime createTime  
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**  
	 * 获取 adminId  
	 * @return adminId adminId  
	 */
	public String getAdminId() {
		return adminId;
	}
	/**  
	 * 设置 adminId  
	 * @param adminId adminId  
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
}