package com.jero.esc.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {
	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(Integer dividend, Integer divisor) {
		return percentage(dividend, divisor, 2);
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(Float dividend, Float divisor) {
		return percentage(dividend, divisor, 2);
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(Double dividend, Double divisor) {
		return percentage(dividend, divisor, 2);
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(Long dividend, Long divisor) {
		return percentage(dividend, divisor, 2);
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(BigDecimal dividend, BigDecimal divisor) {
		return percentage(dividend, divisor, 2);
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(Integer dividend, Integer divisor, Integer scale) {
		String res = "";
		if (dividend != null && divisor != null && divisor.intValue() != 0) {
			BigDecimal aa = new BigDecimal(dividend).multiply(new BigDecimal(100));
			res = aa.divide(new BigDecimal(divisor), scale == null ? 2 : scale, RoundingMode.HALF_UP) + "";
		}
		return res.replaceAll("\\.00", "");
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(Float dividend, Float divisor, Integer scale) {
		String res = "";
		if (dividend != null && divisor != null && divisor.intValue() != 0) {
			BigDecimal aa = new BigDecimal(dividend).multiply(new BigDecimal(100));
			res = aa.divide(new BigDecimal(divisor), scale == null ? 2 : scale, RoundingMode.HALF_UP) + "";
		}
		return res.replaceAll("\\.00", "");
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(Double dividend, Double divisor, Integer scale) {
		String res = "";
		if (dividend != null && divisor != null && divisor.intValue() != 0) {
			BigDecimal aa = new BigDecimal(dividend).multiply(new BigDecimal(100));
			res = aa.divide(new BigDecimal(divisor), scale == null ? 2 : scale, RoundingMode.HALF_UP) + "";
		}
		return res.replaceAll("\\.00", "");
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(Long dividend, Long divisor, Integer scale) {
		String res = "";
		if (dividend != null && divisor != null && divisor.intValue() != 0) {
			BigDecimal aa = new BigDecimal(dividend).multiply(new BigDecimal(100));
			res = aa.divide(new BigDecimal(divisor), scale == null ? 2 : scale, RoundingMode.HALF_UP) + "";
		}
		return res.replaceAll("\\.00", "");
	}

	/**
	 * 计算百分比
	 * 
	 * @param dividend被除数
	 * @param divisor除数
	 * @return
	 */
	public static String percentage(BigDecimal dividend, BigDecimal divisor, Integer scale) {
		String res = "";
		if (dividend != null && divisor != null && divisor.intValue() != 0) {
			BigDecimal aa = dividend.multiply(new BigDecimal(100));
			res = aa.divide(divisor, scale == null ? 2 : scale, RoundingMode.HALF_UP) + "";
		}
		return res.replaceAll("\\.00", "");
	}
}
