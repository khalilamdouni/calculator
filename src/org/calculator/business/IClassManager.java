package org.calculator.business;

import java.io.IOException;
import java.util.List;

import org.calculator.models.CalculatorClass;
import org.calculator.models.IAlgorithme;

public interface IClassManager {
	public IAlgorithme loadCalculatorClass(long id) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses);
	public CalculatorClass getCalculatorClass(long id);
}
