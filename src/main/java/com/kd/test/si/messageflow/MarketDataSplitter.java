package com.kd.test.si.router;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import com.kd.test.messageflow.domain.Field;
import com.kd.test.messageflow.domain.FieldDescriptor;

@Component
public class MarketDataSplitter {

	@Splitter
	public Collection<Field> splitItem(MarketItem marketItem) {
		
		List<Field> messages = new ArrayList<Field>();
		
		Field field = new Field(FieldDescriptor.SYMBOL, marketItem.getSymbol());
		messages.add(field);
		field = new Field(FieldDescriptor.DESC, marketItem.getDescription());
		messages.add(field);
		field = new Field(FieldDescriptor.PRICE, marketItem.getPrice());
		messages.add(field);
		field = new Field(FieldDescriptor.OPEN_PRICE, marketItem.getOpenPrice());
		messages.add(field);
		field = new Field(FieldDescriptor.TYPE, marketItem.getType());
		messages.add(field);
		
		return messages;
		
	}
}
