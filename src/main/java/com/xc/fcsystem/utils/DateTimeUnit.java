package com.xc.fcsystem.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期格式化
 * 
 * @Title: DateTimeUnit.java
 * @Package com.storemax.supervision.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @author A18ccms A18ccms_gmail_com
 * @version V1.0
 */
public class DateTimeUnit {
	/**
	 * 日志句柄
	 */
	private final static Logger logger = LogManager
			.getLogger(DateTimeUnit.class);
	
	/**
	 * DATETIME <br>
	 */
	public static final String DATE_A = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * DATE_MIN <br>
	 */
	public static final String DATE_B = "yyyy-MM-dd HH:mm";
	
	/**
	 * DATE <br>
	 */
	public static final String DATE_C = "yyyy-MM-dd";
	
	/**
	 * DATE <br>
	 */
	public static final String DATE_D = "yyyyMMdd";
	
	/**
	 * 
	 */
	public static final String DATE_E = "yyyy-MM";
	
	/**
	 * 时间字符串转化为日期类型，格式为yyyy-MM-dd <br>
	 *
	 * @param date 时间字符串，格式为yyyy-MM-dd <br>
	 * @return Date<br>
	 */
	public static Date parseDate(String date, String[] parsePattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(parsePattern[0]);
			return sdf.parse(date);
		} catch (ParseException e) {
			logger.error("ParseDate error:str = " + date + "; parsePattern="
					+ parsePattern[0], e);
			return null;
		}
	}
	
	/**
	 * Parses a string representing a date by trying a variety of different
	 * parser.
	 *
	 * @param str <br>
	 * @param parsePattern <br>
	 * @return <br>
	 */
	public static Date parseDate(String str, String parsePattern) {
		if (null == str || str.length() == 0) {
			return null;
		}
		return DateTimeUnit.parseDate(str, new String[] { parsePattern });
	}
	
	/**
	 * Description: Translate to a date for 2016-11-11 <br>
	 *
	 * @param str <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static Date parseDate(String str) {
		return parseDate(str, DATE_C);
	}
	
	/**
	 * Description: <br>
	 *
	 * @param str <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static Date parseDateByYear(String str) {
		return parseDate(str, "yyyy");
	}
	
	/**
	 * Description: <br>
	 *
	 * @param str <br>
	 * @return <br>
	 * @author wuhanwen<br>
	 * @taskId <br>
	 */
	public static Date parseDateTime(String str) {
		return parseDate(str, DATE_A);
	}
	
	/**
	 * 精确到分钟的时间
	 *
	 * @param str <br>
	 * @return <br>
	 */
	public static Date parseDateMin(String str) {
		return parseDate(str, DATE_B);
	}
	/**
	 * 
	 * @Title: formatDateD 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param date
	 * @return
	 */
	public static String formatDateD(Date date) {
		return formatDate(date, DATE_A);
	}
	/**
	 * 格式化
	 * @Title: formatDateE 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param date
	 * @return
	 */
	public static String formatDateE(Date date) {
		return formatDate(date, DATE_E);
	}
	/**
	 * format data to my style
	 *
	 * @param date <br>
	 * @param format <br>
	 * @return <br>
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat myFmt = new SimpleDateFormat(format);
		myFmt.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		if (null == date) {
			return "";
		}
		return myFmt.format(date);
	}
	
	/**
	 * Description: <br>
	 *
	 * @param date <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static String formatDate(Date date) {
		return formatDate(date, DATE_C);
	}
	
	/**
	 * Description: <br>
	 *
	 * @param date <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, DATE_A);
	}
	
	/**
	 * Description: <br>
	 *
	 * @param date <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static String formatDateMin(Date date) {
		return formatDate(date, DATE_B);
	}
	
	/**
	 * Description: <br>
	 *
	 * @param date <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static String format14Time(Date date) {
		return formatDate(date, "yyyyMMddHHmmss");
	}
	
	public static String formatFullTime(Date date) {
		return formatDate(date, "yyyyMMddHHmmssSS");
	}
	
	
	/**
	 * 不需要考虑8小时时差 <br>
	 *
	 * @param date <br>
	 * @param format <br>
	 * @return <br>
	 */
	public static String formatDate2(Date date, String format) {
		SimpleDateFormat myFmt = new SimpleDateFormat(format);
		return myFmt.format(date);
	}
	
	/**
	 * Description: <br>
	 *
	 * @param date <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static String formatDate2(Date date) {
		return formatDate2(date, DATE_C);
	}
	
	/**
	 * Description: <br>
	 *
	 * @param date <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static String formatDateTime2(Date date) {
		return formatDate2(date, DATE_B);
	}
	
	/**
	 * Description: <br>
	 *
	 * @param dat1 <br>
	 * @param dat2 <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static boolean dateCompare(Date dat1, Date dat2) {
		boolean dateComPareFlag = true;
		if (dat2.compareTo(dat1) != 1) {
			dateComPareFlag = false;
		}
		return dateComPareFlag;
	}
	
	/**
	 * Description: <br>
	 *
	 * @param hour <br>
	 * @return <br>
	 * @taskId <br>
	 */
	@SuppressWarnings("static-access")
	public static Date setHour(Date date, int hour) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.HOUR_OF_DAY, hour);
		return c.getTime();
	}
	
	/**
	 * 让日期加 1
	 *
	 * @param date <br>
	 * @return <br>
	 */
	public static Date addOne(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.get(Calendar.DAY_OF_MONTH) + 1);
		return calendar.getTime();
	}
	
	/**
	 * 日期加 多少天
	 *
	 * @param date 2015-11-11 <br>
	 * @param days 1 <br>
	 * @return String <br>
	 */
	public static String addStringDays(String date, int days) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_C);
		Calendar rightNow = null;
		String result = null;
		try {
			Date dt = sdf.parse(date);
			rightNow = Calendar.getInstance();
			rightNow.setTime(dt);
			// 日期加1天
			rightNow.add(Calendar.DAY_OF_YEAR, days);
			result = sdf.format(rightNow.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Description: <br>
	 *
	 * @param date <br>
	 * @param days <br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static Date parseDate(String date, int days) {
		try {
			return new SimpleDateFormat(DATE_C).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Description: 校验传入的日期格式(yyyy-MM-dd)<br>
	 *
	 * @param dateStr 传入的日期<br>
	 * @return <br>
	 * @taskId <br>
	 */
	public static boolean checkDateFormat(String dateStr) {
		String eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(dateStr);
		return m.matches();
	}
	
	/**
	 * Description: 返回当前时间前几分钟时间<br>
	 *
	 * @param minNum <br>
	 * @return <br>
	 * @author huangpubo<br>
	 * @taskId <br>
	 */
	public static String getDateforeNow(int minNum) {
		Calendar can = Calendar.getInstance();
		can.add(Calendar.MINUTE, -minNum);
		return formatDateTime(can.getTime());
	}
	
	/**
	 * Adds to a date returning a new object. The original date object is
	 * unchanged.
	 *
	 * @param date the date, not null
	 * @param calendarField the calendar field to add to
	 * @param amount the amount to add, may be negative
	 * @return the new date object with the amount added
	 */
	public static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null ...");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}
	
	/**
	 * 精确比较时间前后
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int compareDate(Date d1, Date d2) {
		if (d1.getTime() < d2.getTime()) {
			return 1; // dt1 在dt2前
		} else if (d1.getTime() > d2.getTime()) {
			return -1; // dt1在dt2后
		} else {
			// 相等
			return 0;
		}
	}
	
	/**
	 * 把毫秒转化成日期
	 * 
	 * @param millSec(毫秒数)
	 * @return
	 */
	public static String transferLongToDate(Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_C);
		Date date = new Date(millSec);
		return sdf.format(date);
	}
	
	/**
	 * strTime的时间格式和formatType的时间格式必须相同
	 * 
	 * @param strTime 要转换的String类型的时间
	 * @param formatType 时间格式
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String strTime, String formatType)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		Date date = null;
		date = formatter.parse(strTime);
		return date;
	}
	
	/**
	 * stringToLong
	 * 
	 * @param strTime 要转换的String类型的时间
	 * @param formatType 时间格式
	 * @return
	 * @throws ParseException
	 */
	public static long stringToLong(String strTime, String formatType)
			throws ParseException {
		Date date = stringToDate(strTime, formatType); // String类型转成date类型
		if (date == null) {
			return 0;
		} else {
			long currentTime = dateToLong(date); // date类型转成long类型
			return currentTime;
		}
	}
	
	/**
	 * date类型转换为long类型
	 * 
	 * @param date
	 * @return
	 */
	public static long dateToLong(Date date) {
		return date.getTime();
	}
	
	/**
	 * 日期格式转化
	 * 
	 * @param dateStr String
	 * @param formType String
	 * @return
	 */
	public static String dateToFormat(String dateStr, String formType) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date date = format.parse(dateStr);// 有异常要捕获
			format = new SimpleDateFormat(formType);
			return format.format(date);
		} catch (Exception e) {
			logger.error(
					"ParseDate error:str = " + dateStr + "; parsePattern= {}",
					e);
			return null;
		}
		
	}
	
	/**
	 * 获取当前时间 <br>
	 * 
	 * @author huangpubo <br>
	 * @return "yyyy-MM-dd HH:mm:ss" <br>
	 */
	public static String getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		String currentTime = DateTimeUnit.formatDate(cal.getTime(), DATE_B);
		return currentTime;
	}
	
	public static String getThisMonthStartTime(){
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Calendar c = Calendar.getInstance();  
		 c.add(Calendar.MONTH, 0);  
		 c.set(Calendar.DAY_OF_MONTH, 1);
		 c.set(Calendar.HOUR_OF_DAY, 0);  
		 c.set(Calendar.MINUTE, 0);  
		 c.set(Calendar.SECOND,0);  
		 c.set(Calendar.MILLISECOND, 0); 
		return format.format(c.getTime());
	}
	public static String getThisMonthEndTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar ca = Calendar.getInstance();  
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
		//将小时至0  
		ca.set(Calendar.HOUR_OF_DAY, 23);  
		//将分钟至0  
		ca.set(Calendar.MINUTE, 59);  
		//将秒至0  
		ca.set(Calendar.SECOND,59);  
		//将毫秒至0  
		ca.set(Calendar.MILLISECOND, 59);
		return format.format(ca.getTime());
	}
	
	public static void main(String[] args){
		System.out.println(getThisMonthEndTime());
	}
}
