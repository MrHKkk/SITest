package com.kd.test.si.transformer;

import java.util.Map;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

	@Transformer
	public Customer map(Map<String, String> message) {
		Customer customer = new Customer();
		
		customer.setFirstname(message.get("firstname"));
		customer.setLastname(message.get("lastname"));
		customer.setAddress(message.get("address"));
		customer.setUid(message.get("uid"));
		customer.setBirthdate(message.get("birthdate"));
		customer.setGender(message.get("gender"));
		return customer;
	}
}
