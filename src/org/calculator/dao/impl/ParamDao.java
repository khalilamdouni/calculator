package org.calculator.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.calculator.dao.IParamDao;
import org.calculator.models.CalculatorMethodParam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("paramDao")
@Transactional
public class ParamDao implements IParamDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CalculatorMethodParam getParam(long paramId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalculatorMethodParam saveParam(
			CalculatorMethodParam calculatorMethodParam) {
		// TODO Auto-generated method stub
		return null;
	}

}
