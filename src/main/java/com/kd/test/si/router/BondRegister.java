package com.kd.test.si.router;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class BondRegister {

	@ServiceActivator
	public void registerBond(MarketItem item) {
		System.out.println("Registering bond: " + item.getDescription());
	}
}
