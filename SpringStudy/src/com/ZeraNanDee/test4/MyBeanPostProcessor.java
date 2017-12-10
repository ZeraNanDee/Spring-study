package com.ZeraNanDee.test4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override//这个BeanPostProcessor接口类是bean的生命周期中的bean后置处理器，很方便很强大
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("这个方法在init方法后面："+bean+","+beanName);
		Girfriend girfriend=new Girfriend();
		girfriend.setName("清水健");
		return girfriend;//这个bean后置方法甚至可以返回新的bean，也可以修改bean的属性，改变这个原来的属性和方法
	}//这个会导致最后执行此bean时setName被修改，很骚

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("这个方法在init方法前面："+bean+","+beanName);//过滤一下其他bean文件
		if ("girfriend".equals(beanName)) {//这个目的是为了只执行conf-Instance文件中指定的bean，而不全部执行
		}
		return bean;
	}

}
