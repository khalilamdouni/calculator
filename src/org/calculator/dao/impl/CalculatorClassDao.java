package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.calculator.dao.ICalculatorClassDao;
import org.calculator.models.impl.CalculatorClass;
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

}
