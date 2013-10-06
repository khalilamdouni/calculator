package org.calculator.business.generators;

import org.calculator.models.CalculatorMethodParam;


public interface IDataGenerator {
	public Object generateData(int x, int y, int z, boolean isString);
	public void generateDataForParam(CalculatorMethodParam param);
}
