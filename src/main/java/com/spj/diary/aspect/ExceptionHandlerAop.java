package com.spj.diary.aspect;

import com.spj.diary.common.vo.SysResult;
import com.spj.diary.service.impl.MailService;
import org.apache.shiro.authz.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Objects;

@Aspect
@Component
public class ExceptionHandlerAop {
    private static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAop.class);

    @Resource
    private MailService mailService;

    @Around("execution(* com.spj.diary.controller..*(..))")
    public Object handler(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        String message = null;
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (UnauthorizedException e) {
            result = SysResult.build(201, "操作失败：没有操作权限！");
            e.printStackTrace();
        } catch (Throwable throwable) {
            // 记录日志
            String typeName = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            String methodNameAll = typeName +"." + methodName;
            LOGGER.error("Method Name:" + methodNameAll + "-Error Message:" + throwable.getMessage());
            LOGGER.error("堆栈信息", throwable);
            Signature signature = joinPoint.getSignature();
            Class returnType = ((MethodSignature) signature).getReturnType();
            String name = returnType.getName();
            if (Objects.equals(name, "java.util.Map")) {
                result = new HashMap<>();
            } else {
                result = SysResult.build(201, throwable.getMessage());
            }

            // 发送邮件
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            throwable.printStackTrace(pw);
           // mailService.sendMailThread(this.mailService,"songpeijiang@infosec.com.cn", "Error", sw.toString());
        }
        return result;
    }
}
