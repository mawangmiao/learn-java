package com.example.demo;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAdviceTest {

    @AfterReturning(returning="rvt",pointcut="execution(* com.example.*.*(..))")
    public void log(Object rvt){
        System.out.println("获取目标方法返回值："+rvt);
        System.out.println("模拟记录日志的功能...");
    }

}
