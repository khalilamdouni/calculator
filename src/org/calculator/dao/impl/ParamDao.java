package org.calculator.dao.impl;

import javax.persistence.TypedQuery;

import org.calculator.dao.IParamDao;
import org.calculator.models.CalculatorMethodParam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see org.calculator.dao.IParamDao
 * 
 * @author khalil.amdouni
 *
 */
@Repository("paramDao")
@Transactional
public class ParamDao extends GenericDao<CalculatorMethodParam> implements IParamDao {

	public ParamDao() {
		super(CalculatorMethodParam.class);
	}
	
	/*
	@Override
	public CalculatorMethodParam getParam(long paramId) {
		TypedQuery<CalculatorMethodParam> query = em.createNamedQuery(
				"CalculatorMethodParam.getParamById",
				CalculatorMethodParam.class);
		query.setParameter("id", paramId);
		return query.getSingleResult();
	}

	@Override
	public CalculatorMethodParam saveParam(
			CalculatorMethodParam calculatorMethodParam) {

		return em.merge(calculatorMethodParam);
	}
*/
}
