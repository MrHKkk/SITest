package com.kd.test.si.router;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

public class App {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-si-router.xml");
		MessageChannel channel = context.getBean("marketItemChannel", MessageChannel.class);
		MarketItemCreator itemCreator = context.getBean("marketItemCreator", MarketItemCreator.class);
		for(MarketItem marketItem : itemCreator.getMarketItems()) {
			channel.send(MessageBuilder.withPayload(marketItem).build());
		}
	}
}
