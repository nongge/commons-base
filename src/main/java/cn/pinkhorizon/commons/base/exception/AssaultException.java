package cn.pinkhorizon.commons.base.exception;

/**
 * @author ybf
 * @description 非法入侵攻击异常
 */
public class AssaultException extends RuntimeException {

    public AssaultException() {
        super("系统检测到恶意行为");
    }

    public AssaultException(String message) {
        super(message);
    }
}
