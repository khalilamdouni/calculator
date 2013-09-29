package org.calculator.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.calculator.business.IClassManager;
import org.calculator.business.IJarManager;
import org.calculator.models.JarFileModel;
import org.calculator.models.JarManagerModel;
import org.calculator.models.viewmodels.JSONJTableModel;
import org.calculator.models.viewmodels.JSONJTableResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JarManagerController {

	private static final Logger logger = Logger.getLogger(JarManagerController.class);

	private IJarManager jarManager;
	private IClassManager classManager;

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

		this.classManager.saveCalculatorClasses(jarManagerModel
				.getCalculatorClasses());
		return "redirect:jarManager";
	}
	
	@RequestMapping(value = "/getJars", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableModel getJars(@RequestParam int jtStartIndex,
			@RequestParam int jtPageSize) {
		return new JSONJTableModel("OK", this.jarManager.loadJars(jtStartIndex,
				jtPageSize), this.jarManager.getJarsCount());
	}
	
	@RequestMapping(value = "/updateJar", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel updateJar(@ModelAttribute JarFileModel jarFile,
			BindingResult result) {
		return new JSONJTableResponseModel("OK",
				this.jarManager.updateJar(jarFile));
	}
	
	@RequestMapping(value = "/deleteJar", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel deleteJar(@RequestParam String jarId) {
		this.jarManager.deleteJar(jarId);
		return new JSONJTableResponseModel("OK");
	}

	public IJarManager getJarManager() {
		return jarManager;
	}

	@Autowired
	@Qualifier("jarManager")
	public void setJarManager(IJarManager jarManager) {
		this.jarManager = jarManager;
	}

	public IClassManager getClassManager() {
		return classManager;
	}

	@Autowired
	@Qualifier("classManager")
	public void setClassManager(IClassManager classManager) {
		this.classManager = classManager;
	}

}
