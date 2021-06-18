package cn.pinkhorizon.commons.base.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.*;

/**
 * @author ybf
 * @description 字符串工具类
 */
public class StringUtils {

    private static final String REG_START_SPACE = "^[　 ]*";
    private static final String REG_END_SPACE = "[　 ]*$";

    /**
     * 判断字符串是否为空
     */
    public static Boolean isEmpty(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为空
     */
    public static Boolean isEmptyAll(String... ss) {
        for (String s : ss) {
            if (!isEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否为空
     */
    public static Boolean isEmptyAll(List<String> ss) {
        for (String s : ss) {
            if (!isEmpty(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否为是空白字符串
     */
    public static Boolean isBlank(String s) {
        return isEmpty(trimAll(s));
    }

    /**
     * 判断字符串是否是纯数字
     */
    public static boolean isNumber(String s) {
        Pattern pattern = compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(s).matches();
    }

    /**
     * 判断字符串是否符合日期格式
     */
    public static boolean isFormatDate(String s) {
        Pattern pattern = compile("^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\\s(0[0-9]|1[0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]$");
        return pattern.matcher(s).matches();
    }

    /**
     * 去掉字符串首尾空格
     */
    public static String trim(String s) {
        return s.replaceAll(REG_START_SPACE, "").replaceAll(REG_END_SPACE, "");
    }

    /**
     * 去掉字符串中所有空格
     */
    public static String trimAll(String s) {
        return s.replaceAll("\\s*", "");
    }

    /**
     * 将字符串集合转换成用英文逗号连接的字符串
     */
    public static String stringList2String(List<String> stringList) {
        if (stringList == null || stringList.size() == 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (String s : stringList) {
            sb.append(s).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * 将字符串按照逗号分割转成一个字符串集合
     */
    public static List<String> string2StringList(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        String[] ss = s.split("\\,");
        return Arrays.asList(ss);
    }
}