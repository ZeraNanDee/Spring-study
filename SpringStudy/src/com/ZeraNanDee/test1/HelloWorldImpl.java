package com.ZeraNanDee.test1;
//普通bean构造器实例化
public class HelloWorldImpl implements HelloWorld {
	private String message;

	public HelloWorldImpl() {//默认的无参的构造函数
		this.message = "Hello,World";
	}

	public HelloWorldImpl(String message) {//有参的构造函数
		this.message = message;
	}

	@Override
	public void sayhello() {
		System.out.println(message);

	}

}
