package com.cloud.openfeign.controller;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.openfeign.feign.PayFeign;

@RestController
@RequestMapping("/feignPay")
public class PayController {

	@Autowired
	private PayFeign payFeign;
	
	@Value("${server.port}")
	private String serverport;
	
	@RequestMapping("/pay2")
	public Map<String,Object> getDiscovery() {
		
		return payFeign.discovery();
	}
	
	
	@RequestMapping("/pay1")
	public String getDiscovery1() {
		try {
			
			System.out.println("我可以不用方法名一样，就可以启动的！");
			TimeUnit.SECONDS.sleep(5);
			String str = payFeign.getDiscovery1();
			return str.concat("调用服务端成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverport.concat("feign调用超时");
	}
	
	
}
