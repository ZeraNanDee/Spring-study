package com.ZeraNanDee.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ZeraNanDee.annotation.service.UserService;

@Controller
public class UserController {// 模拟表现层
	@Autowired // 通过此自动装配的注解，自动装配UserService bean属性
	private UserService service;

	public void execute() {
		System.out.println("UserController execute....");
		service.add();
	}
}
