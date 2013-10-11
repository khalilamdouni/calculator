package org.calculator.controllers;

import java.util.List;

import org.calculator.business.IExecutionPlanManager;
import org.calculator.models.ExecutionPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExecutionPlanController {
	
	private IExecutionPlanManager executionPlanManager;

	@RequestMapping(value = "/saveExecutionPlan", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	List<ExecutionPlan> saveExecutionPlan(
			@RequestBody ExecutionPlan executionPlan) {
		executionPlanManager.saveExecutionPlan(executionPlan);
		return executionPlanManager.getExecutionPlans();
	}

	@RequestMapping(value = "/getExecutionPlan/{executionPlanId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ExecutionPlan getExecutionPlan(
			@PathVariable("executionPlanId") long executionPlanId) {
		return executionPlanManager.getExecutionPlan(executionPlanId);
	}
	
	@RequestMapping(value = "deleteExecutionPlan/{executionPlanId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ExecutionPlan> deleteExecutionPlan(@PathVariable("executionPlanId") long executionPlanId) {
		executionPlanManager.delete(executionPlanId);
		return executionPlanManager.getExecutionPlans();
	}
	
	public IExecutionPlanManager getExecutionPlanManager() {
		return executionPlanManager;
	}

	@Autowired
	@Qualifier("executionPlanManager")
	public void setExecutionPlanManager(IExecutionPlanManager executionPlanManager) {
		this.executionPlanManager = executionPlanManager;
	}
	
	
	
}
