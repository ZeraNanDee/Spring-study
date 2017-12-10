package com.ZeraNanDee.test1;

public class HelloWorldStaticFactory {//静态Bean工厂操作,用newInstance加载实例化类
      public static HelloWorld newInstance(String message) {//做一个有参的HelloWorldImpl接口的反射实例化
    	  //返回需要的Bean实例,static就是静态的，每次执行都自动调用实例化
    	  return new HelloWorldImpl(message);
    	  
      }
}
