package org.calculator.controllers;

import org.apache.log4j.Logger;
import org.calculator.business.IWebRequestManager;
import org.calculator.business.IWebScenarioManager;
import org.calculator.models.WebScenario;
import org.calculator.models.viewmodels.WebScenarioViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Web scenarios CRUD controller
 * 
 * @author khalil.amdouni
 *
 */
@Controller
public class WebScenarioController {
	
	private IWebScenarioManager webScenarioManager;
	private IWebRequestManager webRequestManager;
	
	private final static Logger logger = Logger.getLogger(WebScenarioController.class);
	
	@RequestMapping(value = "/webScenarioManager", method = RequestMethod.GET)
	public ModelAndView webScenarioManager() {
		WebScenarioViewModel webScenarioViewModel = new WebScenarioViewModel();
		webScenarioViewModel.setWebScenarios(webScenarioManager
				.getWebScenarios());
		return new ModelAndView("webScenarioManager", "webScenarioViewModel",
				webScenarioViewModel);
	}

	@RequestMapping(value = "/addScenario/{scenarioName}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	WebScenario addWebscenario(@PathVariable("scenarioName") String scenarioName) {
		WebScenario webScenario = new WebScenario();
		webScenario.setName(scenarioName);
		return webScenarioManager.save(webScenario);
	}
	
	@RequestMapping(value = "/getScenario/{scenarioId}", method = RequestMethod.GET)
	public ModelAndView getScenario(@PathVariable("scenarioId") long scenarioId) {
		
		return new ModelAndView("webScenarioView", "webScenarioModel",
				webRequestManager.populateWebScenario(webScenarioManager.get(scenarioId)));
	}
	
	@RequestMapping(value = "/reorderRequests/{requestsSequence}/{scenarioId}", method = RequestMethod.POST)
	public @ResponseBody String reorderRequests(@PathVariable("requestsSequence") String requestsSequence, @PathVariable("scenarioId") long scenarioId) {
		
		WebScenario webScenario = webScenarioManager.get(scenarioId);
		webScenario.setSequence(requestsSequence);
		webScenarioManager.save(webScenario);
		return "OK";
	}

	public IWebScenarioManager getWebScenarioManager() {
		return webScenarioManager;
	}

	@Autowired
	@Qualifier(value = "webScenarioManager")
	public void setWebScenarioManager(IWebScenarioManager webScenarioManager) {
		this.webScenarioManager = webScenarioManager;
	}

	public IWebRequestManager getWebRequestManager() {
		return webRequestManager;
	}

	@Autowired
	@Qualifier(value = "webRequestManager")
	public void setWebRequestManager(IWebRequestManager webRequestManager) {
		this.webRequestManager = webRequestManager;
	}
	
}
