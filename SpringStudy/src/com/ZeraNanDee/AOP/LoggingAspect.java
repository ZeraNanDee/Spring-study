package com.ZeraNanDee.AOP;

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


//把这个类声明为一个切面，需要把该类放到IOC容器当中,在声明为一个切面
@Aspect//切面工具的注解
@Component//切面是Spring ioc容器的bean，也要加入Component实例化一遍
public class LoggingAspect {
	
	//定义一个方法，声明切入点表达式，使用@Pointcut声明切入点表达式,一般该方法不需要引入其他代码
	@Pointcut("execution(public int com.ZeraNanDee.AOP.B.*(..))")
	public void JoinPoint() {}
	
	//声明该方法是一个前置通知
	@Before("JoinPoint()")
public void before(JoinPoint joinpoint) {//设置连接点
		String methodName=joinpoint.getSignature().getName();//获取连接点的方法签名对象的方法名
		List<Object> args=Arrays.asList(joinpoint.getArgs());//获取连接点方法运行时的入参列表和参数值
	System.out.println("the method "+methodName+"  begins with"+args);
		
}
	//声明该方法是一个后置通知,无论方法是否出现异常都会执行
	@After("execution(public int com.ZeraNanDee.AOP.B.*(..))")// *代表在此类中所有方法起效
	public void after(JoinPoint joinpoint) {
		String methodName=joinpoint.getSignature().getName();//获取连接点的方法签名对象的方法名
		List<Object> args=Arrays.asList(joinpoint.getArgs());//获取连接点方法运行时的入参列表和参数值
		System.out.println("the method "+methodName+" ends  with"+args);
	}
	
	//声明该方法是一个返回通知,在方法正常执行后返回的通知,返回通知是可以返回到方法的返回值的！
	@AfterReturning(value="JoinPoint()",returning="result")
	public void afterReturning(JoinPoint joinpoint,Object result) {
		String methodName=joinpoint.getSignature().getName();//获取连接点的方法签名对象的方法名
		List<Object> args=Arrays.asList(joinpoint.getArgs());//获取连接点方法运行时的入参列表和参数值
		System.out.println("the method "+methodName+" ends with  "+result);
	}
	
	//声明该方法是一个异常通知，在该方法出异常的情况下才会被
	@AfterThrowing(value="JoinPoint()",throwing="ex")
	public void afterThrowing(JoinPoint joinpoint,Exception ex) {
		String methodName=joinpoint.getSignature().getName();//获取连接点的方法签名对象的方法名
		List<Object> args=Arrays.asList(joinpoint.getArgs());//获取连接点方法运行时的入参列表和参数值
		System.out.println("the method "+methodName+"throw out  "+ex);
	}
}
