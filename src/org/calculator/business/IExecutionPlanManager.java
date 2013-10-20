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
public interface IExecutionPlanManager extends IGenericManager<ExecutionPlan> {

	/**
	 * Getting all execution plans
	 * 
	 * @return List of ExecutionPlan
	 */
	public List<ExecutionPlan> getExecutionPlans();

}
