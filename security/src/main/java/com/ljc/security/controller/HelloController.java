package com.ljc.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ljc.security.pojo.Users;


@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/word")
	public String word() {
		
		return "hello security";
		
	}
	
	
	@RequestMapping("/index")
	public String index() {
		
		return "hello index";
		
	}
	
	
	@Secured(value = {"ROLE_root","ROLE_admin"})
	@RequestMapping("/update")
	public @ResponseBody String update() {
		
		return "hello update";
		
	}
	
	
	@PreAuthorize("hasAnyAuthority('root')")
	@RequestMapping("/update1")
	public @ResponseBody String update1() {
		
		return "hello update1";
		
	}
	
	@PostAuthorize("hasAnyAuthority('root')")
	@RequestMapping("/update2")
	public @ResponseBody String update2() {
		System.out.println("update2");
		return "hello update2";
		
	}
	
	
	@PostAuthorize("hasAnyAuthority('root')")
	@PostFilter("filterObject.username == 'admin'")
	@RequestMapping("/update3")
	public @ResponseBody String update3() {
		List<Users> list = new ArrayList<>();
		list.add(new Users(1,"admin","admin","admin"));
		list.add(new Users(2,"admins","admins","admin"));
		System.out.println(list);
		return "hello update3";
		
	}
	
	
	
}
