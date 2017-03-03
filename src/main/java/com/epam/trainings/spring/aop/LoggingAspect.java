package com.epam.trainings.spring.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Log
public class LoggingAspect {

    @Pointcut("execution(* *service.*(..))")
    public void serviceMethod() {
    }

    @Around("serviceMethod()")
    public Object logWebServiceCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        log.fine(() -> String.format("Call method %s with args %s", methodName, methodArgs));

        Object result = thisJoinPoint.proceed();

        log.fine(() -> String.format("Method %s returns %s", methodName, result));
        return result;
    }
}
