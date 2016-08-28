package com.kd.test.si.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.kd.test.si.transformer.Customer;

public class AppXml {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:si-transformer-xml.xml");
		MessageChannel input = context.getBean("input", MessageChannel.class);
		PollableChannel output = context.getBean("output", PollableChannel.class);
		Customer customer = new Customer();
		
		customer.setFirstname("Jack");
		customer.setLastname("Den");
		customer.setGender("male");
		
		System.out.println("toString(): " + customer.toString());
		Message<Customer> message = MessageBuilder.withPayload(customer).build();
		input.send(message);
		Message<?> reply = output.receive();
		System.out.println("received: " + reply.getPayload());
	}
}
