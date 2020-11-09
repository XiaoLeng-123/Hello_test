package com.cloud.openfeign.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@FeignClient(value = "CLOUD-PROVIDER")
@RequestMapping("/provider")
public interface PayFeign {

	@RequestMapping("/discoveryClient1")
	public Map<String,Object> discovery();
	
	@RequestMapping("/pay1")
	public String getDiscovery1();
}
