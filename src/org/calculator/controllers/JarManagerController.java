package org.calculator.controllers;

import org.calculator.models.impl.JarManagerModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class JarManagerController {
	
	
	@RequestMapping(value = "/jarManager", method = RequestMethod.GET)
	public ModelAndView jarManager() {
		JarManagerModel jarManagerModel = new JarManagerModel();
		return new ModelAndView("jarManager", "jarManagerModel", jarManagerModel);
	}
	
	@RequestMapping(value = "/jarManager", method = RequestMethod.POST)
	public ModelAndView jarManager(@ModelAttribute("jarManagerModel") JarManagerModel jarManagerModel, BindingResult result) {
		return new ModelAndView("jarManager", "jarManagerModel", jarManagerModel);
	}
	
	
}
