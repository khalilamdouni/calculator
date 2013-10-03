package org.calculator.business;

import org.calculator.models.CalculatorClassMethod;

public interface IMethodManager {
	
	public CalculatorClassMethod getMethod(long methodId);
	public CalculatorClassMethod saveMethod(CalculatorClassMethod method);
	
}
