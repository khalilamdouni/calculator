package org.calculator.business.impl;

import org.calculator.business.IMethodManager;
import org.calculator.dao.IMethodDao;
import org.calculator.models.CalculatorClassMethod;

public class MethodManager implements IMethodManager {

	private IMethodDao methodDao;
	
	@Override
	public CalculatorClassMethod getMethod(long methodId) {
		return methodDao.getMethod(methodId);
	}

	@Override
	public CalculatorClassMethod saveMethod(CalculatorClassMethod method) {
		return methodDao.saveMethod(method);
	}

	public IMethodDao getMethodDao() {
		return methodDao;
	}

	public void setMethodDao(IMethodDao methodDao) {
		this.methodDao = methodDao;
	}

}
