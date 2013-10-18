package org.calculator.enums;

/**
 * Http method types used in web requests calculation
 * 
 * @author khalil.amdouni
 *
 */
public enum CalculatorHttpMethods {

	GET("GET"), POST("POST");

	private final String name;

	private CalculatorHttpMethods(String method) {
		this.name = method;
	}

	@Override
	public String toString() {
		return name;
	}
}
