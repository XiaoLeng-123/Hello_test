package com.consul.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consul")
public class ConsulController {

	@Value("${server.port}")
	private String serverport;
	
	@Resource
	private DiscoveryClient discoveryClient;
	
	
	@RequestMapping("/discoveryClient1")
	public Map<String,Object> discovery() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<String> services = discoveryClient.getServices();
		List<ServiceInstance> instances = discoveryClient.getInstances(serverport);
		map.put("regions", services);
		map.put("remoteStatus", instances);
		return map;
	}

}
