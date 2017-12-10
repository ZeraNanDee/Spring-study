package com.ZeraNanDee.test1;

public class HelloWorldInstanceFactory {
	   public HelloWorld newInstance(String message) {//做一个有参的HelloWorldImpl接口的反射实例化
	    	  //用于定义bean工厂实例，实例出这个方法，之后的bean引用时就不需要每次都实例，只需要最开始在定义
		   //的bean工厂实例化一次就够,每次只需要更改XML文件的bean工厂中的bean
	    	  return new HelloWorldImpl(message);
	   }
}
