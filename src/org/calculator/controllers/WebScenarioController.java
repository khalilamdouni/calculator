package org.calculator.controllers;

import org.apache.log4j.Logger;
import org.calculator.business.IWebParamManager;
import org.calculator.business.IWebRequestManager;
import org.calculator.business.IWebScenarioManager;
import org.calculator.models.WebParam;
import org.calculator.models.WebRequest;
import org.calculator.models.WebScenario;
import org.calculator.models.viewmodels.JSONJTableModel;
import org.calculator.models.viewmodels.JSONJTableResponseModel;
import org.calculator.models.viewmodels.WebScenarioViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	private IWebParamManager webParamManager;
	
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
	
	@RequestMapping(value = "/addRequest/{scenarioId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView addRequest(@RequestBody WebRequest webRequest,
			@PathVariable("scenarioId") long scenarioId) {

		WebRequest savedWebRequest = webRequestManager.save(webRequest);
		webScenarioManager.addWebRequestToWebScenario(scenarioId,
				savedWebRequest.getId());
		return getScenario(scenarioId);
	}
	
	@RequestMapping(value = "/getRequest/{requestId}", method = RequestMethod.GET)
	public ModelAndView getRequest(@PathVariable("requestId") long requestId) {
		return new ModelAndView("webRequestView", "webRequestModel",
				webRequestManager.get(requestId));
	}
	
	@RequestMapping(value = "/updateRequest", method = RequestMethod.POST)
	public ModelAndView updateRequest(@RequestBody WebRequest webRequest) {
		webRequestManager.save(webRequest);
		return getRequest(webRequest.getId());
	}
	
	@RequestMapping(value = "/deleteRequest/{requestId}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deleteRequest(@PathVariable("requestId") long requestId) {
		webRequestManager.delete(requestId);
		return "OK";
	}
	
	@RequestMapping(value = "/getWebParams/{requestId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableModel<WebParam> getWebParams(@RequestParam int jtStartIndex,
			@RequestParam int jtPageSize,
			@PathVariable("requestId") long requestId) {
		return new JSONJTableModel<WebParam>("OK",
				this.webParamManager.getWebParamByRequestId(requestId,
						jtStartIndex, jtPageSize),
				this.webParamManager.getWebParamsCount(requestId));
	}

	@RequestMapping(value = "/addWebParam/{requestId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<WebParam> addWebParam(
			@ModelAttribute WebParam webParam,
			@PathVariable("requestId") long requestId, BindingResult result) {
		webParam.setRequestId(requestId);
		return new JSONJTableResponseModel<WebParam>("OK",
				this.webParamManager.save(webParam));
	}

	@RequestMapping(value = "/updateWebParam", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<WebParam> updateWebParam(
			@ModelAttribute WebParam webParam, BindingResult result) {
		return new JSONJTableResponseModel<WebParam>("OK",
				this.webParamManager.save(webParam));
	}

	@RequestMapping(value = "/deleteWebParam", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<WebParam> deleteWebParam(
			@RequestParam long webParamId) {
		webParamManager.delete(webParamId);
		return new JSONJTableResponseModel<WebParam>("OK");
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

	public IWebParamManager getWebParamManager() {
		return webParamManager;
	}

	@Autowired
	@Qualifier(value = "webParamManager")
	public void setWebParamManager(IWebParamManager webParamManager) {
		this.webParamManager = webParamManager;
	}
	
}
