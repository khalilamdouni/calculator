package org.calculator.enums;

public enum CalculatorType {

	NUMBER("NUMBER"), STRING("STRING"), TAB_NUMBER("TAB_NUMBER"),
	TAB_TAB_NUMBER("TAB_TAB_NUMBER"), TAB_TAB_TAB_NUMBER("TAB_TAB_TAB_NUMBER"), 
	TAB_STRING("TAB_STRING"), TAB_TAB_STRING("TAB_TAB_STRING"), 
	TAB_TAB_TAB_STRING("TAB_TAB_TAB_STRING");

	private final String name;

	private CalculatorType(String type) {
		this.name = type;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
