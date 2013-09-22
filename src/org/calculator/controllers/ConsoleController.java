package org.calculator.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.calculator.business.ICalculationEngine;
import org.calculator.business.IJarManager;
import org.calculator.business.generators.IDataGenerator;
import org.calculator.models.IAlgorithme;
import org.calculator.models.impl.ConsoleModel;
import org.calculator.models.impl.HeapSortAlgo;
import org.calculator.models.impl.InsertionSortAlgo;
import org.calculator.models.impl.MergeSortAlgo;
import org.calculator.models.impl.Result;
import org.calculator.models.impl.SelectionSortAlgo;
import org.calculator.models.impl.TimSort;
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
	
	private static final Logger logger = Logger.getLogger(ConsoleController.class);
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public ModelAndView calculate() {
		ConsoleModel consoleModel = new ConsoleModel();
		List<IAlgorithme> algos = new ArrayList<IAlgorithme>();
		algos.add(new HeapSortAlgo("1", "HeapSort"));
		algos.add(new InsertionSortAlgo("2", "InsertionSort"));
		algos.add(new MergeSortAlgo("3", "MergeSort"));
		algos.add(new SelectionSortAlgo("4", "SelectionSort"));
		algos.add(new TimSort("5", "TimSort"));
		consoleModel.setAlgos(algos);
		consoleModel.setJarFiles(jarManager.loadJars());
		return new ModelAndView("console", "consoleModel", consoleModel);
	}
	
	@RequestMapping(value = "/calculate/{selectedAlgoId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Result> calculateResult(@PathVariable("selectedAlgoId") String selectedAlgoId) {
		
		logger.info("id : " + selectedAlgoId);
		
		List<IAlgorithme> algos = new ArrayList<IAlgorithme>();
		algos.add(new HeapSortAlgo("1", "HeapSort"));
		algos.add(new InsertionSortAlgo("2", "InsertionSort"));
		algos.add(new MergeSortAlgo("3", "MergeSort"));
		algos.add(new SelectionSortAlgo("4", "SelectionSort"));
		algos.add(new TimSort("5", "TimSort"));

		
		IAlgorithme selectedAlgo = null;
		for (IAlgorithme algo : algos) {
			if (algo.getId().equals(selectedAlgoId))
				selectedAlgo = algo;
		}
		

		return this.calculationEngine.calculate(selectedAlgo, dataGenerator);

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
	
}
