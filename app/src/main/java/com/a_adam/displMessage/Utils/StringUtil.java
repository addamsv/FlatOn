package com.a_adam.displMessage.Utils;


public class StringUtil {
    public static final String EMPTY_STR = "";

    public static boolean isEmpty(String str) {
        if (str != null) {
            return EMPTY_STR.equals(str);
        }
        return true;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        if (isNotEmpty(str)) {
            return EMPTY_STR.equals(str.trim());
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String capitalizeFirstLetter(String str) {
        if(isBlank(str)) {
            str="";
            return str;
        }
        Character firstChar = str.charAt(0);
        Character firstCapitalChar = Character.toUpperCase(firstChar);
        String result = firstCapitalChar + str.substring(1);
        return result;
    }

    public static boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
