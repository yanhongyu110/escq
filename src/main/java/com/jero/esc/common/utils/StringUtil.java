package com.jero.esc.common.utils;


public class StringUtil {
	/**
	 * 判断字符串是否是整数
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isInteger(String number) {
		boolean isNumber = false;
		if (StringUtil.isNotEmpty(number)) {
			isNumber = number.matches("^([1-9]\\d*)|(0)$");
		}
		return isNumber;
	}

	/**
	 * 
	 *<pre>
	 *<b> 判断字符串是否为空 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-1 下午2:24:29
	 *@param str
	 *@return
	 *</pre>
	 */
	public static boolean isNotEmpty(String str) {
		boolean isEmpty = true;
		if (str == null || str.trim().equals("")) {
			isEmpty = false;
		}
		return isEmpty;
	}

	public static boolean isNotEmptys(String... str) {
		for (String string : str) {
			if (!isNotEmpty(string)) {
				return false;
			}
		}
		return true;
	}
}