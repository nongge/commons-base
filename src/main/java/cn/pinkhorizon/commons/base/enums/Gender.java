package cn.pinkhorizon.commons.base.enums;

import cn.pinkhorizon.commons.base.exception.ParamInvalidException;

/**
 * @author ybf
 * @description 性别枚举
 */
public enum Gender {
    /**
     * 整个项目基于本common为基础，提供有基础规范
     * 当前枚举类为性别枚举，分三种状态女、男、隐藏这三种
     */
    FEMALE(0, "女性"), MALE(1, "男性"), HIDDEN(2, "隐藏");

    /**
     * 类型
     */
    private int type;

    /**
     * 描述
     */
    private String desc;

    Gender(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static Gender getEnum(int type) {
        Gender[] enums = Gender.values();
        for (Gender e : enums) {
            if (e.getType() == type) {
                return e;
            }
        }
        throw new ParamInvalidException("invalid enum type for " + Gender.class + "：" + type);
    }
}
