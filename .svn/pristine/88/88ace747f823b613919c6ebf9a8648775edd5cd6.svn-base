package com.jero.esc.common.cache;

import java.util.Date;
import java.util.Map;


public class SingletonUtil {

	public static String getAccessToken() {
		String result = "";
		SingletonAccessToken singleton = SingletonAccessToken.getInstance();
		Map<String, String> map = singleton.getMap();
		String time = map.get("time");
		String accessToken = map.get("access_token");
		Long nowDate = new Date().getTime();
		if (accessToken != null && time != null && nowDate - Long.parseLong(time) < 7000 * 1000) {
			result = accessToken;
		} else {
			String access_token=HttpXmlClient.getToken();
			map.put("time", nowDate + "");
			map.put("access_token", access_token);
			result = access_token;
			}
		return result;
	}
	
	public static String getJsapiTicket(String accessToken) {
		String result = "";
		SingletonJsapiTicket singleton = SingletonJsapiTicket.getInstance();
		Map<String, String> map = singleton.getMap();
		String time = map.get("time");
		String jsapiTicket = map.get("jsapi_ticket");
		Long nowDate = new Date().getTime();
		if (jsapiTicket != null && time != null && nowDate - Long.parseLong(time) < 7000 * 1000) {
			result = jsapiTicket;
		} else {
			String jsapi_ticket=HttpXmlClient.getTicket(accessToken);  
			map.put("time", nowDate + "");
			map.put("jsapi_ticket", jsapi_ticket);
			result = jsapi_ticket;
		}
		return result;
	}
}
