package com.example.sample.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggerAspect {
	@Around("execution(* com.example.sample.controller.*Controller.*(..)) || execution(* com.example.sample.service.*ServiceImpl.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		String type = "";
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		String name = joinPoint.getSignature().getName();

		if (typeName.contains("Controller")) {
			type = "Controller: ";
		}
		else if (typeName.contains("Service")) {
			type = "Service: ";
		}

		log.debug(type + typeName + "." + name + "()");
		return joinPoint.proceed();
	}
}
