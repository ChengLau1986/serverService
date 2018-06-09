package com.lzapi.controller.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by lc on 2018/4/7.
 */
@Aspect
@Component
@Slf4j
public class logRecord {

    @Pointcut("@annotation(com.lzapi.controller.common.annotation.LogDesc)")
    public  void  log(){
    }

    @AfterReturning( value = "log()",argNames = "joinPoint,result",returning = "result")
    public  void  logAfterReturn(JoinPoint joinPoint, Object result) throws InterruptedException {
//        Class<?> base = joinPoint.getTarget().getClass();
//        LogDesc logDesc = base.getAnnotation(LogDesc.class);

        //获得返回注释方法连接点签名，获得注释数据
//        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
//        LogDesc logDesc = ms.getMethod().getAnnotation(LogDesc.class);
//        String mark = logDesc.businessLogic() + logDesc.actionType();
//
//        User user = (User) resultMsg.getResult();
        log.info("测试拦截");
    }
}
