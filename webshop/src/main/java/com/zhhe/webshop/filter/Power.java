package com.zhhe.webshop.filter;

import java.lang.annotation.*;

/*
 *Author:ZouHeng
 *Des:自定义权限注解
 * 注：所有使该注解的函数都应该携带HttpServletResponse的参数，该参数用于Aspect中的重定向功能
 *Date:2019-11-15  17:29
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface Power
{
}
