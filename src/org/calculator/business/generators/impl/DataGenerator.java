package org.calculator.business.generators.impl;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.UUID;

import org.calculator.business.generators.IDataGenerator;
import org.calculator.enums.CalculatorType;
import org.calculator.models.CalculatorMethodParam;
import org.calculator.models.CalculationConfig;

/**
 * @see org.calculator.business.generators.IDataGenerator
 * 
 * @author khalil.amdouni
 * 
 */
public class DataGenerator implements IDataGenerator {

	private Double randomDouble(double min, double max) {
		Random r = new Random();
		return Double.valueOf(min + (max - min) * r.nextDouble());
	}

	@Override
	public Object generateData(int x, int y, int z, boolean isString) {

		if (x == 0) {
			return isString ? UUID.randomUUID().toString() : randomDouble(
					30000, 60000);
		}
		Object[] result = new Object[x];
		for (int i = 0; i < result.length; i++) {
			result[i] = generateData(y, z, 0, isString);
		}
		return result;
	}

	@Override
	public void generateDataForParam(CalculatorMethodParam param) {

		CalculationConfig activeConfig = param.getActiveConfig();
		param.setGeneratedDatas(new LinkedHashMap());
		for (int i = activeConfig.getMin(); i < activeConfig.getMax(); i += activeConfig
				.getStep()) {
			param.getGeneratedDatas()
					.put(i,
							generateData(
									(param.getType() == CalculatorType.NUMBER || param
											.getType() == CalculatorType.STRING) ? 0
											: i,
									(param.getType() == CalculatorType.TAB_NUMBER || param
											.getType() == CalculatorType.TAB_STRING) ? 0
											: i,
									(param.getType() == CalculatorType.TAB_TAB_NUMBER || param
											.getType() == CalculatorType.TAB_TAB_STRING) ? 0
											: i,
									(param.getType() == CalculatorType.STRING
											|| param.getType() == CalculatorType.TAB_STRING
											|| param.getType() == CalculatorType.TAB_TAB_STRING || param
											.getType() == CalculatorType.TAB_TAB_TAB_STRING)));
		}

	}

}
