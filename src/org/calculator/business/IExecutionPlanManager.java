package org.calculator.business;

import java.util.List;

import org.calculator.models.ExecutionPlan;

/**
 * The interface of the execution plan manager which is responsible for managing
 * execution plans (scenarios of methods)
 * 
 * @author khalil.amdouni
 * 
 */
public interface IExecutionPlanManager {

	/**
	 * Getting all execution plans
	 * 
	 * @return List of ExecutionPlan
	 */
	public List<ExecutionPlan> getExecutionPlans();

	/**
	 * Getting execution plan by id
	 * 
	 * @param id
	 * @return ExecutionPlan
	 */
	public ExecutionPlan getExecutionPlan(long id);

	/**
	 * Saving execution plan
	 * 
	 * @param executionplan
	 */
	public void saveExecutionPlan(ExecutionPlan executionplan);

	/**
	 * Delete of execution plan
	 * 
	 * @param id
	 */
	public void delete(long id);
}
