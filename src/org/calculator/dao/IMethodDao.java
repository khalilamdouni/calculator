package org.calculator.dao;

import org.calculator.models.CalculatorClassMethod;

/**
 * The interface of java method Data Access Object
 * 
 * @author khalil.amdouni
 *
 */
public interface IMethodDao {
	
	public CalculatorClassMethod getMethod(long methodId);
	public CalculatorClassMethod saveMethod(CalculatorClassMethod method);

}
