package org.calculator.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.calculator.business.ICalculationEngine;
import org.calculator.business.IClassManager;
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
 * The Controller of the principal functionality of the calculator
 * 
 * @author khalil AMDOUNI
 *
 */
@Controller
public class ConsoleController {
	
	private ICalculationEngine calculationEngine;
	
	private IDataGenerator dataGenerator;
	
	private IJarManager jarManager;
	
	private IClassManager classManager;
	
	private static final Logger logger = Logger.getLogger(ConsoleController.class);
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public ModelAndView calculate() {
		ConsoleModel consoleModel = new ConsoleModel();
		consoleModel.setJarFiles(jarManager.loadJars(-1, -1));
		return new ModelAndView("console", "consoleModel", consoleModel);
	}
	
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
	
}
