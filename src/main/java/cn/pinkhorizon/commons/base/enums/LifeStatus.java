package cn.pinkhorizon.commons.base.enums;

import cn.pinkhorizon.commons.base.exception.ParamInvalidException;

/**
 * @author yuanlei7
 * @date 2021/6/15
 * @apiNote 生命状态枚举
 */
public enum LifeStatus {
    /**
     * 两种的对立的生命状态
     */
    SURVIVAL(0, "生存"), DEATH(1, "死亡");

    /**
     * 类型
     */
    private int type;

    /**
     * 描述
     */
    private String desc;

    LifeStatus(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static LifeStatus getEnum(int type) {
        LifeStatus[] enums = LifeStatus.values();
        for (LifeStatus e : enums) {
            if (e.getType() == type) {
                return e;
            }
        }
        throw new ParamInvalidException("invalid enum type for " + LifeStatus.class + "：" + type);
    }
}
