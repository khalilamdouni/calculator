package org.calculator.business;

import java.util.List;

import org.calculator.models.ExecutionPlan;

public interface IExecutionPlanManager {

	public List<ExecutionPlan> getExecutionPlans();

	public ExecutionPlan getExecutionPlan(long id);

	public void saveExecutionPlan(ExecutionPlan executionplan);

	public void delete(long id);
}
