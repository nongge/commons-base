package cn.pinkhorizon.commons.base.enums;

import cn.pinkhorizon.commons.base.exception.ParamAnomalousException;

/**
 * @author yuanlei7
 * @date 2021/6/23
 * @apiNote 售卖状态
 */
public enum SaleStatus {
    /**
     * 待上架和已上架两种售卖状态
     */
    PREPARE(0, "待上架"), SELLING(1, "已上架");

    /**
     * 类型
     */
    private int type;

    /**
     * 描述
     */
    private String desc;

    SaleStatus(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static SaleStatus getEnum(int type) {
        SaleStatus[] enums = SaleStatus.values();
        for (SaleStatus e : enums) {
            if (e.getType() == type) {
                return e;
            }
        }
        throw new ParamAnomalousException("anomalous enum type for " + SaleStatus.class + "：" + type);
    }
}
