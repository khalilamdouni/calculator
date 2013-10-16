package org.calculator.business;

import java.util.List;

import org.calculator.models.CalculatorMethodParam;

/**
 * The interface of the Types manager which is responsible of detecting and
 * transforming param types to be ready for the calculation engine
 * 
 * @author khalil.amdouni
 * 
 */
public interface ITypesManager {

	/**
	 * Detecting the javatype of the method param
	 * 
	 * @param param
	 */
	public void detectType(CalculatorMethodParam param);

	/**
	 * Returning tab of objects ready to be used in the calculation engine
	 * 
	 * @param params
	 * @param datas
	 * @return tab of Objects
	 */
	public Object[] transformData(List<CalculatorMethodParam> params,
			Object[] datas);

	/**
	 * Generic method that transforms Object to T type
	 * 
	 * @param data
	 * @param classType
	 * @return T
	 */
	public <T> T transform(Object data, Class<T> classType);

	/**
	 * Generic method that transforms Object to tab of T type
	 * 
	 * @param data
	 * @param classType
	 * @return tab of T
	 */
	public <T> T[] transformToTab(Object data, Class<T> classType);

	/**
	 * Generic method that transforms Object to tab of tab of T type
	 * 
	 * @param data
	 * @param classType
	 * @return tab of tab of T
	 */
	public <T> T[][] transformToTabTab(Object data, Class<T> classType);

	/**
	 * Generic method that transforms Object to tab of tab of tab of T type
	 * 
	 * @param data
	 * @param classType
	 * @return tab of tab of tab of T
	 */
	public <T> T[][][] transformToTabTabTab(Object data, Class<T> classType);
}
