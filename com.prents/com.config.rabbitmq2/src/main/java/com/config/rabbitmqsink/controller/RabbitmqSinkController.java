package com.config.rabbitmqsink.controller;

import org.apache.tomcat.util.net.WriteBuffer.Sink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class RabbitmqSinkController {

	@Value("${server.port}")
	private String serverport;
	
	
	
	@StreamListener(org.springframework.cloud.stream.messaging.Sink.INPUT)
	public void input(Message<String> message) {
		System.out.println(message.getPayload());
	}
}
