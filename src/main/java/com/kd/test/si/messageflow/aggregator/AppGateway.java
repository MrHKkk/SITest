package com.kd.test.si.messageflow.aggregator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kd.test.si.domain.Trade;
import com.kd.test.si.gateway.ITradeGateway;

public class AppGateway {

	private ApplicationContext ctx;
	private ITradeGateway tradeGateway;
	
	
	public AppGateway() {
		ctx = new ClassPathXmlApplicationContext("classpath:si-gateway-test.xml");
		tradeGateway = ctx.getBean("tradeGateway", ITradeGateway.class);
	}
	
	
	public static void main(String[] args) {
		AppGateway test = new AppGateway();
		Trade t = new Trade();
		test.publishTrade(t);
	}
	
	public void publishTrade(Trade t) {
		
		Trade it = tradeGateway.processTrade(t);
		System.out.println("Trade Message Published(Reply)." + it.getTradeStatus());
	}
}
