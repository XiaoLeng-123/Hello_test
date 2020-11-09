package com.cloud.sentinel.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

	@Value("${server.port}")
	private String serverport;
	
	@Resource
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/pay1")
	public String getDiscovery1() {
		return serverport;
	}
}
