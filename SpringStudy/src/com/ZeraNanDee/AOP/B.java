package com.ZeraNanDee.AOP;

import org.springframework.stereotype.Component;

@Component//注解起效@Component(".....")里面的内容相当于bean的id，起个id名
public class B implements A {

	int result;
	@Override
	public int add(int i, int j) {
		result=i+j;
		return result=i+j;
	}

	@Override
	public int sub(int i, int j) {
		result=i-j;
		return result;

	}

	@Override
	public int mul(int i, int j) {
		result=i*j;
		return result;

	}

	@Override
	public int div(int i, int j) {
		result=i/j;
		return result;

	}

}
