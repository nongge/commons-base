package cn.pinkhorizon.commons.base.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ybf
 * @description redis分布式锁注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisLock {
    /**
     * lock锁的键key
     * @return
     */
    String value() default "redis_lock_key";

    /**
     * 锁过期时间毫秒值
     * @return
     */
    int expireMillisecond() default 2000;

    /**
     * 轮询时间毫秒值
     * @return
     */
    int pollingMillisecond() default 500;

    /**
     * 最大等待时间毫秒值
     * @return
     */
    int waitMillisecond() default 4000;
}
