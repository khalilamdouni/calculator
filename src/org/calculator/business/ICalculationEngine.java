package org.calculator.business;

import java.util.List;

import org.calculator.business.generators.IDataGenerator;
import org.calculator.models.IAlgorithme;
import org.calculator.models.impl.Result;

public interface ICalculationEngine {
	public List<Result> calculate(IAlgorithme algo, IDataGenerator dataGenerator);
}
