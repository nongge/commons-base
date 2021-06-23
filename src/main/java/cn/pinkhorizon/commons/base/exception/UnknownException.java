package cn.pinkhorizon.commons.base.exception;

/**
 * @author ybf
 * @description 未知异常类
 */
public class UnknownException extends RuntimeException{

    public UnknownException() {
        super("系统异常");
    }

    public UnknownException(String message) {
        super(message);
    }
}
