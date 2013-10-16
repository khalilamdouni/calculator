package org.calculator.dao;

import java.util.List;

import org.calculator.models.CalculatorClass;

/**
 * The interface of classes Data Access Object
 * 
 * @author khalil.amdouni
 *
 */
public interface ICalculatorClassDao {
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses);
	public CalculatorClass getClassById(long id);
	public CalculatorClass saveCalculatorClass(CalculatorClass calculatorClass);
}
