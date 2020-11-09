package com.ljc.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	
	//初始化之前调用
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("postProcessBeforeInitialization:___"+beanName);
		return bean;
	}
	
	
	
	//初始化之后调用
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("postProcessAfterInitialization:___"+beanName);
		return bean;
	}
}
