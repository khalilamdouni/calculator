package org.calculator.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.calculator.dao.IMethodDao;
import org.calculator.models.CalculatorClassMethod;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("methodDao")
@Transactional
public class MethodDao implements IMethodDao {

	@PersistenceContext
	private EntityManager em;
	
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

}
