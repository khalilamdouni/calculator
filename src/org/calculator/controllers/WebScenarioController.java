package org.calculator.controllers;

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
	
	@RequestMapping(value = "/webScenarioManager", method = RequestMethod.GET)
	public ModelAndView webScenarioManager() {
		WebScenarioViewModel webScenarioViewModel = new WebScenarioViewModel();
		webScenarioViewModel.setWebScenarios(webScenarioManager
				.getWebScenarios());
		return new ModelAndView("webScenarioManager", "webScenarioViewModel",
				webScenarioViewModel);
	}

	@RequestMapping(value = "/addScenario/{scenarioTitle}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	WebScenario addWebscenario(@PathVariable("scenarioTitle") String title) {
		WebScenario webScenario = new WebScenario();
		webScenario.setTitle(title);
		return webScenarioManager.save(webScenario);
	}
	
	public IWebScenarioManager getWebScenarioManager() {
		return webScenarioManager;
	}

	@Autowired
	@Qualifier(value = "webScenarioManager")
	public void setWebScenarioManager(IWebScenarioManager webScenarioManager) {
		this.webScenarioManager = webScenarioManager;
	}
	
}
