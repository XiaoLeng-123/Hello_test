package com.ljc.spring.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.stereotype.Component;

@Component
public class CalculatProxyConfig {

	public static Object getProxy(Object obj){
		
		/**
		 * ClassLoader:被代理对象的类加载器；公式：类名.getClass().getClassLoader();
		 * Class<?>[]:被代理对象的所有接口；公式：类名.getClass().getInterfaces();
		 * InvocationHandler:方法的执行器
		 */
		
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * Object:代理对象，给jdk使用，任何时候都不要动它；
			 * Method:当前将要执行目标对象的方法
			 * Object[]:方法调用时，传入的参数值
			 */
			
			@Override
			public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
				Object invoke =null;
				try{
					System.out.println(arg1.getName()+"开始执行了");
					invoke = arg1.invoke(obj, arg2);
				}catch(Exception e){
					System.out.println(arg1.getName()+"方法异常");
					e.printStackTrace();
				}finally {
					System.out.println(arg1.getName()+"执行结束了");
				}
				return invoke;
			}
		};
		Class<?>[] interfaces = obj.getClass().getInterfaces();
		ClassLoader loader = obj.getClass().getClassLoader();
		
		Object porxy = Proxy.newProxyInstance(loader, interfaces, h);
		return porxy;
	}
}
