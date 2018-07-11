package com.lchml.test.dubbo.sleuth;

import brave.Tracing;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lc on 2018/07/03.
 */
@Aspect
@Component
public class TestFilter {

    public TestFilter() {
        System.out.println("Test filter init ......................");
    }

    @Pointcut("execution(* com.lchml.test.dubbo.sleuth.LocalBean.test(..))")
    private void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("hit");
        return jp.proceed();
    }
}
