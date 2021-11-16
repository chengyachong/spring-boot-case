package com.dfe.sp.common.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NewDateUtils {
    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_HMS = "HH:mm:ss";
    public static final String DATE_FORMAT_HM = "HH:mm";
    public static final String DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_YMDHMS = "yyyyMMddHHmmss";


    public static LocalDateTime string2LocalDateTime(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime date = LocalDateTime.parse(dateStr,formatter);
        return date;
    }

    public static String localDateTime2String(LocalDateTime date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static long getTimeSeconds(LocalDateTime date) {
        return date.toInstant(ZoneOffset.UTC).toEpochMilli()/1000;
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        return date.toInstant()
                .atZone( ZoneId.systemDefault() )
                .toLocalDateTime();
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }
    public static Date localDate2Date(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate string2LocalDate(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate date = LocalDate.parse(dateStr,formatter);
        return date;
    }

    public static String localDate2String(LocalDate date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }
}
