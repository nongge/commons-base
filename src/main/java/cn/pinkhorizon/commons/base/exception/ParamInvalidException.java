package cn.pinkhorizon.commons.base.exception;

/**
 * @author 袁彬峰
 * @description 参数无效异常
 */
public class ParamInvalidException extends RuntimeException {

    public ParamInvalidException() {
        super("无效的参数");
    }

    public ParamInvalidException(String message) {
        super(message);
    }
}
