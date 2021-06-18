package cn.pinkhorizon.commons.base.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ybf
 * @description 日期工具类
 */
public class DateUtils {

    private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format() {
        return FORMAT.format(new Date());
    }

    public static String format(Date date) {
        return FORMAT.format(date);
    }

    public static Date getDate() {
        return new Date();
    }

    public static Date getDate(Long timeMillis) {
        return new Date(timeMillis);
    }

    public static Date getDate(Timestamp timestamp) {
        return new Date(timestamp.getTime());
    }

    public static Date getDate(Integer year, Integer month, Integer day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

    public static Date getDate(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer seconds) {
        return new GregorianCalendar(year, month, day, hour, minute, seconds).getTime();
    }

    public static Date getDate(String s) throws ParseException {
        return FORMAT.parse(s);
    }

    public static Date getTodayStart() {
        return getInstance().getTime();
    }

    public static Date getTomorrowStart() {
        Calendar c = getInstance();
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    private static Calendar getInstance() {
        Calendar c = getCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c;
    }

    private static Calendar getCalendar() {
        return Calendar.getInstance();
    }
}