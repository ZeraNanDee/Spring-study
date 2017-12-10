package com.ZeraNanDee.test1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		sayhellowithnoargs();
//		sayhellowithargs();
//		HelloWorldStaticFactory();
		HelloWorldInstanceFactory();
	}
   public static void sayhellowithnoargs() {
	@SuppressWarnings("resource")//使用无参构造函数实例化Bean
	BeanFactory beanFactory=new ClassPathXmlApplicationContext("conf-Instance.xml");
	HelloWorld helloWorld=(HelloWorld) beanFactory.getBean("helloworldwithnoargs");
	helloWorld.sayhello();
}
   public static void sayhellowithargs() {
		@SuppressWarnings("resource")//使用有参构造函数实例化Bean
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("conf-Instance.xml");
		HelloWorld helloWorld=(HelloWorld) beanFactory.getBean("helloworldwithargs");
		helloWorld.sayhello();
	}
   
   public static void HelloWorldStaticFactory() {
 		@SuppressWarnings("resource")//JAVA反射机制面向接口编程，静态bean工厂的实例化
 		BeanFactory beanFactory=new ClassPathXmlApplicationContext("conf-Instance.xml");
 		HelloWorld helloWorld=(HelloWorld) beanFactory.getBean("helloworldstaticfactory");
 		helloWorld.sayhello();
 	}
   
   public static void HelloWorldInstanceFactory() {
		@SuppressWarnings("resource")//调用bean工厂实例化的bean
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("conf-Instance.xml");
		HelloWorld helloWorld=(HelloWorld) beanFactory.getBean("helloworldInstance");
		helloWorld.sayhello();
	}
}
