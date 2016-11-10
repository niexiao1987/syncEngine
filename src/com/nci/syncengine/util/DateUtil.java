package com.nci.syncengine.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getDate(Date date, int field, int amount) {
		if (date == null) {
			return new Date();
		}
		if (field != -1) {
			Date currentDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			cal.add(field, amount);
			return cal.getTime();
		}
		return date;
	}

	public static Date getDate(Date date) {
		return getDate(date, -1, -1);
	}

	public static Date getDate() {
		return getDate(null, -1, -1);
	}

	public static Calendar toCalendar(Date date) {
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		}
		return null;
	}

	/**
	 * 获得当前日期的默认格式化字符串
	 * 
	 * @return
	 */
	public static String format() {
		return format(new Date());
	}

	/**
	 * 获得指定日期的默认格式化字符串
	 * 
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static String format(Date date) {
		String formateString = "yyyy-MM-dd HH:mm:ss";
		return format(date, formateString);
	}

	/**
	 * 获得指定日期的指定格式的格式化字符串
	 * 
	 * @param date
	 *            指定日期
	 * @param formatString
	 *            指定格式
	 * @return
	 */
	public static String format(Date date, String formatString) {
		SimpleDateFormat dateFormater = new SimpleDateFormat(formatString);
		return dateFormater.format(date);
	}
}
