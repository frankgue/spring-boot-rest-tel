package com.gkfcsolution.springbootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 2025 at 17:08
 * File: null.java
 * Project: spring-boot-demo
 *
 * @author Frank GUEKENG
 * @date 01/08/2025
 * @time 17:08
 */
@Component
@Aspect
public class PerformanceMonitoringAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.gkfcsolution.springbootdemo.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long start = System.currentTimeMillis();

    Object obj = proceedingJoinPoint.proceed();

    long end = System.currentTimeMillis();

    LOGGER.info("Execution time take by {} is {} ms", proceedingJoinPoint.getSignature().getName(), (end - start));

    return obj;
    }
}
