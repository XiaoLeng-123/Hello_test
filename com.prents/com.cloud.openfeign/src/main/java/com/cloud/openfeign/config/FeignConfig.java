package com.cloud.openfeign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignConfig {

	
	@Bean   //开启日志
	public Logger.Level feginLoggerLevel(){
		return Logger.Level.FULL;
	}
}
