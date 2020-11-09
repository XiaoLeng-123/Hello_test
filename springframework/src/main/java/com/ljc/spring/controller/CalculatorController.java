package com.ljc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljc.spring.server.CalculatorServer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//@Api
@RestController
public class CalculatorController {
	
	@Autowired
	private CalculatorServer calculatorServer;

	
	
	//@ApiOperation(value = "添加的方法")
	@RequestMapping("/add")
	public int add(int a, int b) {
		return calculatorServer.add(a,b);
	}
}
