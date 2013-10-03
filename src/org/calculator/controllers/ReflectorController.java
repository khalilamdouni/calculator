package org.calculator.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.calculator.business.IClassManager;
import org.calculator.business.IJarManager;
import org.calculator.models.CalculatorClass;
import org.calculator.models.ReflectorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReflectorController {

	private IJarManager jarManager;
	private IClassManager classManager;
	
	private static final Logger logger = Logger.getLogger(ReflectorController.class);

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
	
	@RequestMapping(value = "/saveClass", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView saveClass(@RequestBody CalculatorClass claculatorClass) {
		logger.info("Save off : " + claculatorClass);
		return new ModelAndView("classForm", "classModel",
				this.classManager.saveCalculatorClass(claculatorClass));
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
