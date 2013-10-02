package org.calculator.controllers;

import java.io.IOException;

import org.calculator.business.IClassManager;
import org.calculator.business.IJarManager;
import org.calculator.models.CalculatorClass;
import org.calculator.models.ReflectorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReflectorController {

	private IJarManager jarManager;
	private IClassManager classManager;

	@RequestMapping(value = "/reflector", method = RequestMethod.GET)
	public ModelAndView getReflector() {
		ReflectorModel reflectorModel = new ReflectorModel();
		reflectorModel.setJarFiles(jarManager.getReflectedJars());
		return new ModelAndView("reflector", "reflectorModel", reflectorModel);
	}

	@RequestMapping(value = "/reflectJars", method = RequestMethod.GET)
	public String reflectJars() throws ClassNotFoundException, IOException {
		jarManager.reflectJars();
		return "redirect:reflector";
	}

	@RequestMapping(value = "/getClassForm/{classId}")
	public ModelAndView getClassForm(@PathVariable("classId") long classId) {
		return new ModelAndView("classForm", "classModel",
				classManager.getCalculatorClass(classId));
	}
	
	public IJarManager getJarManager() {
		return jarManager;
	}

	@Autowired
	@Qualifier(value = "jarManager")
	public void setJarManager(IJarManager jarManager) {
		this.jarManager = jarManager;
	}

	public IClassManager getClassManager() {
		return classManager;
	}

	@Autowired
	@Qualifier(value = "classManager")
	public void setClassManager(IClassManager classManager) {
		this.classManager = classManager;
	}

}
