package org.calculator.controllers;

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

/**
 * Controller class to handle all execution plan management operations
 * 
 * @author khalil.amdouni
 * 
 */
@Controller
public class ExecutionPlanController {

	private IExecutionPlanManager executionPlanManager;

	/**
	 * Getting all execution plans
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/getExecutionPlans", method = RequestMethod.GET)
	public ModelAndView getExecutionPlans() {
		return new ModelAndView("executionPlanTree", "executionPlans",
				executionPlanManager.getExecutionPlans());
	}

	/**
	 * Getting an execution plan by id
	 * 
	 * @param executionPlanId
	 * @return ExecutionPlan as JSON
	 */
	@RequestMapping(value = "/getExecutionPlan/{executionPlanId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ExecutionPlan getExecutionPlan(
			@PathVariable("executionPlanId") long executionPlanId) {
		return executionPlanManager.get(executionPlanId);
	}

	/**
	 * Creating or updating an execution plan
	 * 
	 * @param executionPlan
	 * @return String; the view name
	 */
	@RequestMapping(value = "/saveExecutionPlan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveExecutionPlan(@RequestBody ExecutionPlan executionPlan) {
		executionPlanManager.save(executionPlan);
		return "redirect:getExecutionPlans";
	}

	/**
	 * Delete an execution plan by id
	 * 
	 * @param executionPlanId
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/deleteExecutionPlan/{executionPlanId}", method = RequestMethod.GET)
	public ModelAndView deleteExecutionPlan(
			@PathVariable("executionPlanId") long executionPlanId) {
		executionPlanManager.delete(executionPlanId);
		return getExecutionPlans();
	}

	public IExecutionPlanManager getExecutionPlanManager() {
		return executionPlanManager;
	}

	@Autowired
	@Qualifier("executionPlanManager")
	public void setExecutionPlanManager(
			IExecutionPlanManager executionPlanManager) {
		this.executionPlanManager = executionPlanManager;
	}

}
