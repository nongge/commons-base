package cn.pinkhorizon.commons.base.annotation;

import cn.pinkhorizon.commons.base.enums.Permanence;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ybf
 * @description 方法日志注解
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiLog {
    /**
     * 用户自定义选择记录方式，可选择一个或多个
     * 默认是控制台输出一种方式，如果用户配置此属性则按照用户配置进行
     */
    Permanence[] value() default Permanence.CONSOLE;
}