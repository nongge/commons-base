package cn.pinkhorizon.commons.base.exception;

/**
 * @author ybf
 * @description 校验异常类
 */
public class VerificationException extends RuntimeException {

    public VerificationException() {
        super("校验未通过");
    }

    public VerificationException(String message) {
        super(message);
    }
}