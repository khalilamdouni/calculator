package org.calculator.dao.impl;

import java.util.List;

import org.calculator.dao.ICalculatorClassDao;
import org.calculator.models.CalculatorClass;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see org.calculator.dao.ICalculatorClassDao
 * 
 * @author khalil.amdouni
 *
 */
@Repository("calculatorClassDao")
@Transactional
public class CalculatorClassDao extends GenericDao<CalculatorClass> implements ICalculatorClassDao {
	
	
	
	public CalculatorClassDao() {
		super(CalculatorClass.class);
	}

	@Override
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses) {
		
		for (CalculatorClass calculatorClass : calculatorClasses) {
			em.persist(calculatorClass);
		}
		em.flush();
	}

}
