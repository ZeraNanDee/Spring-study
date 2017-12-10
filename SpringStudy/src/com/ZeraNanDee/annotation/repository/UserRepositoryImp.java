package com.ZeraNanDee.annotation.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
//当有一个以上类实现了UserRepository接口时,设置属性名("...")只调用其中一个实现类，@Autowired就不会报错
//也可以在@Autowired下面@Qualifier（"userService"）指定某个要实例的bean类
public class UserRepositoryImp implements UserRepository {//模拟持久层

	@Override
	public void save() {
		System.out.println("UserRepository save ....");
		
	}

}
