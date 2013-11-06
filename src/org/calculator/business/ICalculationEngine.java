package org.calculator.business;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.calculator.business.generators.IDataGenerator;
import org.calculator.models.CalculatorClassMethod;
import org.calculator.models.IAlgorithme;
import org.calculator.models.JarScenario;
import org.calculator.models.Result;
import org.calculator.models.WebScenario;

/**
 * The Interface of the calculation engine, which has three principal
 * functionalities; calculation of class that implements the IAlgorithme
 * interface, a java method stored in the database or a jar scenario
 * 
 * @author khalil.amdouni
 * 
 */
public interface ICalculationEngine {

	/**
	 * Calculates a class that implements the IAlgorithme interface
	 * 
	 * @param algo
	 * @param dataGenerator
	 * @return List of Results
	 * 
	 */
	public List<Result> calculate(IAlgorithme algo);

	/**
	 * Calculates a java method stored in the database
	 * 
	 * @param methodId
	 * @return List of Results
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<Result> calculate(CalculatorClassMethod method) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException;

	/**
	 * Calculates an execution plan (a scenario of methods)
	 * 
	 * @param planId
	 * @return List of Results
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public List<Result> calculate(JarScenario jarScenario)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException, NoSuchMethodException,
			SecurityException, IllegalArgumentException,
			InvocationTargetException;
	
	/**
	 * Calculates a webRequest (Scenario of web requests)
	 * 
	 * @param webScenario
	 * @return List of Results
	 */
	public List<Result> calculate(WebScenario webScenario);
}
