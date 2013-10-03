package org.calculator.dao;

import org.calculator.models.CalculatorClassMethod;

public interface IMethodDao {
	
	public CalculatorClassMethod getMethod(long methodId);
	public CalculatorClassMethod saveMethod(CalculatorClassMethod method);

}
