package org.calculator.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.calculator.business.IJarManager;
import org.calculator.models.JSONJTableModel;
import org.calculator.models.JarFileModel;
import org.calculator.models.JarManagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JarManagerController {

	private static final Logger logger = Logger.getLogger(JarManagerController.class);

	private IJarManager jarManager;

	@RequestMapping(value = "/jarManager", method = RequestMethod.GET)
	public ModelAndView jarManager() {
		JarManagerModel jarManagerModel = new JarManagerModel();
		return new ModelAndView("jarManager", "jarManagerModel",
				jarManagerModel);
	}

	@RequestMapping(value = "/uploadJar", method = RequestMethod.POST)
	public ModelAndView uploadJar(
			@ModelAttribute("jarManagerModel") JarManagerModel jarManagerModel,
			BindingResult result) throws IllegalStateException, IOException,
			ClassNotFoundException {
		
		jarManagerModel.setCalculatorClasses(this.jarManager
				.reflectJar(this.jarManager.saveJar(jarManagerModel
						.getJarFile())));
		
		return new ModelAndView("jarManager", "jarManagerModel",
				jarManagerModel);
	}
	
	@RequestMapping(value = "/saveClasses", method = RequestMethod.POST)
	public String saveCalculatorClasses(
			@ModelAttribute("jarManagerModel") JarManagerModel jarManagerModel,
			BindingResult result) {

		this.jarManager.saveCalculatorClasses(jarManagerModel
				.getCalculatorClasses());
		return "redirect:jarManager";
	}
	
	@RequestMapping(value = "/getJars", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody JSONJTableModel getJars() {
		logger.info("CALLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
		List<JarFileModel> result = this.jarManager.loadJars();
		logger.info("*******************************************" + result.size());
		return new JSONJTableModel("OK", result, result.size());
	}

	public IJarManager getJarManager() {
		return jarManager;
	}

	@Autowired
	@Qualifier("jarManager")
	public void setJarManager(IJarManager jarManager) {
		this.jarManager = jarManager;
	}

}
