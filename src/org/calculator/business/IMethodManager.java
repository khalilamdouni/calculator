package org.calculator.business;

import org.calculator.models.CalculatorClassMethod;

/**
 * The interface of the methods manager which is responsible of managing java
 * methods stored in the databese
 * 
 * @author khalil.amdouni
 * 
 */
public interface IMethodManager {

	/**
	 * Getting method by id
	 * 
	 * @param methodId
	 * @return CalculatorClassMethod
	 */
	public CalculatorClassMethod getMethod(long methodId);

	/**
	 * Saving method
	 * 
	 * @param method
	 * @return CalculatorClassMethod
	 */
	public CalculatorClassMethod saveMethod(CalculatorClassMethod method);

}
