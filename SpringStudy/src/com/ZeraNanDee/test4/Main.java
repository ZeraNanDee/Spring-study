package com.ZeraNanDee.test4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conf-Instance.xml");
		Girfriend girfriend = (Girfriend) context.getBean("girfriend");
		System.out.println(girfriend);
		context.close();// 关闭IOC容器，这是在ClassPathXmlApplicationContext里面，而它的父类就是ApplicationContext
	}

}
