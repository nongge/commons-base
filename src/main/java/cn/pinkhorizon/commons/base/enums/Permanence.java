package cn.pinkhorizon.commons.base.enums;

import cn.pinkhorizon.commons.base.exception.ParamAnomalousException;
import cn.pinkhorizon.commons.base.exception.ParamInvalidException;

/**
 * @author ybf
 * @description 持久化方式
 */
public enum Permanence {
    /**
     * 该枚举用于需要记录的的注解属性或配置中，用户可以自定义选择一个或多个选项，一般给出默认选择为控制台输出记录方式
     */
    CONSOLE(0, "控制台输出"), DISC(1, "本地磁盘"), DATABASE(2, "数据库");

    /**
     * 类型
     */
    private int type;

    /**
     * 描述
     */
    private String desc;

    Permanence(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static Permanence getEnum(int type) {
        Permanence[] enums = Permanence.values();
        for (Permanence e : enums) {
            if (e.getType() == type) {
                return e;
            }
        }
        throw new ParamAnomalousException("anomalous enum type for " + Permanence.class + "：" + type);
    }
}
