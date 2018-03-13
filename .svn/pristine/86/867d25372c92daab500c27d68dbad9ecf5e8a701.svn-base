package com.jero.esc.common.utils;

import java.util.UUID;

/**
 * @Description <产生一个UUID对象>
 * @author  郑启阳
 * @date  2016年5月31日 上午10:20:12
 * @version   1.0
 */
public class UUIDUtil {
	/**
	 * 通过JVM的UUID产生，并取出
	 * @return
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		/*StringBuilder sb = new StringBuilder(32);
		sb.append(uuid.substring(0,8));
		sb.append(uuid.substring(14,18));
		sb.append(uuid.substring(19,23));
		sb.append(uuid.substring(24));*/
		return uuid.toString().replace("-", "");    
	}
	
	public static void main(String[] args) {
		System.out.println(UUIDUtil.getUUID());
	}
}
