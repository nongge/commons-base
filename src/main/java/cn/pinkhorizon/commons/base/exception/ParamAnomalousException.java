package cn.pinkhorizon.commons.base.exception;

/**
 * @author yuanlei7
 * @apiNote 参数异常非法
 */
public class ParamAnomalousException extends RuntimeException {
    public ParamAnomalousException() {
        super("参数非法异常");
    }

    public ParamAnomalousException(String message) {
        super(message);
    }
}
