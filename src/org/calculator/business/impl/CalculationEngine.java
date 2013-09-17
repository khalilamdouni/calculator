package org.calculator.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.calculator.business.ICalculationEngine;
import org.calculator.business.generators.IDataGenerator;
import org.calculator.models.IAlgorithme;
import org.calculator.models.impl.Result;

public class CalculationEngine implements ICalculationEngine {

	@Override
	public List<Result> calculate(IAlgorithme algo, IDataGenerator dataGenerator) {

		List<Result> results = new ArrayList<Result>();
		for (int dataSize = 1000; dataSize < 30000; dataSize += 1000) {
			algo.setData((Object[]) dataGenerator.generateData(dataSize, 0, 0));
			algo.transformData();
			long execTime = 0;
			long beginTime = System.currentTimeMillis();
			algo.run();
			execTime = System.currentTimeMillis() - beginTime;
			results.add(new Result((long) dataSize, (double) execTime));
		}
		return results;
	}

}
