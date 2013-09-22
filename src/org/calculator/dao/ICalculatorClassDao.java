package org.calculator.dao;

import java.util.List;

import org.calculator.models.impl.CalculatorClass;

public interface ICalculatorClassDao {
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses);
	public CalculatorClass getClassById(long id);
}
