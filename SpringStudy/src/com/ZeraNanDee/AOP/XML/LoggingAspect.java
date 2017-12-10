package com.ZeraNanDee.AOP.XML;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

public class LoggingAspect {
	

public void before(JoinPoint joinpoint) {
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
	System.out.println("the method "+methodName+"  begins with"+args);
		
}

	public void after(JoinPoint joinpoint) {
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("the method "+methodName+" ends  with"+args);
	}
	

	public void afterReturning(JoinPoint joinpoint,Object result) {
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("the method "+methodName+" ends with  "+result);
	}
	
	
	public void afterThrowing(JoinPoint joinpoint,Exception ex) {
		String methodName=joinpoint.getSignature().getName();
		List<Object> args=Arrays.asList(joinpoint.getArgs());
		System.out.println("the method "+methodName+"throw out  "+ex);
	}
}
