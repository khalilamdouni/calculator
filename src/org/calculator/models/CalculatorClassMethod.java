package org.calculator.models;

import java.util.List;

public class CalculatorClassMethod {
	
	private String name;
	private List<CalculatorMethodParam> params;
	
	public CalculatorClassMethod() {
		super();
	}
	
	public CalculatorClassMethod(String name, List<CalculatorMethodParam> params) {
		super();
		this.name = name;
		this.params = params;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CalculatorMethodParam> getParams() {
		return params;
	}
	public void setParams(List<CalculatorMethodParam> params) {
		this.params = params;
	}
	
	
	
	
}
