package org.calculator.business.impl;

import org.calculator.business.IParamManager;
import org.calculator.dao.IParamDao;
import org.calculator.models.CalculatorMethodParam;

public class ParamManager implements IParamManager {

	private IParamDao paramDao;
	
	@Override
	public CalculatorMethodParam getParam(long paramId) {
		return paramDao.getParam(paramId);
	}

	@Override
	public CalculatorMethodParam saveParam(
			CalculatorMethodParam calculatorMethodParam) {
		return paramDao.saveParam(calculatorMethodParam);
	}

	public IParamDao getParamDao() {
		return paramDao;
	}

	public void setParamDao(IParamDao paramDao) {
		this.paramDao = paramDao;
	}
	
}
