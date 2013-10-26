package org.calculator.business.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.calculator.business.ICalculationEngine;
import org.calculator.business.IJarManager;
import org.calculator.business.ITypesManager;
import org.calculator.business.generators.IDataGenerator;
import org.calculator.dao.IMethodDao;
import org.calculator.dao.IjarScenarioDao;
import org.calculator.models.CalculatorClassMethod;
import org.calculator.models.CalculatorMethodParam;
import org.calculator.models.IAlgorithme;
import org.calculator.models.JarScenario;
import org.calculator.models.Result;
import org.calculator.security.CalculatorSecurityManager;

/**
 * @see org.calculator.business.ICalculationEngine
 * 
 * @author khalil.amdouni
 * 
 */
public class CalculationEngine implements ICalculationEngine {

	private static final Logger logger = Logger
			.getLogger(CalculationEngine.class);

	private IDataGenerator dataGenerator;
	private IMethodDao methodDao;
	private IJarManager jarManager;
	private ITypesManager typesManager;
	private IjarScenarioDao jarScenarioDao;

	@Override
	public List<Result> calculate(IAlgorithme algo) {

		CalculatorSecurityManager csm = new CalculatorSecurityManager();
		List<Result> results = new ArrayList<Result>();
		for (int dataSize = 1000; dataSize < 30000; dataSize += 1000) {
			algo.setData((Object[]) dataGenerator.generateData(dataSize, 0, 0,
					false));
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

	private int maxTabSize(Map<Integer, Object>[] datas) {
		int max = 0;
		for (Map<Integer, Object> map : datas) {
			if (map.size() > max) {
				max = map.size();
			}
		}
		return max;
	}

	private void initTab(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			tab[i] = 0;
		}
	}

	private long dataSizeAvg(Map<Integer, Object>[] datas, int[] indexes) {
		long sum = 0;
		int i = 0;
		for (Map<Integer, Object> map : datas) {
			sum = sum
					+ ((Integer) map.keySet().toArray()[indexes[i] - 1])
							.longValue();
			i++;
		}
		return (long) (sum / datas.length);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Result> calculate(CalculatorClassMethod method) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, IOException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {

		List<Result> results = new ArrayList<Result>();
		// getting the method entity

		// charging the jar and instance of the object
		Class<?> classInstance = jarManager.loadClassesAndGetInstance(method
				.getCalculatorClass().getJarFile().getJarId(), method
				.getCalculatorClass().getName());
		List<CalculatorMethodParam> params = method.getParams();
		// generating data

		Class<?>[] paramTypes = new Class<?>[params.size()];
		Map[] datas = (Map[]) new Map[params.size()];

		// preparing params
		int i = 0;
		for (CalculatorMethodParam param : params) {
			dataGenerator.generateDataForParam(param);
			typesManager.detectType(param);
			paramTypes[i] = param.getParamType();
			datas[i] = param.getGeneratedDatas();
			i++;
		}

		int dataMaxSize = maxTabSize(datas);
		int[] dataSizes = new int[datas.length];
		Object[] iterationDatas = new Object[datas.length];
		CalculatorSecurityManager csm = new CalculatorSecurityManager();
		// calculation
		initTab(dataSizes);
		for (int j = 0; j < dataMaxSize; j++) {
			for (int k = 0; k < datas.length; k++) {
				iterationDatas[k] = datas[k].values().toArray()[dataSizes[k]];
				if (j < datas[k].size()) {
					dataSizes[k]++;
				}
			}
			Object instance = classInstance.newInstance();
			Method reflectedMethod = classInstance.getDeclaredMethod(
					method.getName(), paramTypes);
			logger.info("Installing the calculator securityManager");
			/*
			 * SecurityManager old = System.getSecurityManager();
			 * System.setSecurityManager(csm);
			 */
			long execTime = 0;
			long beginTime = System.currentTimeMillis();

			reflectedMethod.invoke(instance,
					typesManager.transformData(params, iterationDatas));

			execTime = System.currentTimeMillis() - beginTime;
			// System.setSecurityManager(old);
			logger.info("Closing the calculator securityManager");
			results.add(new Result(dataSizeAvg(datas, dataSizes), execTime));
		}

		return results;
	}

	private int maxResultsSize(List<List<Result>> reults) {
		int max = 0;
		for (List<Result> list : reults) {
			if (list.size() > max) {
				max = list.size();
			}
		}
		return max;
	}

	private List<Result> mergeResults(List<List<Result>> results) {

		List<Result> avgResults = new ArrayList<Result>();
		int maxSize = maxResultsSize(results);
		int n = 0;
		long x = 0;
		double y = 0;
		for (int i = 0; i < maxSize; i++) {
			n = 0;
			x = 0;
			y = 0;
			for (List<Result> list : results) {
				if (i < list.size()) {
					n++;
					x += list.get(i).getX();
					y += list.get(i).getY();
				}
			}
			assert n > 0;
			avgResults.add(new Result((long) x / n, y));
		}
		return avgResults;
	}

	@Override
	public List<Result> calculate(JarScenario jarScenario)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IOException, NoSuchMethodException,
			SecurityException, IllegalArgumentException,
			InvocationTargetException {
		List<List<Result>> results = new ArrayList<List<Result>>();

		String[] methodIds = jarScenario.getSequence().split("-");
		for (int i = 0; i < methodIds.length; i++) {
			results.add(calculate(methodDao.getById(Long.valueOf(methodIds[i]))));
		}
		return mergeResults(results);
	}

	public IDataGenerator getDataGenerator() {
		return dataGenerator;
	}

	public void setDataGenerator(IDataGenerator dataGenerator) {
		this.dataGenerator = dataGenerator;
	}

	public IMethodDao getMethodDao() {
		return methodDao;
	}

	public void setMethodDao(IMethodDao methodDao) {
		this.methodDao = methodDao;
	}

	public IJarManager getJarManager() {
		return jarManager;
	}

	public void setJarManager(IJarManager jarManager) {
		this.jarManager = jarManager;
	}

	public ITypesManager getTypesManager() {
		return typesManager;
	}

	public void setTypesManager(ITypesManager typesManager) {
		this.typesManager = typesManager;
	}

	public IjarScenarioDao getJarScenarioDao() {
		return jarScenarioDao;
	}

	public void setJarScenarioDao(IjarScenarioDao jarScenarioDao) {
		this.jarScenarioDao = jarScenarioDao;
	}

}
