package com.kd.test.si.router;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class FXRegister {

	@ServiceActivator
	public void registerFX(MarketItem item) {
		System.out.println("Registering FX " + item.getDescription());
	}
	
}
