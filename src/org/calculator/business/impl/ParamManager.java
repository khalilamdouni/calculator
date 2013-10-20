package org.calculator.business.impl;

import org.calculator.business.IParamManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.IParamDao;
import org.calculator.models.CalculatorMethodParam;

/**
 * @see org.calculator.business.IParamManager
 * 
 * @author khalil.amdouni
 *
 */
public class ParamManager extends GenericManager<CalculatorMethodParam> implements IParamManager {

	private IParamDao paramDao;

	public IParamDao getParamDao() {
		return paramDao;
	}

	public void setParamDao(IParamDao paramDao) {
		this.paramDao = paramDao;
	}

	@Override
	public IGenericDao<CalculatorMethodParam> getDao() {
		return (IGenericDao<CalculatorMethodParam>) paramDao;
	}
	
}
