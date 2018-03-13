package com.jero.esc.common.po; 
/** 
* @Description
* @author zengd
* @date 2016年12月8日 下午3:41:06 
* @version  
*/
public class Picture {
	private String pictureName;
	private String url;
	private String switchUrl;

	public String getSwitchUrl() {
		return switchUrl;
	}

	public void setSwitchUrl(String switchUrl) {
		this.switchUrl = switchUrl;
	}

	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
