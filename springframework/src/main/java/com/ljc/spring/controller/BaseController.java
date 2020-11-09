package com.ljc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljc.spring.abstr.BaseAbstract;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


//@Api
@RestController
public class BaseController<T> extends BaseAbstract<T>{

	
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("BaseController:__save");
	}
	
	//@ApiOperation(value = "删除的方法")
	@RequestMapping("/delete")
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("BaseController:_delete");
	}
	

}
