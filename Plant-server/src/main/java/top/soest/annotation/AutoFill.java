package top.soest.annotation;

import top.soest.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * 自定义注解
 */

@Target(ElementType.METHOD) //加载在什么上
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface AutoFill
{
    // 数据库操作类型
    OperationType value();
}
