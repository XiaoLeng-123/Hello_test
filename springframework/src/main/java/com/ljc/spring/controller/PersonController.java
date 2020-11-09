package com.ljc.spring.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljc.spring.server.PersonServer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



//@Api
@RestController
public class PersonController {
	
	
	/**
	 * @Autowired:的原理
	 * 	1、首先按照类型去容器中找到对应的组件，找到直接赋值；
	 * 	2、如果没有找到，就抛异常
	 * 	3、如果找到多个（父子继承，装配上
	 * 		3.1、会继续按照变量名作为id进行匹配
	 * 			3.1.1、匹配上；
	 * 			3.1.2、没有匹配上就抛异常；原因是使用变量名作为id来匹配的
	 * 	@Qualifier:指定一个新的id进行匹配
	 * 		1.1、找到了自动装配
	 * 		1.2、没有找到，报错
	 * @Autowired：是spring的，离开spring就不可以用了
	 * @Resource:jdk自带的，它是一个标准，扩展性更强
	 * @Inject
	 * 
	 */
	
	
	
	
	
	@Qualifier("personServer") //自定义一个新的id
	//@Autowired(required = false) //添加required属性等于false，表示找不到就赋值为null
	private PersonServer personServer;
	
	
	//@ApiOperation(value = "获得person对象")
	@RequestMapping("/getPerson")
	public String gerPerson() {
		return personServer.gerPerson();
	}
	
	public void myInit() {
		System.out.println("myInit");
	}

	
	public void myDestory() {
		System.out.println("myDestory");
	}
}











