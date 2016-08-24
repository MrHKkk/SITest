package com.kd.test.messageflow.domain;

public enum FieldDescriptor {

	TYPE(1), SYMBOL(2), DESC(4), OPEN_PRICE(8), PRICE(16), ALL(1 + 2 + 4 + 8 + 16);
	
	private final int fieldId;
	
	FieldDescriptor(int id) {
		this.fieldId = id;
	}
	
	public int fileId() {
		return fieldId;
	}
}
