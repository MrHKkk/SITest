package com.kd.test.si.messageflow;

import java.text.MessageFormat;
import java.util.Map;

import org.springframework.integration.annotation.Headers;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.kd.test.messageflow.domain.Field;

@Component
public class MarketDataServiceActivator {
	
	@ServiceActivator
	public void handleField(Field dataField, @Headers Map<String, Object> headerMap) {
		System.out.println(
				MessageFormat.format("{0}:{1}", dataField.getFieldDescriptor().toString(), dataField.getValue()));
		for (String key : headerMap.keySet()) {
			Object value = headerMap.get(key);
			System.out.println(MessageFormat.format("header {0}:{1}", key, value));
		}
	}
}
