package com.bbs.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public static String format(Date date) {
		return dateFormat.format(date);
	}

	public static Date parse(String date) throws ParseException {
		return dateFormat.parse(date);
	}
}
