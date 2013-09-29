package org.calculator.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.calculator.business.ICalculationEngine;
import org.calculator.business.generators.IDataGenerator;
import org.calculator.models.IAlgorithme;
import org.calculator.models.Result;
import org.calculator.security.CalculatorSecurityManager;

public class CalculationEngine implements ICalculationEngine {

	private static final Logger logger = Logger.getLogger(CalculationEngine.class);
	
	@Override
	public List<Result> calculate(IAlgorithme algo, IDataGenerator dataGenerator) {

		
		CalculatorSecurityManager csm = new CalculatorSecurityManager();
		List<Result> results = new ArrayList<Result>();
		for (int dataSize = 1000; dataSize < 30000; dataSize += 1000) {
			algo.setData((Object[]) dataGenerator.generateData(dataSize, 0, 0));
			algo.transformData();

			logger.info("Installing the calculator securityManager");
			SecurityManager old = System.getSecurityManager();
		    System.setSecurityManager(csm);
			long execTime = 0;
			long beginTime = System.currentTimeMillis();
			algo.run();
			execTime = System.currentTimeMillis() - beginTime;
		    System.setSecurityManager(old);
		    logger.info("Closing the calculator securityManager");
		    
			results.add(new Result((long) dataSize, (double) execTime));
		}
		return results;
	}

}
