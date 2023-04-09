package com.example.shopping.Utils;

//import jdk.vm.ci.meta.Local;

import org.joda.time.DateTime;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CommonUtils {

    public static boolean notEmpty(String var) {
        return var != null && var.length() > 0;
    }

    public static boolean empty(String var) {
        return var == null || var.length() == 0;
    }

    public static boolean notEmpty(Number var) {
        return null != var;
    }

    public static boolean empty(Number var) {
        return null == var;
    }

    public static boolean empty(Collection<?> var) {
        return null == var || var.isEmpty();
    }

    public static boolean notEmpty(Collection<?> var) {
        return null != var && !var.isEmpty();
    }

    public static boolean notEmpty(Map<?, ?> var) {
        return null != var && !var.isEmpty();
    }

    public static boolean notEmpty(File file) {
        return null != file && file.exists();
    }

    public static boolean empty(File file) {
        return null == file || !file.exists();
    }

    public static boolean notEmpty(Object[] var) {
        return null != var && 0 < var.length;
    }

    public static boolean empty(Object[] var) {
        return null == var || 0 == var.length;
    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static List getScheduleTime(String strDateTime,String zone ) {
        try {
            if (empty(strDateTime)) {
//                return DateTime.now();l
                return Arrays.asList(DateTime.now(),zone);
            } else {
                DateTime ScheduleTime = null;
                if(strDateTime.length()>16){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm xxx");
                    ZonedDateTime dt = ZonedDateTime.parse(strDateTime, formatter);
                    // ZoneId zone = dt.getZone();
                    Date date = new Date(dt.toInstant().toEpochMilli());
                    ScheduleTime = new DateTime(date);
                    zone= String.format("(%s) %s",dt.format(DateTimeFormatter.ofPattern("ZZZZ")),ScheduleTime.getZone().toString());
                }
                else{
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    Date date = simpleDateFormat.parse(strDateTime);
                    ScheduleTime = new DateTime(date);
                    zone= String.format("(GMT +07:00) %s",ScheduleTime.getZone().toString());
                }
                return Arrays.asList(ScheduleTime,zone);
            }
        } catch (Exception ex) {
            zone= String.format("(GMT +07:00) %s",DateTime.now().getZone().toString());
//            return DateTime.now();
            return Arrays.asList(DateTime.now(),zone);
        }

    }
}

