package org.calculator.controllers;

import org.calculator.business.IJarScenarioManager;
import org.calculator.models.JarScenario;
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
 * Controller class to handle all jar scenarios management operations
 * 
 * @author khalil.amdouni
 * 
 */
@Controller
public class JarScenarioController {

	private IJarScenarioManager jarScenarioManager;

	/**
	 * Getting all jar scenarios
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/getJarScenarios", method = RequestMethod.GET)
	public ModelAndView getJarScenarios() {
		return new ModelAndView("jarScenarioTree", "jarScenarios",
				jarScenarioManager.getJarScenarios());
	}

	/**
	 * Getting an jar scenario by id
	 * 
	 * @param jarScenarioId
	 * @return JarScenario as JSON
	 */
	@RequestMapping(value = "/getJarScenario/{jarScenarioId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	JarScenario getJarScenarioId(
			@PathVariable("jarScenarioId") long jarScenarioId) {
		return jarScenarioManager.get(jarScenarioId);
	}

	/**
	 * Creating or updating a jar scenario
	 * 
	 * @param jarScenario
	 * @return String; the view name
	 */
	@RequestMapping(value = "/saveJarScenario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveJarScenario(@RequestBody JarScenario jarScenario) {
		jarScenarioManager.save(jarScenario);
		return "redirect:getJarScenarios";
	}

	/**
	 * Delete a jar scenario by id
	 * 
	 * @param jarScenarioId
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/deleteJarScenario/{jarScenarioId}", method = RequestMethod.GET)
	public ModelAndView deleteJarScenario(
			@PathVariable("jarScenarioId") long jarScenarioId) {
		jarScenarioManager.delete(jarScenarioId);
		return getJarScenarios();
	}

	public IJarScenarioManager getJarScenarioManager() {
		return jarScenarioManager;
	}

	@Autowired
	@Qualifier(value = "jarScenarioManager")
	public void setJarScenarioManager(IJarScenarioManager jarScenarioManager) {
		this.jarScenarioManager = jarScenarioManager;
	}

}
