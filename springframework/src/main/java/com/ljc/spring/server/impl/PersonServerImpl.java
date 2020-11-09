package com.ljc.spring.server.impl;

import org.springframework.stereotype.Service;

import com.ljc.spring.server.PersonServer;


@Service
public class PersonServerImpl implements PersonServer{

	@Override
	public String gerPerson() {
		// TODO Auto-generated method stub
		return "恭喜使用自动配置成功";
	}

}
