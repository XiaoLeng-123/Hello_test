package com.ljc.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@MapperScan("com.ljc.security.dao")
@SpringBootApplication
//开启web权限用户授权设置的注解配置
@EnableGlobalMethodSecurity(securedEnabled = true , prePostEnabled = true)
public class Springmvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springmvc1Application.class, args);
	}

}
