package com.gkfcsolution.springbootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 2025 at 17:58
 * File: null.java
 * Project: spring-boot-demo
 *
 * @author Frank GUEKENG
 * @date 01/08/2025
 * @time 17:58
 */
@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.gkfcsolution.springbootdemo.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint proceedingJoinPoint, int postId) throws Throwable {
        if (postId < 0) {
            LOGGER.error("Invalid postId: {}", postId);
            postId = -postId;
            LOGGER.error("New value postId: {}", postId);
        }
        return proceedingJoinPoint.proceed(new Object[]{postId});
    }
}
