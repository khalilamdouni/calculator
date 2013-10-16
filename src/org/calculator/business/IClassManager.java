package org.calculator.business;

import java.io.IOException;
import java.util.List;

import org.calculator.models.CalculatorClass;
import org.calculator.models.IAlgorithme;

/**
 * The interface of the classes manager which is responsible of saving, loading
 * and editing classes in the database
 * 
 * @author khalil.amdouni
 * 
 */
public interface IClassManager {

	/**
	 * Loading a class that implements the IAlgorithme interface
	 * 
	 * @param id
	 * @return IAlgorithme
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public IAlgorithme loadCalculatorClass(long id) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException;

	/**
	 * Saving class infos in the database
	 * 
	 * @param calculatorClasses
	 */
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses);

	/**
	 * Returning class info by class id
	 * 
	 * @param id
	 * @return CalculatorClass
	 */
	public CalculatorClass getCalculatorClass(long id);

	/**
	 * Saving class info in the database
	 * 
	 * @param calculatorClass
	 * @return CalculatorClass
	 */
	public CalculatorClass saveCalculatorClass(CalculatorClass calculatorClass);
}
