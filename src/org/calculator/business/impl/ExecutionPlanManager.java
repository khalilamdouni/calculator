package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IExecutionPlanManager;
import org.calculator.dao.IExecutionPlanDao;
import org.calculator.models.ExecutionPlan;

public class ExecutionPlanManager implements IExecutionPlanManager {
	
	private IExecutionPlanDao executionPlanDao;

	@Override
	public List<ExecutionPlan> getExecutionPlans() {
		return executionPlanDao.getExecutionPlans();
	}

	@Override
	public ExecutionPlan getExecutionPlan(long id) {
		return executionPlanDao.getExecutionPlan(id);
	}

	@Override
	public void saveExecutionPlan(ExecutionPlan executionplan) {
		
		executionPlanDao.saveExecutionPlan(executionplan);

	}

	@Override
	public void delete(long id) {
		
		executionPlanDao.delete(id);

	}

	public IExecutionPlanDao getExecutionPlanDao() {
		return executionPlanDao;
	}

	public void setExecutionPlanDao(IExecutionPlanDao executionPlanDao) {
		this.executionPlanDao = executionPlanDao;
	}

}
