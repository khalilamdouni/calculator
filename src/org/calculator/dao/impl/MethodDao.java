package org.calculator.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalculatorClassMethod saveMethod(CalculatorClassMethod method) {
		// TODO Auto-generated method stub
		return null;
	}

}
