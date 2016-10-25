package com.nci.syncengine.util;

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
}
