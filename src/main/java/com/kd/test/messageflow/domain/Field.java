package com.kd.test.messageflow.domain;

public class Field {

	FieldDescriptor fieldDescriptor;
	String value;
	
	public Field() {
		
	}
	
	public Field(FieldDescriptor fd, String value) {
		this.fieldDescriptor = fd;
		this.value = value;
	}

	public FieldDescriptor getFieldDescriptor() {
		return fieldDescriptor;
	}

	public void setFieldDescriptor(FieldDescriptor fieldDescriptor) {
		this.fieldDescriptor = fieldDescriptor;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
