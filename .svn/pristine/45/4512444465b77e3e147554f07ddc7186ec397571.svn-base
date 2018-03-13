package com.jero.esc.common.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <pre>
 * <b> ticket的单例.</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2017-6-23上午9:34:38
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2017-6-23上午9:34:38         new file.
 * </pre>
 */
public class SingletonJsapiTicket {
	//缓存jsapi_ticket 和一个 时间
	private Map<String, String> map = new HashMap<String,String>();

	private SingletonJsapiTicket() {
	}

	private static SingletonJsapiTicket single = null;

	public static SingletonJsapiTicket getInstance() {
		if (single == null) {
			single = new SingletonJsapiTicket();
		}
		return single;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public static SingletonJsapiTicket getSingle() {
		return single;
	}

	public static void setSingle(SingletonJsapiTicket single) {
		SingletonJsapiTicket.single = single;
	}
}