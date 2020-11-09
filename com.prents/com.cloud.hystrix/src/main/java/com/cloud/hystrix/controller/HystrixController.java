package com.cloud.hystrix.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.hystrix.hystrixcommand.Hystrixcommond;

@RestController
@RequestMapping("/hys")
public class HystrixController {

	@Autowired
	private Hystrixcommond Hystrixcommond;
	
	@Value("${server.port}")
	private String serverport;
	
	@RequestMapping("/pay")
	public Object getHystrix() {
		try {
			TimeUnit.SECONDS.sleep(5);
			Object hystrix = Hystrixcommond.getHystrix();
			return hystrix;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return serverport;
	}
}
