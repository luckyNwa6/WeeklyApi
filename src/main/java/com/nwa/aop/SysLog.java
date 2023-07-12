package com.nwa.aop;

import java.lang.annotation.*;

//自定义注解类
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String operationType() default "";    //操作人

    String operationName() default "";    //操作名称

    String value() default "";            //状态
}
