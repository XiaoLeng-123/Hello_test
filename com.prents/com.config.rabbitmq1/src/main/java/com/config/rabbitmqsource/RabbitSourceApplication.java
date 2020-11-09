package com.config.rabbitmqsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class RabbitSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitSourceApplication.class,args);
	}
}
