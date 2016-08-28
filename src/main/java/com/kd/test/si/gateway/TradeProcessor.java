package com.kd.test.si.gateway;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.kd.test.si.domain.Trade;

@Service
public class TradeProcessor {
	
	public Trade receiveTrade(Message<Trade> msg) {
		Trade t = msg.getPayload();
		System.out.println("Received the Trade via gateway: " + t);
		t.setTradeStatus("Processed");
		return t; 
	}
}
