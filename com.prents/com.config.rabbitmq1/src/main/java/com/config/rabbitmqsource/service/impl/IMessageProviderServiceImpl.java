package com.config.rabbitmqsource.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.config.rabbitmqsource.service.IMessageProviderService;



@EnableBinding(Source.class)   //指定channel和exchange绑定在一起
public class IMessageProviderServiceImpl implements IMessageProviderService{

	@Resource
	private MessageChannel output;   //消息发送管道
	
	@Override
	public String send() {
		String serial = UUID.randomUUID().toString(); 
		boolean send = output.send(MessageBuilder.withPayload(serial).build());
		return serial;
	}

}
