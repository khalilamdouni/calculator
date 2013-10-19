package org.calculator.dao;

import java.util.List;

import org.calculator.models.ExecutionPlan;

/**
 * The interface of execution plan Data Access Object
 * 
 * @author khalil.amdouni
 *
 */
public interface IExecutionPlanDao extends IGenericDao<ExecutionPlan> {

	public List<ExecutionPlan> getExecutionPlans();

	/*public ExecutionPlan getExecutionPlan(long id);

	public void saveExecutionPlan(ExecutionPlan executionplan);

	public void delete(long id);*/

}
