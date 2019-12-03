package com.zhhe.webshop.filter;

import com.zhhe.webshop.bean.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *Author:ZouHeng
 *Des:
 *Date:2019-11-15  17:34
 */
@Aspect
@Component
@Slf4j
public class AdminAspect
{
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(Power)")
    public void logPoinCut() {
    }

    //切面，配置通知
    @Before("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) throws IOException
    {
        //用户名
        //从session中获取用户名
        Object result = null;
        String targetName = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("----------------执行方法-----------------");
        log.info("类名："+targetName+" 方法名："+methodName);
        HttpServletResponse response = null;
        for (Object param : joinPoint.getArgs()) {
            if (param instanceof HttpServletResponse) {
                response = (HttpServletResponse) param;
            }
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user= (User) request.getSession().getAttribute("user");
//        System.out.println(user);
        if (user==null||!user.getIsadmin())
        {
//            System.out.println((response==null));
            response.sendRedirect("/fore/index");
        }
    }
}
