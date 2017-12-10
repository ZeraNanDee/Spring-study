package com.ZeraNanDee.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ZeraNanDee.annotation.repository.UserRepository;

@Service
public class UserService {// 业务层service
	@Autowired//再指定的IOC容器中，可以放在构造器上面,也可以放在setter方法上面,也可以放在bean上面
	private UserRepository repository;
	public void add() {
		System.out.println("UserService add.....");
		repository.save();
	}
}
