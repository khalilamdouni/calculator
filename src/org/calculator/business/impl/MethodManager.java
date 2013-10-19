package org.calculator.business.impl;

import org.calculator.business.IMethodManager;
import org.calculator.dao.IMethodDao;
import org.calculator.models.CalculatorClassMethod;

/**
 * @see org.calculator.business.IMethodManager
 * 
 * @author khalil.amdouni
 *
 */
public class MethodManager implements IMethodManager {

	private IMethodDao methodDao;
	
	@Override
	public CalculatorClassMethod getMethod(long methodId) {
		return methodDao.getById(methodId);
	}

	@Override
	public CalculatorClassMethod saveMethod(CalculatorClassMethod method) {
		return methodDao.save(method);
	}

	public IMethodDao getMethodDao() {
		return methodDao;
	}

	public void setMethodDao(IMethodDao methodDao) {
		this.methodDao = methodDao;
	}

}
