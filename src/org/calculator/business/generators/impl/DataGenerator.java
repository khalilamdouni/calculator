package org.calculator.business.generators.impl;

import java.util.Random;

import org.calculator.business.generators.IDataGenerator;

public class DataGenerator implements IDataGenerator {

	private Double randomDouble(double min, double max) {
		Random r = new Random();
		return Double.valueOf(min + (max - min) * r.nextDouble());
	}

	@Override
	public Object generateData(int x, int y, int z) {

		if (x == 0)
			return randomDouble(30000, 60000);
		Object[] result = new Object[x];
		for (int i = 0; i < result.length; i++) {
			result[i] = generateData(y, z, 0);
		}
		return result;
	}

}
