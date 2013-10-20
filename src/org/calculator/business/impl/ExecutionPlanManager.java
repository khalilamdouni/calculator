package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IExecutionPlanManager;
import org.calculator.dao.IExecutionPlanDao;
import org.calculator.dao.IGenericDao;
import org.calculator.models.ExecutionPlan;

/**
 * @see  org.calculator.business.IExecutionPlanManager
 * 
 * @author khalil.amdouni
 *
 */
public class ExecutionPlanManager extends GenericManager<ExecutionPlan> implements IExecutionPlanManager {
	
	private IExecutionPlanDao executionPlanDao;

	@Override
	public List<ExecutionPlan> getExecutionPlans() {
		return executionPlanDao.getExecutionPlans();
	}

	public IExecutionPlanDao getExecutionPlanDao() {
		return executionPlanDao;
	}

	public void setExecutionPlanDao(IExecutionPlanDao executionPlanDao) {
		this.executionPlanDao = executionPlanDao;
	}

	@Override
	public IGenericDao<ExecutionPlan> getDao() {
		return (IGenericDao<ExecutionPlan>) executionPlanDao;
	}

}
