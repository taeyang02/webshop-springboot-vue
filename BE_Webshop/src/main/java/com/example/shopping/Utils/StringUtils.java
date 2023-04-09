package com.example.shopping.Utils;

public class StringUtils {

    public static Boolean isNullOrEmpty(String s) {
        if (s == null) {
            return true;
        }else if (s.isBlank()) {
            return true;
        } else {
            return s.isEmpty();
        }
    }
}
