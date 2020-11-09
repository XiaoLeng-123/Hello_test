package com.ljc.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ljc.spring.config.CalculatProxyConfig;
import com.ljc.spring.controller.PersonController;
import com.ljc.spring.entity.DepementEntity;
import com.ljc.spring.entity.PersonEntity;
import com.ljc.spring.server.CalculatorServer;
import com.ljc.spring.server.impl.CalculatorServerImpl;





/**
 * 
 * 
 * @author JD-DZ612
 * 
 *用来指定配置文件的位置
 * @ContextConfiguration(locations = "classpath:application.properties,application.yml")
 * 指定用那种驱动进行单元测试，默认是junit
 * @RunWith(SpringJUnit4ClassRunner.class)  使用spring的单元测试来进行模块测试
 *
 */

//用来指定配置文件的位置
//@ContextConfiguration(locations = "classpath:application.properties")
//指定用那种驱动进行单元测试，默认是junit
//@RunWith(SpringJUnit4ClassRunner.class) //使用spring的单元测试来进行模块测试

@SpringBootTest
class SpringframeworkApplicationTests {
	
	
	
	@Test
	void hello11() {
		
		//加载容器
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		CalculatorServer bean = context.getBean(CalculatorServer.class);
		int add = bean.add(1,2);
		System.out.println(add);
		context.close();
	}
	
	
	
	
	//@Test
	void hello10() {
		
		//加载容器
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		CalculatorServer bean = context.getBean(CalculatorServer.class);
		int add = bean.add(1,2);
		System.out.println(add);
		context.close();
	}
	
	
	
	
	//@Test
	void hello09() {
		
		//加载容器
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		CalculatorServer bean = context.getBean(CalculatorServer.class);
		int add = bean.add(1,2);
		System.out.println(add);
		context.close();
	}
	
	
	
	//@Test
	void hello08() {
		
		//加载容器
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		CalculatorServer bean = (CalculatorServer) context.getBean(CalculatorServer.class);
		Object proxy = CalculatProxyConfig.getProxy(bean);
		((CalculatorServer) proxy).add(1,2);
		System.out.println(proxy);
		context.close();
	}
	
	
	//@Test
	void hello07() {
		//加载容器
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ioc02.xml");
		PersonController bean = context.getBean("personController",PersonController.class);
		System.out.println(bean);
		context.close();

	}
	
	
	
	//@Test
	void hello06() {
		//加载容器
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ioc02.xml");
		DepementEntity bean = context.getBean("depementEntity",DepementEntity.class);
		System.out.println(bean);
		context.close();

	}
	
	
	//--------------------------------------------------------------------------------
	
	//@Test
	void hello05() {
		//加载容器
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		PersonController bean = context.getBean("personController",PersonController.class);
		System.out.println(bean);
		context.close();

	}
	
	
	//@Test
	void hello04() {
		//加载容器
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		PersonEntity bean = context.getBean("myFactory",PersonEntity.class);
		System.out.println(bean);

	}
	
	
	//@Test
	void hello03() {
		//加载容器
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		PersonEntity bean = context.getBean("personEntity07",PersonEntity.class);
		System.out.println(bean);

	}
	
	
	
	//@Test
	void hello02() {
		//加载容器
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		PersonEntity bean = context.getBean("personEntity02",PersonEntity.class);
		System.out.println(bean);

	}
	
	//@Test
	void hello01() {
		//加载容器
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		DepementEntity bean = context.getBean("depementEntity01",DepementEntity.class);
		System.out.println(bean);

	}
	
	//@Test
	void hello() {
		//加载容器
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
		PersonEntity bean = context.getBean(PersonEntity.class);
		System.out.println(bean);

	}
	
	
	
	//@Test
	void contextLoads() {
	}

}
