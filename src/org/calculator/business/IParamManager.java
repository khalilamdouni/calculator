package org.calculator.business;

import org.calculator.models.CalculatorMethodParam;

/**
 * The interface of the params manager which is responsible of managing java
 * method params stored in the databese
 * 
 * @author khalil.amdouni
 *
 */
public interface IParamManager {
	
	/**
	 * Getting method param by id
	 * 
	 * @param paramId
	 * @return CalculatorMethodParam
	 */
	public CalculatorMethodParam getParam(long paramId);
	
	/**
	 * Saving method param
	 * 
	 * @param calculatorMethodParam
	 * @return CalculatorMethodParam
	 */
	public CalculatorMethodParam saveParam(CalculatorMethodParam calculatorMethodParam);
	
}
