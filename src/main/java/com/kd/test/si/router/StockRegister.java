package com.kd.test.si.router;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class StockRegister {

	@ServiceActivator
	public void registerStock(MarketItem item) {
		System.out.println("Registering stock:" + item.getDescription());
	}
}
