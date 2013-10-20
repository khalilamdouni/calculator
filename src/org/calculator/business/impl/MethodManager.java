package org.calculator.business.impl;

import org.calculator.business.IMethodManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.IMethodDao;
import org.calculator.models.CalculatorClassMethod;

/**
 * @see org.calculator.business.IMethodManager
 * 
 * @author khalil.amdouni
 *
 */
public class MethodManager extends GenericManager<CalculatorClassMethod> implements IMethodManager {

	private IMethodDao methodDao;


	public IMethodDao getMethodDao() {
		return methodDao;
	}

	public void setMethodDao(IMethodDao methodDao) {
		this.methodDao = methodDao;
	}

	@Override
	public IGenericDao<CalculatorClassMethod> getDao() {
		return (IGenericDao<CalculatorClassMethod>) methodDao;
	}

}
