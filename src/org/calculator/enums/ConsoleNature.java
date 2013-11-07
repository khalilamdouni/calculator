package org.calculator.enums;

/**
 * The same calculation console is used to calculate JAR scenarios and WEB
 * scenarios
 * 
 * @author khalil.amdouni
 * 
 */
public enum ConsoleNature {
	JAR_CONSOLE("JAR_CONSOLE"), WEB_CONSOLE("WEB_CONSOLE");

	private final String name;

	private ConsoleNature(String method) {
		this.name = method;
	}

	@Override
	public String toString() {
		return name;
	}
}
