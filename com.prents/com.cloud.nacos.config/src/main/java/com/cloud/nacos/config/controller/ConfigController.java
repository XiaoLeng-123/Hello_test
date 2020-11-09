package com.cloud.nacos.config.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/config")
public class ConfigController {

	@Value("${service-url.nacos-user-service}")
	private String serverURL;

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/pay")
	public Object pay() {
		// return restTemplate.getForObject(PAYMENT_URL+"/pay/discoveryClient1",Object.class);
		return restTemplate.getForObject(serverURL+"/pay/discoveryClient1",Object.class);
	}

}
