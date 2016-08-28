package com.kd.test.si.xml;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class XmlConsumer {
	
	@ServiceActivator
	public void consume(String str) { 
		System.out.println(str);
	}
}
