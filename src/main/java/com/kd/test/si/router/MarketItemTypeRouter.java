package com.kd.test.si.router;

import org.springframework.integration.annotation.Router;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MarketItemTypeRouter {

	@Router
	public String route(Message<MarketItem> msg) {
		MarketItem item = msg.getPayload();
		String channelId = item.getType();
		return channelId;
	}
}
