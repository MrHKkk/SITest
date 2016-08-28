package com.kd.test.si.domain;

public class Trade {

	private String tradeId;
	private String tradeStatus;
	private String tradeDesc;
	
	public Trade(){}
	
	public Trade(String tradeId, String tradeStatus, String tradeDesc) {
		this.tradeId = tradeId;
		this.tradeStatus = tradeStatus;
		this.tradeDesc = tradeDesc;
	}
	
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public String getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public String getTradeDesc() {
		return tradeDesc;
	}
	public void setTradeDesc(String tradeDesc) {
		this.tradeDesc = tradeDesc;
	}
	
	
	
}
