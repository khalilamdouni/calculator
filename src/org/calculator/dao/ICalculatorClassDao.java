package org.calculator.dao;

import java.util.List;

import org.calculator.models.CalculatorClass;

/**
 * The interface of classes Data Access Object
 * 
 * @author khalil.amdouni
 * 
 */
public interface ICalculatorClassDao extends IGenericDao<CalculatorClass> {

	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses);

}
