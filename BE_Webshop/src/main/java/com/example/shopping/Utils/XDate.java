package com.example.shopping.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String getToday(Date date) {
        return sdf.format(date);
    }
    public static Date getTodayDate(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
