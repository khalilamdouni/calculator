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

@Controller
public class ExecutionPlanController {

	private IExecutionPlanManager executionPlanManager;

	@RequestMapping(value = "/getExecutionPlans", method = RequestMethod.GET)
	public ModelAndView getExecutionPlans() {
		return new ModelAndView("executionPlanTree", "executionPlans",
				executionPlanManager.getExecutionPlans());
	}

	@RequestMapping(value = "/getExecutionPlan/{executionPlanId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ExecutionPlan getExecutionPlan(
			@PathVariable("executionPlanId") long executionPlanId) {
		return executionPlanManager.getExecutionPlan(executionPlanId);
	}

	@RequestMapping(value = "/saveExecutionPlan", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveExecutionPlan(@RequestBody ExecutionPlan executionPlan) {
		executionPlanManager.saveExecutionPlan(executionPlan);
		return "redirect:getExecutionPlans";
	}

	@RequestMapping(value = "deleteExecutionPlan/{executionPlanId}", method = RequestMethod.GET)
	public String deleteExecutionPlan(
			@PathVariable("executionPlanId") long executionPlanId) {
		executionPlanManager.delete(executionPlanId);
		return "redirect:getExecutionPlans";
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
