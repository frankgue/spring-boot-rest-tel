package com.gkfcsolution.springbootdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 2025 at 14:09
 * File: null.java
 * Project: spring-data-rest-demo-tel
 *
 * @author Frank GUEKENG
 * @date 01/08/2025
 * @time 14:09
 */
@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

 /*   @Before("execution(* com.gkfcsolution.springbootdemo.service.*.*(..))")
    public void logBeforeMethodExecution() {
        LOGGER.info("Method execution started");
    }*/

    @Before("execution(* com.gkfcsolution.springbootdemo.service.JobService.getJob(..)) || execution(* com.gkfcsolution.springbootdemo.service.JobService.getAllJobs(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        LOGGER.info("Method called " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.gkfcsolution.springbootdemo.service.JobService.getJob(..)) || execution(* com.gkfcsolution.springbootdemo.service.JobService.getAllJobs(..))")
    public void logAfterMethodExecutes(JoinPoint joinPoint) {
        LOGGER.info("Method Executed " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.gkfcsolution.springbootdemo.service.JobService.*(..))", throwing = "exception")
    public void logAfterThrowingException(JoinPoint joinPoint, Throwable exception) {
        LOGGER.error("Exception in method: " + joinPoint.getSignature().getName() + " with message: " + exception.getMessage());
    }

    @AfterReturning(pointcut = "execution(* com.gkfcsolution.springbootdemo.service.JobService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        LOGGER.info("Method Returning successfully " + joinPoint.getSignature().getName() + " returned with value: " + result);
    }
}
