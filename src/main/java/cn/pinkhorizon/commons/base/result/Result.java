package cn.pinkhorizon.commons.base.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

/**
 * @author ybf
 * @description 非分页查询统一返回格式对象
 */
@JsonPropertyOrder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    /**
     * SerializerId
     */
    private static final long serialVersionUID = -6524954814444411899L;

    /**
     * 服务器成功执行请求
     */
    public static final int SUCCESS = 200;

    /**
     * 请求无效
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 未授权，ACL禁止访问资源
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 禁止可执行的访问
     */
    public static final int FORBIDDEN = 403;

    /**
     * 无法找到文件
     */
    public static final int NOT_FOUND = 404;

    /**
     * 请求方式错误
     */
    public static final int METHOD_NOT_ALLOW = 405;

    /**
     * 服务器内部错误
     */
    public static final int UNKNOWN_ERROR = 500;

    /**
     * 未实现
     */
    public static final int UNREALIZED = 501;

    /**
     * 未通过网关，网关检测错误
     */
    public static final int GATEWAY_ERROR = 502;

    /**
     * 服务器暂时不可用，暂停维护中
     */
    public static final int SERVICE_UNAVAILABLE = 503;

    /**
     * 数据检测不通过
     */
    public static final int VERIFY_FAIL = 520;

    /**
     * 无效的参数
     */
    public static final int INVALID_PARAM = 521;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回描述信息
     */
    private String message;

    /**
     * 返回其他数据
     */
    private T data;

    private Result() {

    }

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static Result SUCCESS() {
        return SUCCESS("操作成功");
    }

    public static Result SUCCESS(String message) {
        return SUCCESS(message, null);
    }

    public static <T> Result<T> SUCCESS(String message, T data) {
        return OTHER(SUCCESS, message, data);
    }

    public static <T> Result<T> OTHER(int code, String message, T data) {
        return new Result<T>(code, message, data);
    }
}