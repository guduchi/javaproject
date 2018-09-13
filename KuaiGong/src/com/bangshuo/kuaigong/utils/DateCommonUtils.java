package com.bangshuo.kuaigong.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateCommonUtils {

	public static String getTheDate() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String dateStr = sd.format(new Date());
		return dateStr;
	}

	public static Map getWeekDay() {
		Map<String, String> map = new HashMap<String, String>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
		map.put("mon", df.format(cal.getTime()));
		// 这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// 增加一个星期，才是我们中国人理解的本周日的日期
		cal.add(Calendar.WEEK_OF_YEAR, 1);
		map.put("sun", df1.format(cal.getTime()));
		return map;
	}

	public static Map getMonthDate() {
		Map<String, String> map = new HashMap<String, String>();
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		// 设置时间,当前时间不用设置
		// calendar.setTime(new Date());
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
		map.put("monthF", format.format(calendar.getTime()));
		// 设置日期为本月最大日期
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		// 打印
		map.put("monthL", df1.format(calendar.getTime()));
		return map;
	}
	
	public static Map getYearDate() {
		Map<String, String> map = new HashMap<String, String>();
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		// 设置时间,当前时间不用设置
		// calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
		map.put("yearF", format.format(calendar.getTime()));
		// 设置日期为本月最大日期
		calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		// 打印
		map.put("yearL", df1.format(calendar.getTime()));
		return map;
	}

	private static void print(Object o) {
		System.out.println(o.toString());
	}
	
	public static void main(String[] args) {
		Map<String, String> map = getWeekDay();
		System.out.println(map.get("mon"));
		System.out.println(map.get("sun"));
		Map<String, String> map1 = getMonthDate();
		System.out.println(map1.get("monthF"));
		System.out.println(map1.get("monthL"));
		Map<String, String> map2 = getYearDate();
		System.out.println(map2.get("yearF"));
		System.out.println(map2.get("yearL"));
	}

}