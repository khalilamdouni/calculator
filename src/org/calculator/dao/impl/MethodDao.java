package org.calculator.dao.impl;

import javax.persistence.TypedQuery;

import org.calculator.dao.IMethodDao;
import org.calculator.models.CalculatorClassMethod;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see org.calculator.dao.IMethodDao
 * 
 * @author khalil.amdouni
 * 
 */
@Repository("methodDao")
@Transactional
public class MethodDao extends GenericDao<CalculatorClassMethod> implements
		IMethodDao {

	public MethodDao() {
		super(CalculatorClassMethod.class);
	}
	
	
	
/*
	@Override
	public CalculatorClassMethod getMethod(long methodId) {
		TypedQuery<CalculatorClassMethod> query = em.createNamedQuery(
				"CalculatorClassMethod.getMethodById",
				CalculatorClassMethod.class);
		query.setParameter("id", methodId);
		return query.getSingleResult();
	}

	@Override
	public CalculatorClassMethod saveMethod(CalculatorClassMethod method) {

		return em.merge(method);
	}
*/
}
