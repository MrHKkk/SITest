package com.kd.test.si.router;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MarketSelectorItemFilter implements MessageSelector{

	@Override
	public boolean accept(Message<?> message) {
		MarketItem item = (MarketItem)message.getPayload();
		return (item != null && "stock".equals(item.getType()));
	}

}
