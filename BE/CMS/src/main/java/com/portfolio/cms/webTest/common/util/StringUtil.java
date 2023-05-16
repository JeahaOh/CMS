package com.portfolio.cms.webTest.common.util;

public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str == null) return true;
        else if (str.trim().equals("")) return true;
        else if (str.trim().length() == 0) return true;
        else return false;
    }
    
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
