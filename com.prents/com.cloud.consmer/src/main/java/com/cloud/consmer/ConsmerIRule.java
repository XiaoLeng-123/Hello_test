package com.cloud.consmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ribbonclient.MySelfIRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-provider",configuration = MySelfIRule.class)
public class ConsmerIRule {

	public static void main(String[] args) {
		SpringApplication.run(ConsmerIRule.class, args);
	}
}
