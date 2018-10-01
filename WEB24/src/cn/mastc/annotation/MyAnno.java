package cn.mastc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: X_JinL
 * @Description:
 * @Date: Created in 14:38 2018/10/1
 * @Modified By:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    // 注解的属性
    String name();

    int age() default 18;
    // String value();
    // String[] value();
}
