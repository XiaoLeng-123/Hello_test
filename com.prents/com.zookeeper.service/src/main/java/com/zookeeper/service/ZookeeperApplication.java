package com.zookeeper.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class ZookeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZookeeperApplication.class, args);

	}

}
