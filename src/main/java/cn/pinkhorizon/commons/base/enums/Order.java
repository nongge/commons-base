package cn.pinkhorizon.commons.base.enums;

import cn.pinkhorizon.commons.base.exception.ParamInvalidException;

/**
 * @author yuanlei7
 * @date 2021/6/15
 * @apiNote 排序方式
 */
public enum Order {
    /**
     * 两种排序方式
     */
    ASC(0, "升序"), DESC(1, "降序");

    /**
     * 类型
     */
    private int type;

    /**
     * 描述
     */
    private String desc;

    Order(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static Order getEnum(int type) {
        Order[] enums = Order.values();
        for (Order e : enums) {
            if (e.getType() == type) {
                return e;
            }
        }
        throw new ParamInvalidException("invalid enum type for " + Order.class + "：" + type);
    }
}
