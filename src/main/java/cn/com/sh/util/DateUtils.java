package cn.com.sh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class DateUtils {

	private DateUtils() {
	}

	/**
	 * 解析字符串根据日期格式
	 */
	public static Date parse(final String format, final String date) throws ParseException {
		if (date == null) {
			return null;
		}
		SimpleDateFormat fmt = getDateFormat(format);
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			ParseException ex = new ParseException(e.getMessage() + " - expected '" + format + '\'', e.getErrorOffset());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

	/**
	 * 格式字符串的日期
	 */
	public static String format(final String format, final Date d) {
		if (d == null) {
			return null;
		}
		return getDateFormat(format).format(d);
	}

	private static final ThreadLocal<ConcurrentMap<String, SimpleDateFormat>> locals = new ThreadLocal<ConcurrentMap<String, SimpleDateFormat>>();

	/**
	 * 定位线程本地格式化程序给定类型的日期格式。这是安全的 只供调用线程使用
	 */
	public static SimpleDateFormat getDateFormat(final String format) {
		ConcurrentMap<String, SimpleDateFormat> map = locals.get();
		if (map == null) {
			map = new ConcurrentHashMap<String, SimpleDateFormat>();
			locals.set(map);
		}
		SimpleDateFormat df = map.get(format);
		if (df == null) {
			df = new SimpleDateFormat(format);
			map.put(format, df);
		}
		return df;
	}

	/**
	 * 改变一个特定日历日期的字段偏移量
	 */
	public static Date add(final Date date, final int field, final int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);
		return cal.getTime();
	}
}
