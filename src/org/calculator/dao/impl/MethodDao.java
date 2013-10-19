package org.calculator.dao.impl;

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

}
