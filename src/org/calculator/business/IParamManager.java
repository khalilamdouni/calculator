package org.calculator.business;

import org.calculator.models.CalculatorMethodParam;

public interface IParamManager {
	
	public CalculatorMethodParam getParam(long paramId);
	public CalculatorMethodParam saveParam(CalculatorMethodParam calculatorMethodParam);
	
}
