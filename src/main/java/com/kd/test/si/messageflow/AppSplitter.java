package com.kd.test.si.messageflow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.kd.test.si.router.MarketItem;
import com.kd.test.si.router.MarketItemCreator;

public class AppSplitter {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-si-splitter.xml");
		MessageChannel channel = context.getBean("marketDataInputChannel", MessageChannel.class);
		MarketItemCreator marketItemCreator = context.getBean("marketItemCreator", MarketItemCreator.class);
		
		for (MarketItem marketItem : marketItemCreator.getMarketItems()) {
			channel.send(MessageBuilder.withPayload(marketItem).build());
		}
	}

}
