package cn.pinkhorizon.commons.base.util;

import java.util.Random;

/**
 * @author ybf
 * @description 验证码生成工具类
 */
public class CheckCodeUtils {

    private static final int MAX_NUMBER = 10;

    private static final Random RANDOM = new Random();

    /**
     * 生成四位数字型随机验证码
     */
    public static String generate4Number() {
        return generateNumberCheckCode(4);
    }

    /**
     * 生成六位数字型随机验证码
     */
    public static String generate6Number() {
        return generateNumberCheckCode(6);
    }

    /**
     * 生成4位字符验证码
     */
    public static String generate4Char() {
        return generateCheckCodeString(4);
    }

    /**
     * 生成6位字符验证码
     */
    public static String generate6Char() {
        return generateCheckCodeString(6);
    }

    private static String generateNumberCheckCode(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= length; i++) {
            sb.append(RANDOM.nextInt(MAX_NUMBER));
        }
        return sb.toString();
    }

    private static String generateCheckCodeString(int length) {
        return Integer.toHexString(RANDOM.nextInt()).substring(0, length);
    }
}