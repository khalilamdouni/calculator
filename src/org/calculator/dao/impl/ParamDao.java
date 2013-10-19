package org.calculator.dao.impl;

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

}
