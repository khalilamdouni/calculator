package org.calculator.dao;

import org.calculator.models.CalculatorMethodParam;

public interface IParamDao {
	
	public CalculatorMethodParam getParam(long paramId);
	public CalculatorMethodParam saveParam(CalculatorMethodParam calculatorMethodParam);
	
}
