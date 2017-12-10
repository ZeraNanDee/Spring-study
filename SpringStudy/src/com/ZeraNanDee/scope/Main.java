package com.ZeraNanDee.scope;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {//Bean的5种作用域，singleton（只会实例化一次bean）,prototype(每次getBean（）都会实例化bean),request,session,global session

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		BeanFactory beanFactory=new ClassPathXmlApplicationContext("conf-scope.xml");
		Boss boss1=(Boss) beanFactory.getBean("boss1");
		Boss boss2=(Boss) beanFactory.getBean("boss2");
		Boss boss3=(Boss) beanFactory.getBean("boss3");
	    System.out.println(boss1.getCar());//singleton全部只会得到一个car的地址，因为XML中的car是单一实例化，而boss只相当于他对象
	    System.out.println(boss2.getCar());//prototype则是会为每个boss对象创建新的car实例，所以分配的地址都不同
	    System.out.println(boss3.getCar());//JVM返回控制台的是8位16进制（32位2进制）

	}

}
