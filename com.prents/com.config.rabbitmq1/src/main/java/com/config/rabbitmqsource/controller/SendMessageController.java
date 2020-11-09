package com.config.rabbitmqsource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.config.rabbitmqsource.service.IMessageProviderService;

@RestController
public class SendMessageController {

	
	
	@Autowired
	private IMessageProviderService iMessageProviderService;
	
	public String sendMessage() {
		return iMessageProviderService.send();
	}
}
