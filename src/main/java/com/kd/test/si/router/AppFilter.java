package com.kd.test.si.router;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class AppFilter {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-si-filter.xml");
		MessageChannel channel = ctx.getBean("marketItemChannel", MessageChannel.class);
		MarketItemCreator itemCreator = ctx.getBean("marketItemCreator", MarketItemCreator.class);
		for(MarketItem marketItem : itemCreator.getMarketItems()) {
			channel.send(MessageBuilder.withPayload(marketItem).build());
		}
	}
}
