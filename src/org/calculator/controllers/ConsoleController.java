package org.calculator.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.calculator.business.ICalculationEngine;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		return new ModelAndView("console", "consoleModel", consoleModel);
	}
	
	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public ModelAndView calculate(@ModelAttribute("consoleModel") ConsoleModel consoleModel, BindingResult result) {
		logger.info("id : " + consoleModel.getSelectedAlgo());
		logger.info("algos : " + consoleModel.getAlgos());
		
		List<IAlgorithme> algos = new ArrayList<IAlgorithme>();
		algos.add(new HeapSortAlgo("1", "HeapSort"));
		algos.add(new InsertionSortAlgo("2", "InsertionSort"));
		algos.add(new MergeSortAlgo("3", "MergeSort"));
		algos.add(new SelectionSortAlgo("4", "SelectionSort"));
		algos.add(new TimSort("5", "TimSort"));
		consoleModel.setAlgos(algos);
		
		IAlgorithme selectedAlgo = null;
		for (IAlgorithme algo : consoleModel.getAlgos()) {
			if (algo.getId().equals(consoleModel.getSelectedAlgo()))
				selectedAlgo = algo;
		}
		
		consoleModel.setResults(this.calculationEngine.calculate(selectedAlgo, dataGenerator));
		return new ModelAndView("console", "consoleModel", consoleModel);
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
	
	
	
	
	
}
