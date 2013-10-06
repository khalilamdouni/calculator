package org.calculator.business;

import java.io.IOException;
import java.util.List;

import org.calculator.business.generators.IDataGenerator;
import org.calculator.models.IAlgorithme;
import org.calculator.models.Result;

public interface ICalculationEngine {
	public List<Result> calculate(IAlgorithme algo, IDataGenerator dataGenerator);
	public List<Result> calculate(long methodId) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException;
}
