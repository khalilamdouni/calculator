package org.calculator.business.generators;

import org.calculator.models.CalculatorMethodParam;

/**
 * The interface of the data generator which is responsible of generating inputs
 * of methods befor passing them to calculation engine
 * 
 * @author khalil.amdouni
 * 
 */
public interface IDataGenerator {

	/**
	 * Generating data according to dimentions passed in params
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param isString
	 * @return Object
	 */
	public Object generateData(int x, int y, int z, boolean isString);

	/**
	 * Generating coherent data of method param
	 * 
	 * @param param
	 */
	public void generateDataForParam(CalculatorMethodParam param);
}
