package org.calculator.models;

import org.calculator.enums.CalculatorType;

public class CalculatorMethodParam {

	private String name;
	private CalculatorType type;

	public CalculatorMethodParam(String name, CalculatorType type) {
		super();
		this.name = name;
		this.type = type;
	}

	public CalculatorMethodParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CalculatorType getType() {
		return type;
	}

	public void setType(CalculatorType type) {
		this.type = type;
	}

}
