package com.suixingpay.example.Utils;


import com.suixingpay.example.Enum.DateTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @author matieli
 * @version 2013-3-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
	// 日期格式 yyyymmdd HH:mm:ss
	private static final String FULL_DATE_TIME = "2\\d{3}[01]\\d{1}[0-3]\\d{1} [0-2]\\d:[0-5]\\d:[0-5]\\d";
	// 日期格式 yyyy-mm-dd HH:mm:ss
	private static final String FULL_DATE_TIME_MID = "2\\d{3}-[01]\\d{1}-[0-3]\\d{1} [0-2]\\d:[0-5]\\d:[0-5]\\d";
	// 日期格式 yyyy/mm/dd HH:mm:ss
	private static final String FULL_DATE_TIME_XIEXIAN = "2\\d{3}/[01]\\d{1}/[0-3]\\d{1} [0-2]\\d:[0-5]\\d:[0-5]\\d";
	// 日期格式 yyyymmdd HHmmss
	private static final String FULL_DATE_TIME_NO_MAOHAO = "2\\d{3}[01]\\d{1}[0-3]\\d{1} [0-2]\\d[0-5]\\d[0-5]\\d";
	// 日期格式 yyyymmddHHmmss
	private static final String FULL_DATE_TIME_NO_BLANK_NO_MAOHAO = "2\\d{3}[01]\\d{1}[0-3]\\d{1}[0-2]\\d[0-5]\\d[0-5]\\d";
	// 日期格式 yyyy-mm-dd HHmmss
	private static final String FULL_DATE_TIME_MID_NO_MAOHAO = "2\\d{3}-[01]\\d{1}-[0-3]\\d{1} [0-2]\\d[0-5]\\d[0-5]\\d";
	// 日期格式 yyyy/mm/dd HHmmss
	private static final String FULL_DATE_TIME_XIEXIAN_NO_MAOHAO = "2\\d{3}/[01]\\d{1}/[0-3]\\d{1} [0-2]\\d[0-5]\\d[0-5]\\d";
	// 日期格式 yyyymmdd
	private static final String DATE = "2\\d{3}[01]\\d{1}[0-3]\\d{1}";
	// 日期格式 yyyy-mm-dd
	private static final String DATE_MID = "2\\d{3}-[01]\\d{1}-[0-3]\\d{1}";
	// 日期格式 yyyy/mm/dd
	private static final String DATE_XIEXIAN = "2\\d{3}/[01]\\d{1}/[0-3]\\d{1}";
	// 日期格式 HH:mm:ss
	private static final String TIME = "[0-2]\\d:[0-5]\\d:[0-5]\\d";
	// 日期格式 HHmmss
	private static final String TIME_NO_MAOHAO = "[0-2]\\d[0-5]\\d[0-5]\\d";
	// 工作日为节假日
	private static final String WORKDAY_VACATION = "WORKDAY_VACATION";
	// 周末非工作日
	private static final String WEEKEND_NO_VACATION = "WEEKEND_NO_VACATION";

	/**
	 * 指定字符串日期添加
	 * 
	 * @param dateType
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addDateTime(DateTypeEnum dateType, String date, int amount) {
		if (StringUtils.isBlank(date)) {
			logger.info("日期不能为空");
			return null;
		}
		Date parseDate = parseDateTime(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(parseDate);
		cal.add(dateType.getCode(), amount);
		return cal.getTime();
	}

	/**
	 * 指定日期添加
	 * 
	 * @param dateType
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date addDateTime(DateTypeEnum dateType, Date date, int amount) {
		if (date == null) {
			logger.info("日期不能为空");
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(dateType.getCode(), amount);
		return cal.getTime();
	}

	/**
	 * 根据类型转换当前日期
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getDateTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date currentDate = new Date();
		return sdf.format(currentDate);
	}

	/**
	 * 根据类型转换日期
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getDateTime(Date date, String pattern) {
		if (date == null) {
			logger.info("日期不能为空");
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 转换当前日期为字符串[yyyy/MM/dd]
	 * 
	 * @return
	 */
	public static String getSlashDate() {
		SimpleDateFormat dateTime = new SimpleDateFormat("yyyy/MM/dd");
		return dateTime.format(new Date());
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 转换当前日期为没有分隔符的日期字符串[yyyyMMdd]
	 * 
	 * @return
	 */
	public static String getAllSNoSeparator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		Date currentDate = new Date();
		return sdf.format(currentDate);
	}

	/**
	 * 
	 * @Title: getAllSSeparator
	 * @Description:
	 * @param @return
	 * @return String
	 * @throws
	 * @author ji_xw@suixingpay.com
	 * @date 2016年12月12日 上午10:45:33
	 */
	public static String getAllSeparator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		return sdf.format(currentDate);
	}

	/**
	 * 转换当前日期为没有分隔符的日期字符串[yyyyMMdd]
	 * 
	 * @return
	 */
	public static String getDateNoSeparator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date currentDate = new Date();
		return sdf.format(currentDate);
	}

	/**
	 * 转换当前时间为没有分隔符的时间字符串[HHmmss]
	 * 
	 * @return
	 */
	public static String getTimeNoSeparator() {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		Date currentDate = new Date();
		return sdf.format(currentDate);
	}

	/**
	 * 
	 * @Title: getDateMonthNoSeparator
	 * @Description:
	 * @param @return
	 * @return String
	 * @throws
	 * @author ji_xw@suixingpay.com
	 * @date 2016年11月18日 上午10:41:01
	 */
	public static String getDateMonthNoSeparator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date currentDate = new Date();
		return sdf.format(currentDate);
	}

	/**
	 * 
	 * @Title: getDateYearNoSeparator
	 * @Description:
	 * @param @return
	 * @return String
	 * @throws
	 * @author ji_xw@suixingpay.com
	 * @date 2016年11月18日 上午10:41:05
	 */
	public static String getDateYearNoSeparator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date currentDate = new Date();
		return sdf.format(currentDate);
	}

	/**
	 * 转换当前日期为没有分隔符的日期字符串[yyyyMMdd]
	 * 
	 * @return
	 */
	public static String getDateNoSeparator(Date date) {
		if (date == null) {
			logger.info("日期不能为空");
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	/**
	 * 转换当前时间为没有分隔符的时间字符串[HHmmss]
	 * 
	 * @return
	 */
	public static String getTimeNoSeparator(Date date) {
		if (date == null) {
			logger.info("日期不能为空");
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(date);
	}

	/**
	 * 
	 * @Title: parseDateTimeByFormat
	 * @Description:转换String类型date
	 * @param @param date
	 * @param @param patternformat
	 * @param @return
	 * @return String
	 * @throws
	 * @author ji_xw@suixingpay.com
	 * @date 2016年12月14日 上午9:48:08
	 */
	public static String parseDateTimeByFormat(String date, String oldPatten, String patternformat) {
		if (StringUtils.isBlank(date)) {
			logger.info("传入日期为空");
			return null;
		}
		SimpleDateFormat oldsdf = new SimpleDateFormat(oldPatten);
		SimpleDateFormat sdf = new SimpleDateFormat(patternformat);
		try {
			Date dateTime = oldsdf.parse(date);
			String fmDate = sdf.format(dateTime);
			return fmDate;
		} catch (ParseException e) {
			logger.error("日期[" + patternformat + "]解析错误", e);
			return null;
		}
	}

	/**
	 * 解析日期字符串为日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseDateTime(String date) {
		if (StringUtils.isBlank(date)) {
			logger.info("传入日期为空");
			return null;
		}
		if (date.matches(FULL_DATE_TIME_MID)) {
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(FULL_DATE_TIME)) {
			String pattern = "yyyyMMdd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(FULL_DATE_TIME_XIEXIAN)) {
			String pattern = "yyyy/MM/dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(FULL_DATE_TIME_NO_MAOHAO)) {
			String pattern = "yyyyMMdd HHmmss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(FULL_DATE_TIME_NO_BLANK_NO_MAOHAO)) {
			String pattern = "yyyyMMddHHmmss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(FULL_DATE_TIME_MID_NO_MAOHAO)) {
			String pattern = "yyyy-MM-dd HHmmss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(FULL_DATE_TIME_XIEXIAN_NO_MAOHAO)) {
			String pattern = "yyyy/MM/dd HHmmss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(DATE_MID)) {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(DATE)) {
			String pattern = "yyyyMMdd";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(DATE_XIEXIAN)) {
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(TIME)) {
			String pattern = "HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		if (date.matches(TIME_NO_MAOHAO)) {
			String pattern = "HHmmss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				logger.error("日期[" + pattern + "]解析错误", e);
			}
		}
		logger.info("未找到匹配的日期格式");
		return null;
	}

	/**
	 * 
	 * @Title: transferDate
	 * @Description:获取指定月份的前6个月。例如:20170110就成为了(20160810)
	 * @param @param date
	 * @param @return
	 * @throws
	 * @author wu_hj
	 * @date 2017年1月07日 下午18:57:53
	 */
	public static String getAfterMonth(String CreatDate) {
		GregorianCalendar gc = new GregorianCalendar();
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			String dateString = formatter.format(currentTime);
			if (CreatDate.compareTo(dateString) > 0) {
				gc.setTime(currentTime);
				gc.add(2, -Integer.parseInt("6"));
			} else {
				Date s = formatter.parse(CreatDate);
				gc.setTime(s);
				gc.add(2, Integer.parseInt("6"));
				if (gc.getTime().after(currentTime)) {
					gc.setTime(currentTime);
					gc.add(2, -Integer.parseInt("6"));
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new SimpleDateFormat("yyyyMMdd").format(gc.getTime());
	}

	/**
	 * @description 获取指定日期的下一个工作日
	 * @param calendar
	 * @param workdayVacationList
	 * @param weekendNotVactionList
	 * @return
	 */
	private static String getNextWorkday(Calendar calendar, List<String> workdayVacationList, List<String> weekendNotVactionList) {
		String date = getDateNoSeparator(calendar.getTime());
		// 周末为工作日，则返回
		if (weekendNotVactionList.contains(date)) {
			logger.info("当前日期{}在节假日为工作日范围内", date);
			return date;
		}
		// 工作日为节假日，则日期继续加一
		if (workdayVacationList.contains(date)) {
			logger.info("当前日期{}在工作日为节假日范围内，继续获取下一个日期是否为工作日", date);
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			return getNextWorkday(calendar, workdayVacationList, weekendNotVactionList);
		}
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (Calendar.SUNDAY != dayOfWeek && Calendar.SATURDAY != dayOfWeek) {
			logger.info("当前日期{}为正常的工作日时间", date);
			// 正常工作日，则返回
			return date;
		}
		logger.info("当前日期{}为正常的节假日时间，继续获取下一个日期是否为工作日", date);
		// 正常周末，则日期继续往后递增
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return getNextWorkday(calendar, workdayVacationList, weekendNotVactionList);
	}

	// /===============================

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	public static Date getDateStart(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getDateEnd(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 判断字符串是否是日期
	 * 
	 * @param timeString
	 * @return
	 */
	public static boolean isDate(String timeString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try {
			format.parse(timeString);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 格式化时间
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String dateFormat(Date timestamp) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(timestamp);
	}

	/**
	 * 获取系统时间Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getSysTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 获取系统时间Date
	 * 
	 * @return
	 */
	public static Date getSysDate() {
		return new Date();
	}

	/**
	 * 生成时间随机数
	 * 
	 * @return
	 */
	public static String getDateRandom() {
		String s = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		return s;
	}

	/**
	 * 根据日期获取批次号
	 * 
	 * @return
	 */
	public static String getBatno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
		return sdf.format(new Date());
	}

	// 对比两个日期之间的天数值差
	public static int compareDaysStr(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(startDate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(endDate));
			long time2 = cal.getTimeInMillis();
			long between_days = (time1 - time2) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));

		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("两日期时间天数差计算异常："+e);
		}

		return -1;
		
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// System.out.println(formatDate(parseDate("2010/3/6")));
		// System.out.println(getDate("yyyy年MM月dd日 E"));
		// long time = new Date().getTime()-parseDate("2012-11-19").getTime();
		// System.out.println(time/(24*60*60*1000));
/*	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int days = DateUtils.compareDaysStr(df.format(new Date()).toString(), DateUtils.getDateTime(new  Date(), "yyyy-MM-dd"));
		System.out.println(days);*/
	}
}
