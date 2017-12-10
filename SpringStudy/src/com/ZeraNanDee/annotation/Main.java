package com.ZeraNanDee.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ZeraNanDee.annotation.controller.UserController;
import com.ZeraNanDee.annotation.repository.UserRepository;
import com.ZeraNanDee.annotation.service.UserService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans-annotation.xml");
//		TestObject object=(TestObject) applicationContext.getBean("testObject");
//		System.out.println(object);
//		
		UserController controller=(UserController) applicationContext.getBean("userController");
		System.out.println(controller);
		controller.execute();
//		
//		UserService service=(UserService) applicationContext.getBean("userService");
//		System.out.println(service);
//		
//		UserRepository userRepository=(UserRepository) applicationContext.getBean("userRepository");
//		System.out.println(userRepository);
		

	}

}
