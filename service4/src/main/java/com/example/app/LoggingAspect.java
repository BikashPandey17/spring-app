package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(LogMethodParam)")
    public Object logMethodParam(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        List<String> st = List.of("a", "b");
        ArrayList<String> al = new ArrayList<>();


        return joinPoint.proceed();
    }
}