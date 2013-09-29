package org.calculator.controllers;

import org.calculator.business.IJarManager;
import org.calculator.models.ReflectorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReflectorController {
	
	private IJarManager jarManager;
	
	@RequestMapping(value = "/reflector", method = RequestMethod.GET)
	public ModelAndView reflectJars() {
		ReflectorModel reflectorModel = new ReflectorModel();
		return new ModelAndView("reflector", "reflectorModel", reflectorModel);
	}
	
	public IJarManager getJarManager() {
		return jarManager;
	}

	@Autowired
	@Qualifier(value = "jarManager")
	public void setJarManager(IJarManager jarManager) {
		this.jarManager = jarManager;
	}
	
}
