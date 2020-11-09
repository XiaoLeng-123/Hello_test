package com.ribbonclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfIRule {

	@Bean
	public IRule myIRule() {
		return new RandomRule();
	}
}
