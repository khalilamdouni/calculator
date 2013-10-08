package org.calculator.business.impl;

import org.calculator.business.ITypesManager;
import org.calculator.enums.CalculatorType;
import org.calculator.models.CalculatorMethodParam;

public class TypesManager implements ITypesManager {

	
	
	private Class<?> getClassType(CalculatorType type) {
		if (type == CalculatorType.NUMBER)
			return double.class;
		if (type == CalculatorType.STRING)
			return String.class;
		if (type == CalculatorType.TAB_NUMBER)
			return double[].class;
		if (type == CalculatorType.TAB_STRING)
			return String[].class;
		if (type == CalculatorType.TAB_TAB_NUMBER)
			return double[][].class;
		if (type == CalculatorType.TAB_TAB_STRING)
			return String[][].class;
		if (type == CalculatorType.TAB_TAB_TAB_NUMBER)
			return double[][][].class;
		return String[][][].class;
	}
	
	@Override
	public void detectType(CalculatorMethodParam param) {
		param.setParamType(getClassType(param.getType()));
	}

}
