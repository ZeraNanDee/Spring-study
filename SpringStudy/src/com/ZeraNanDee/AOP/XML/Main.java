package com.ZeraNanDee.AOP.XML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//1.创建Spring IOC的容器
		 ApplicationContext context=new ClassPathXmlApplicationContext("aop-xml.xml");
		//2.从IOC容器中获取bean实例
		A a=(A) context.getBean(A.class);
		
		//3.使用bean
		int result=a.add(3, 6);
		System.out.println("结果是"+result);

		result=a.mul(4,5);
		System.out.println("结果是"+result);
		
		result=a.sub(6,5);
		System.out.println("结果是"+result);

		result=a.div(3,1);
		System.out.println("结果是"+result);
	}

}
