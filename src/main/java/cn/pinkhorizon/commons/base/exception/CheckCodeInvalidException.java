package cn.pinkhorizon.commons.base.exception;

/**
 * @author 袁彬峰
 * @description 验证码无效异常
 */
public class CheckCodeInvalidException extends RuntimeException {

    public CheckCodeInvalidException() {
        super("无效的验证码");
    }

    public CheckCodeInvalidException(String message) {
        super(message);
    }
}