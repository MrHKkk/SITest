package com.kd.test.si.transformer;

import java.util.HashMap;
import java.util.Map;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

public class TransformerTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("classpath:spring-si-transformer.xml");
		MessageChannel input = appCtx.getBean("input", MessageChannel.class);
		
		PollableChannel output = appCtx.getBean("output", PollableChannel.class);
		Map<String, String> customerMap = new HashMap<String, String>();
		customerMap.put("firstname", "Jack");
		customerMap.put("lastname", "Dennis");
		customerMap.put("address", "505B 1005 road ");
		customerMap.put("uid", "g1245111");
		customerMap.put("gender", "male");
		customerMap.put("birthdate", "1999-11-11");
		
		Message<Map<String, String>> message = MessageBuilder.withPayload(customerMap).build();
		input.send(message);
		
		Message<?> reply = output.receive();
		System.out.println(reply.getPayload());
	}
}
