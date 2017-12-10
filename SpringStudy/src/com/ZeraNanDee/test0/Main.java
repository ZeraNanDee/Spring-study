package com.ZeraNanDee.test0;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static ApplicationContext applicationContext;//这个类是Spring IOC容器的使用
    //ApplicationContext是由BeanFactory派生而来，是其子类，多了一些方法，例如：
	//1.ApplicationContext有多了监控和事件机制，ContextRefreshedEvent：bean全部类加载完，
	//有相关相应事件，同时更容易看出bean文件配置错误，bean生命周期的启动停止销毁
	//2.利用MessageSource进行国际化  
	//3.底层资源的访问 ，扩展了ResourceLoader(资源加载器)接口，从而可以用来加载多个Resource
	//4.对Web应用的支持  
	public static void main(String[] args) {
		//applicationContext = new ClassPathXmlApplicationContext("hellobean.xml");
		@SuppressWarnings("resource")
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("hellobean.xml");//,beanfactory是类管理器，管理bean
		HelloBean student;
		student=(HelloBean)beanFactory.getBean("stu1");
		System.out.println("姓名："+student.getName()+"课程："+student.getCourse()+"成绩："+student.getScore());
	}

}
