package org.calculator.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

}
