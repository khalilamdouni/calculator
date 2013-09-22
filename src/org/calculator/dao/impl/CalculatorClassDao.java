package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.calculator.dao.ICalculatorClassDao;
import org.calculator.models.CalculatorClass;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("calculatorClassDao")
@Transactional
public class CalculatorClassDao implements ICalculatorClassDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses) {
		
		for (CalculatorClass calculatorClass : calculatorClasses) {
			em.persist(calculatorClass);
		}
		em.flush();
	}

	@Override
	public CalculatorClass getClassById(long id) {
		TypedQuery<CalculatorClass> query = em.createNamedQuery(
				"CalculatorClass.getClassById", CalculatorClass.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

}
