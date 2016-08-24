package com.kd.test.si.router;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MarketItemCreator {

	public List<MarketItem> getMarketItems() {
		List<MarketItem> marketItems = new ArrayList<MarketItem>();

		MarketItem marketItem = new MarketItem();
		marketItem.setSymbol("IBM");
		marketItem.setDescription("International Business Machines");
		marketItem.setOpenPrice("130.00");
		marketItem.setPrice("135.00");
		marketItem.setType("stock");
		marketItems.add(marketItem);

		marketItem = new MarketItem();
		marketItem.setSymbol("PBNDXX");
		marketItem.setDescription("A Par Bond");
		marketItem.setOpenPrice("50.00");
		marketItem.setPrice("55.00");
		marketItem.setType("bond");
		marketItems.add(marketItem);
		
		marketItem = new MarketItem();
		marketItem.setSymbol("MUFX");
		marketItem.setDescription("Mutual Bonds");
		marketItem.setOpenPrice("50.00");
		marketItem.setPrice("55.00");
		marketItem.setType("bond");
		marketItems.add(marketItem);
		
		marketItem = new MarketItem();
		marketItem.setSymbol("stock");
		marketItem.setDescription("Intel Corp.");
		marketItem.setOpenPrice("130.00");
		marketItem.setPrice("135.00");
		marketItem.setType("stock");
		marketItems.add(marketItem);

		marketItem = new MarketItem();
		marketItem.setSymbol("FX");
		marketItem.setDescription("USD");
		marketItem.setOpenPrice("63.00");
		marketItem.setPrice("34.00");
		marketItem.setType("FX");
		marketItems.add(marketItem);
		
		
		return marketItems;
	}
}
