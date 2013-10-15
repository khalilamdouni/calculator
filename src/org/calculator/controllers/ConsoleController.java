package org.calculator.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.calculator.business.ICalculationEngine;
import org.calculator.business.IClassManager;
import org.calculator.business.IExecutionPlanManager;
import org.calculator.business.IJarManager;
import org.calculator.business.generators.IDataGenerator;
import org.calculator.models.ConsoleModel;
import org.calculator.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Controller of the principal functionality of the calculator; handles all
 * requests to the calculation engine
 * 
 * @author khalil.amdouni
 * 
 */
@Controller
public class ConsoleController {

	private ICalculationEngine calculationEngine;

	private IDataGenerator dataGenerator;

	private IJarManager jarManager;

	private IClassManager classManager;

	private IExecutionPlanManager executionPlanManager;

	private static final Logger logger = Logger
			.getLogger(ConsoleController.class);

	/**
	 * Handles the query gettin the Console view
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public ModelAndView calculate() {
		ConsoleModel consoleModel = new ConsoleModel();
		consoleModel.setJarFiles(jarManager.loadJars(-1, -1));
		consoleModel
				.setExecutionPlans(executionPlanManager.getExecutionPlans());
		return new ModelAndView("console", "consoleModel", consoleModel);
	}

	/**
	 * Handles the calculation query of a class that implements IAlgorithme
	 * interface
	 * 
	 * @param selectedAlgoId
	 * @return List of Result as JSON
	 * @throws NumberFormatException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	@RequestMapping(value = "/calculate/{selectedAlgoId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<Result> calculateResult(
			@PathVariable("selectedAlgoId") String selectedAlgoId)
			throws NumberFormatException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException {

		return this.calculationEngine.calculate(
				classManager.loadCalculatorClass(Long.valueOf(selectedAlgoId)),
				dataGenerator);
	}

	/**
	 * Handles the calculation query of a method stored in the database
	 * 
	 * @param selectedMethod
	 * @return List of Result as JSON
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "/calculateMethod/{selectedMethod}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<Result> calculateMethod(
			@PathVariable("selectedMethod") long selectedMethod)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException, NoSuchMethodException,
			SecurityException, IllegalArgumentException,
			InvocationTargetException {

		return this.calculationEngine.calculate(selectedMethod);
	}

	/**
	 * Handles the calculation query of an execution plan (a scenarios of
	 * methods)
	 * 
	 * @param executionPlanId
	 * @return List of Result as JSON
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "/calculateExecutionPlan/{executionPlanId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<Result> calculateExecutionPlan(
			@PathVariable("executionPlanId") long executionPlanId)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException, NoSuchMethodException,
			SecurityException, IllegalArgumentException,
			InvocationTargetException {
		return calculationEngine.calculatePlan(executionPlanId);
	}

	public ICalculationEngine getCalculationEngine() {
		return calculationEngine;
	}

	@Autowired
	@Qualifier(value = "calculationEngine")
	public void setCalculationEngine(ICalculationEngine calculationEngine) {
		this.calculationEngine = calculationEngine;
	}

	public IDataGenerator getDataGenerator() {
		return dataGenerator;
	}

	@Autowired
	@Qualifier(value = "dataGenerator")
	public void setDataGenerator(IDataGenerator dataGenerator) {
		this.dataGenerator = dataGenerator;
	}

	public IJarManager getJarManager() {
		return jarManager;
	}

	@Autowired
	@Qualifier(value = "jarManager")
	public void setJarManager(IJarManager jarManager) {
		this.jarManager = jarManager;
	}

	public IClassManager getClassManager() {
		return classManager;
	}

	@Autowired
	@Qualifier(value = "classManager")
	public void setClassManager(IClassManager classManager) {
		this.classManager = classManager;
	}

	public IExecutionPlanManager getExecutionPlanManager() {
		return executionPlanManager;
	}

	@Autowired
	@Qualifier(value = "executionPlanManager")
	public void setExecutionPlanManager(
			IExecutionPlanManager executionPlanManager) {
		this.executionPlanManager = executionPlanManager;
	}

}
