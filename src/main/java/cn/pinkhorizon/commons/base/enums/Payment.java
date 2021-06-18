package cn.pinkhorizon.commons.base.enums;

import cn.pinkhorizon.commons.base.exception.ParamInvalidException;

/**
 * @author 袁彬峰
 * @description 付款方式
 */
public enum Payment {
    /**
     * 整个项目基于本common为基础，提供有基础规范，当前为支付方式枚举
     * 当前枚举有六种列举，在线交易当中，默认支付方式为1（余额支付）
     * 余额支付可以给出随机返利小红包的机制吸引用户，余额支付前几单加大返利力度
     */
    CASH(0, "线下支付"),
    credit(1, "白条支付"),
    BALANCE(2, "余额支付"),
    WECHAT(3, "微信支付"),
    ALIPAY(4, "支付宝支付"),
    UNION_PAY(5, "银联支付"),
    VISA(6, "visa信用卡支付");

    /**
     * 类型
     */
    private int type;

    /**
     * 描述
     */
    private String desc;

    Payment(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static Payment getEnum(int type) {
        Payment[] enums = Payment.values();
        for (Payment e : enums) {
            if (e.getType() == type) {
                return e;
            }
        }
        throw new ParamInvalidException("invalid enum type for " + Payment.class + "：" + type);
    }
}
