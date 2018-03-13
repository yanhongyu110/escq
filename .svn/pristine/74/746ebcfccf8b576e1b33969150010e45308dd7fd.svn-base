package com.jero.esc.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 时间处理工具类
 * 
 * @author zhengqiyang
 */
public class DateUtil {

	private static Logger log = Logger.getLogger(DateUtil.class);

	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT1 = "yyyy-MM-dd HH:mm";
	public static final String DATE_CHINA = "yyyy年MM月dd日";
	public static final String DATE_FORMAT_BAR = "yyyy-MM-dd";
	public static final String DATE_FORMAT_SPRIT = "yyyy/MM/dd";
	public static final String DATE_FORMAT_MS = "yyyy-MM-dd HH:mm:ss,SSS";
	public static final String DATE_FORMAT_FILE_SUFFIX = "yyyyMMddHHmmss";
	public static final String DATE_FORMAT_FILE_DATE = "yyyyMMdd";

	/**
	 * 将两个日期相减得到间隔的天数
	 * 
	 * @param startdate
	 *            enddate
	 * @return int days
	 */
	public static int dateTointerval(Date startdate, Date enddate) {
		long timeNow = enddate.getTime();
		long timeOld = startdate.getTime();
		int days = (int) ((timeNow - timeOld) / (1000 * 60 * 60 * 24));// 化为天
		return days;

	}

	/**
	 * 将日期转化为字符串 格式为"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date
	 * @return String date
	 */
	public static String dateToFullString(Date date) {
		return dateToString(date, DATE_FORMAT);

	}
	
	/**
	 * 将日期转化为字符串 格式为"yyyy-MM-dd HH:mm"
	 * 
	 * @param date
	 * @return String date
	 */
	public static String dateToFull1String(Date date) {
		return dateToString(date, DATE_FORMAT1);

	}
	public static String dateToFull1StringDate(Date date) {
		return dateToString(date, DATE_FORMAT_FILE_DATE);
		
	}

	/**
	 * 将日期转化为“yyyy年MM月dd日”格式字符串
	 * 
	 * @param date
	 * @return String date
	 */
	public static String dateToChinaString(Date date) {
		return dateToString(date, DATE_CHINA);
	}

	/**
	 * 将日期转化为“yyyy/MM/dd”格式字符串
	 * 
	 * @param date
	 * @return String date
	 */
	public static String dateToSpritString(Date date) {
		return dateToString(date, DATE_FORMAT_SPRIT);
	}

	/**
	 * 将日期转化为“yyyy-MM-dd”格式字符串
	 * 
	 * @param date
	 * @return String date
	 */
	public static String dateToBarString(Date date) {
		return dateToString(date, DATE_FORMAT_BAR);
	}

	/**
	 * 将日期转化为用户指定格式字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		String datetime = null;
		if (date == null) {
			return datetime;
		}
		try {
			SimpleDateFormat dformate = new SimpleDateFormat(pattern);
			datetime = dformate.format(date);
		} catch (Exception e) {
			log.error("将日期转化为用户指定格式字符串异常:" + e);
			e.printStackTrace();
		}
		return datetime;
	}

	/**
	 * 将"yyyy-MM-dd HH:mm:ss"格式字符传转换化为日期
	 * 
	 * @param dateStr
	 * @return
	 * @throws Exception
	 */
	public static Date dateFullStrToDate(String dateStr) {
		return strToDate(dateStr, DATE_FORMAT);
	}

	/**
	 * 将指定日期格式字符串转换成日期
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date strToDate(String dateStr, String pattern) {
		Date da = null;
		SimpleDateFormat dformate = new SimpleDateFormat(pattern);
		try {
			da = dformate.parse(dateStr);
		} catch (ParseException e) {
			log.error("把字符串转换成日期对象异常:" + e);
			e.printStackTrace();
		}
		return da;
	}

	/**
	 * 得到当前标准的格式化时间字符串 格式为"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @return String date
	 */
	public static String getCurrentDate() {
		SimpleDateFormat dformate = new SimpleDateFormat(DATE_FORMAT);
		return dformate.format(new Date());
	}

	/**
	 * 得到当前标准的格式化时间字符串 格式为"yyyy年MM月dd日"
	 * 
	 * @return String date
	 */
	public static String getChiinaDate() {
		SimpleDateFormat dformate = new SimpleDateFormat(DATE_CHINA);
		return dformate.format(new Date());
	}

	/**
	 * 得到指定格式的当前字符串
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrentDate(String format) {
		SimpleDateFormat dformate = new SimpleDateFormat(format);
		return dformate.format(new Date());
	}

	/**
	 * 将一个字符传转化为一个标准的时间 格式为"yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDate(String date) {
		SimpleDateFormat dformate = new SimpleDateFormat(DATE_FORMAT);
		Date currentDate = null;
		try {
			currentDate = dformate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentDate;
	}

	/**
	 * 将一个字符传转化为一个标准的时间 格式为"yyyy-MM-dd"
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDate2(String date) {
		SimpleDateFormat dformate = new SimpleDateFormat(DATE_FORMAT_BAR);
		Date currentDate = null;
		try {
			currentDate = dformate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentDate;
	}
	
	public static int getDaysOfTheMonth(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static void main(String[] args) {
		String time = "1933-12-11 00:00:00";
		System.out.println(dateToFullString(getDate(time)));
	}
	
	 public static String getPayMentId(){
		  int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
		  int r2=(int)(Math.random()*(10));
		  long now = System.currentTimeMillis();//一个13位的时间戳
		  String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
		  return paymentID;
	  }
}