package com.cloud.consmer.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consmer")
public class ConsmerController {

	public static final String PAYMENT_URL = "http://cloud-provider";
	
	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping("/pay")
	public  Object pay() {
		return restTemplate.getForObject(PAYMENT_URL+"/pay/discoveryClient1", Object.class);
	}

}
