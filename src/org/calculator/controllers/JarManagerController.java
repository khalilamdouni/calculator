package org.calculator.controllers;

import org.apache.log4j.Logger;
import org.calculator.models.impl.JarManagerModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JarManagerController {

	private static final Logger logger = Logger
			.getLogger(JarManagerController.class);

	@RequestMapping(value = "/jarManager", method = RequestMethod.GET)
	public ModelAndView jarManager() {
		JarManagerModel jarManagerModel = new JarManagerModel();
		return new ModelAndView("jarManager", "jarManagerModel",
				jarManagerModel);
	}

	@RequestMapping(value = "/jarManager", method = RequestMethod.POST)
	public ModelAndView jarManager(
			@ModelAttribute("jarManagerModel") JarManagerModel jarManagerModel,
			BindingResult result) {
		logger.info("file name : "
				+ jarManagerModel.getJarFile().getOriginalFilename());
		return new ModelAndView("jarManager", "jarManagerModel",
				jarManagerModel);
	}

}
