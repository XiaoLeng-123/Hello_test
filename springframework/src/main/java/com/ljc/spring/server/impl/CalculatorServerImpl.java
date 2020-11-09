package com.ljc.spring.server.impl;

import org.springframework.stereotype.Service;

import com.ljc.spring.server.CalculatorServer;


@Service
public class CalculatorServerImpl implements CalculatorServer{

	@Override
	public int add(int a, int b) {
		int c = a+b;
		//int d = a/0;
		return c;
	}

}
