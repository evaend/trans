package com.erp.trans.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class DateUtils {

	public static Calendar cal = Calendar.getInstance();
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 返回指定格式的字符串日期
	 * 
	 * @param date
	 *            日期 允许NULL,为NULL时返回空字符
	 * @param format
	 *            返回的字符串日期格式
	 * @return
	 */
	public static String DateToStr(Date date, String format) {
		String dateStr = null;
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			dateStr = simpleDateFormat.format(date);
		}
		return dateStr;
	}

	/**
	 * 日期转换为时间
	 * 
	 * @param date
	 * @return
	 */
	public static Long toLong(Date date) {
		String dateStr = DateToStr(date, "yyyyMMdd");
		return new Long(dateStr);
	}

	public static Integer toInteger(Date date) {
		String dateStr = DateToStr(date, "yyyyMMdd");
		return new Integer(dateStr);
	}

	public static String IntegerToStr(Integer dateInteger, String oldFormat,
			String newFormat) {
		String dateStr = null;
		try {
			Date date = convertDate(dateInteger.toString(), oldFormat);
			dateStr = DateToStr(date, newFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateStr;
	}

	public static Integer strDateToIntegerDate(String start, String oldFormat,
			String newFormat) {
		String dateStr = null;
		try {
			Date date = convertDate(start, oldFormat);
			dateStr = DateToStr(date, newFormat);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return new Integer(dateStr);
	}

	/**
	 * 将英文格式的时间字符串转换为中文格式
	 * 
	 * @param enDateStr
	 * @param format
	 * @return
	 */
	public static String enDateStrToZhDateStr(String enDateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"EEE MMM d HH:mm:ss Z SSS yyyy", Locale.US);
		Date date = null;
		try {
			date = sdf.parse(enDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dateStr = DateUtils.DateToStr(date, format);
		return dateStr;
	}

	/**
	 * 根据字符串返回指定格式的日期
	 * 
	 * @param dateStr
	 *            日期(字符串)
	 * @param format
	 *            日期格式
	 * @return 日期(Date)
	 * @throws ParseException
	 */
	public static Date convertDate(String dateStr, String format)
			throws ParseException {
		java.util.Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		date = simpleDateFormat.parse(dateStr);
		return date;
	}

	public static String format(String dateStr, String format)
			throws ParseException {
		Date date = convertDate(dateStr, format);
		return DateToStr(date, format);
	}

	/**
	 * 小时的变动
	 * 
	 * @param hour
	 * @return
	 */
	public static Date minuteChange(Date date, Integer minute) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(java.util.Calendar.MINUTE, minute);
		return calendar.getTime();
	}

	/**
	 * 小时的变动
	 * 
	 * @param hour
	 * @return
	 */
	public static Date hourChange(Date date, Integer hour) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(java.util.Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}

	/**
	 * 天的变动
	 * 
	 * @param hour
	 * @return
	 */
	public static Date dayChange(Date date, Integer day) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(java.util.Calendar.DAY_OF_WEEK, day);
		return calendar.getTime();
	}

	/**
	 * 月的变动
	 * 
	 * @param hour
	 * @return
	 */
	public static Date monthChange(Date date, Integer month) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(java.util.Calendar.MONTH, month);
		return calendar.getTime();
	}

	/**
	 * 年的变动
	 * 
	 * @param hour
	 * @return
	 */
	public static Date yearChange(Date date, Integer year) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(java.util.Calendar.YEAR, year);
		return calendar.getTime();
	}

	/**
	 * 获取年
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getYear(Date date) {
		if (null == date) {
			return null;
		}
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 获取月
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getMonth(Date date) {
		if (null == date) {
			return null;
		}
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 获取日
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getDay(Date date) {
		if (null == date) {
			return null;
		}
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DATE);
	}

	/**
	 * 设置日
	 * 
	 * @param date
	 * @return
	 */
	public static Date setDay(Date date, Integer day) {
		if (null == date) {
			return null;
		}
		cal.setTime(date);
		cal.set(Calendar.DATE, day);
		return cal.getTime();
	}

	/**
	 * @param date1
	 *            需要比较的时间 不能为空(null),需要正确的日期格式
	 * @param date2
	 *            被比较的时间 为空(null)则为当前时间
	 * @param stype
	 *            返回值类型 0为多少天，1为多少个月，2为多少年
	 * @return
	 */
	public static Integer compareDate(String date1, String date2, int stype) {
		if (null == date1) {
			return null;
		}
		date2 = date2 == null ? DateUtils.getCurrentDate() : date2;
		int n = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(DateUtils.convertDate(date1, DATE_FORMAT));
			c2.setTime(DateUtils.convertDate(date2, DATE_FORMAT));
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
			n++;
			if (stype == 1) {
				c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
			} else {
				c1.add(Calendar.DATE, 1); // 比较天数，日期+1
			}
		}

		n = n - 1;

		if (stype == 2) {
			n = n / 365;
		}
		return n;
	}

	/**
	 * 得到当前日期
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		return simple.format(date);

	}

	/**
	 * 取得两个时间之间相差的天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int getIntervalDays(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		if (c1.after(c2)) {
			Calendar cal = c1;
			c1 = c2;
			c2 = cal;
		}
		long sl = c1.getTimeInMillis();
		long el = c2.getTimeInMillis();
		long ei = el - sl;
		return (int) (ei / (1000 * 60 * 60 * 24));
	}

	/**
	 * 取得两个时间之间相差的年数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Double getIntervalYears(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		if (c1.after(c2)) {
			Calendar cal = c1;
			c1 = c2;
			c2 = cal;
		}
		long sl = c1.getTimeInMillis();
		long el = c2.getTimeInMillis();
		long ei = el - sl;
		return (double) (ei / (1000 * 60 * 60 * 24 * 365 * 1.0));
	}

	/**
	 * 转换字符串为日期类型（固定格式） eg: 2011-7-7（2009-11-20）
	 * 
	 * @param dateStr
	 */
	public static Date coalitionDateStr2(String dateStr, String fgf) {
		String aaa = dateStr;
		if (StringUtils.isNotBlank(dateStr)) {
			String[] mry = dateStr.split(fgf);
			String y = mry[0];
			String m = mry[1];
			String d = mry[2];
			if (Integer.parseInt(m) < 10) {
				m = "0" + m;
			}
			if (Integer.parseInt(d) < 10) {
				d = "0" + d;
			}
			aaa = y + m + d;
		}
		java.util.Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			date = simpleDateFormat.parse(aaa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(date.toString());
		return date;
	}

	/**
	 * 转换字符串为日期类型（固定格式） eg: 01-1月 -00 12.00.00.000000000 上午（01-11月-00
	 * 12.00.00.000000000 上午）
	 * 
	 * @param dateStr
	 */
	public static Date coalitionDateStr(String dateStr) {
		String aaa = dateStr;
		if (StringUtils.isNotBlank(dateStr)) {
			String[] muStr = dateStr.split(" ");
			if (muStr.length > 3) {
				muStr[0] = muStr[0] + muStr[1];
				muStr[1] = muStr[2];
				muStr[2] = muStr[3];
			}
			String[] mry = muStr[0].split("-");
			String d = mry[0];
			String m = mry[1];
			String y = mry[2];
			String[] hfm = muStr[1].split("\\.");
			String h = hfm[0];
			if ("下午".equals(muStr[2])) {
				int ah = Integer.parseInt(h) + 12;
				h = ah + "";
			}
			String f = hfm[1];
			String miao = hfm[2];
			String hm = hfm[3];
			if (m.contains("月")) {
				m = m.replaceAll("月", "");
			}
			if (Integer.parseInt(m) < 10 && m.length() < 2) {
				m = "0" + m;
			}
			aaa = y + m + d + " " + h + ":" + f + ":" + miao + ":" + hm;
		}
		java.util.Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyMMdd hh:mm:ss:SS");
		try {
			date = simpleDateFormat.parse(aaa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 时间大小比较
	 * 
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static Integer timeCompare(Date t1, Date t2) {
		if (t1 != null && t2 != null) {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(t1);
			c2.setTime(t2);
			int result = c1.compareTo(c2);
			return result;
		}
		return null;
	}

	/**
	 * 日期四舍五入
	 * 
	 * @param date
	 * @return
	 */
	public static Date changeAverage(Date date, Integer num) {
		if (null == date) {
			return null;
		}
		Integer day = DateUtils.getDay(date);
		date = DateUtils.dayChange(date, -(day - 1));
		if (day > 15) {
			date = DateUtils.monthChange(date, 1);
		}
		if (null != num) {
			date = DateUtils.dayChange(date, num);
		}
		return date;
	}
	
	/**
	 * 日期格式化字符串
	 *
	 * @date	2016年7月18日 下午3:56:12
	 *
	 * @param	date
	 * @return	String
	 */
	public static String format(Date date) {
		return date!=null ? new SimpleDateFormat(TIME_FORMAT).format(date) : null;
	}
	
	/**
	 * 日期格式化字符串
	 *
	 * @date	2016年7月18日 下午3:56:29
	 *
	 * @param	date
	 * @param	datePattern
	 * @return	String
	 */
	public static String format(Date date, String datePattern) {
		return date!=null ? new SimpleDateFormat(datePattern).format(date) : null;
	}

	/**
	 * 日期字符串解析成日期对象
	 *
	 * @date	2016年7月18日 下午3:56:43
	 *
	 * @param	dateString
	 * @throws	ParseException
	 * @return	Date
	 */
	public static Date parse(String dateString) throws ParseException {
		return dateString!=null && !"".equals(dateString.trim()) ? new SimpleDateFormat(TIME_FORMAT).parse(dateString) : null;
	}
	
	/**
	 * 日期字符串解析成日期对象
	 *
	 * @date	2016年7月18日 下午3:56:58
	 *
	 * @param	dateString
	 * @param	datePattern
	 * @throws	ParseException
	 * @return	Date
	 */
	public static Date parse(String dateString, String datePattern) throws ParseException {
		return dateString!=null && !"".equals(dateString.trim()) ? new SimpleDateFormat(datePattern).parse(dateString) : null;
	}

	public static void main(String args[]) {
		/*
		 * String a = "12.00.00.000000000"; String[] bb = a.split("\\.");
		 * System.out.println("chu lai le   " + bb.length);
		 * coalitionDateStr("01-1月 -00 12.00.00.000000000 上午");
		 */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date a = new Date();
		Date b = dayChange(a, 30);
		System.out.println(simpleDateFormat.format(b));
		/*
		 * java.util.Date date1 = null; java.util.Date date2 = null; try { date1
		 * = simpleDateFormat.parse("20110726"); date2 =
		 * simpleDateFormat.parse("20110727"); } catch (ParseException e) {
		 * e.printStackTrace(); } int aa = timeCompare(date1,date2);
		 * System.out.println("===="+aa);
		 */
	}
}
