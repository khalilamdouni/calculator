package org.calculator.controllers;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.calculator.business.IClassManager;
import org.calculator.business.IJarManager;
import org.calculator.business.IMethodManager;
import org.calculator.business.IParamManager;
import org.calculator.models.CalculatorClass;
import org.calculator.models.CalculatorClassMethod;
import org.calculator.models.CalculatorMethodParam;
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

/**
 * Jar classes, methods and params management and configuration
 * 
 * @author khalil.amdouni
 *
 */
@Controller
public class ReflectorController {

	private IJarManager jarManager;
	private IClassManager classManager;
	private IMethodManager methodManager;
	private IParamManager paramManager;

	private static final Logger logger = Logger
			.getLogger(ReflectorController.class);

	/**
	 * Getting the reflector view
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/reflector", method = RequestMethod.GET)
	public ModelAndView getReflector() {
		ReflectorModel reflectorModel = new ReflectorModel();
		reflectorModel.setJarFiles(jarManager.getReflectedJars());
		return new ModelAndView("reflector", "reflectorModel", reflectorModel);
	}

	/**
	 * Store all Classes, methods and params of jar files in the database
	 * 
	 * @return String; view name
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@RequestMapping(value = "/reflectJars", method = RequestMethod.GET)
	public String reflectJars() throws ClassNotFoundException, IOException {
		jarManager.reflectJars();
		return "redirect:reflector";
	}

	/**
	 * Getting class edition form
	 * 
	 * @param classId
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/getClassForm/{classId}")
	public ModelAndView getClassForm(@PathVariable("classId") long classId) {
		return new ModelAndView("classForm", "classModel",
				classManager.getCalculatorClass(classId));
	}

	/**
	 * Saving class infos
	 * 
	 * @param claculatorClass as JSON
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/saveClass", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView saveClass(@RequestBody CalculatorClass claculatorClass) {
		logger.info("Save off : " + claculatorClass);
		return new ModelAndView("classForm", "classModel",
				this.classManager.saveCalculatorClass(claculatorClass));
	}

	/**
	 * Getting method edition form
	 * 
	 * @param methodId
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/getMethodForm/{methodId}")
	public ModelAndView getMethodForm(@PathVariable("methodId") long methodId) {
		return new ModelAndView("methodForm", "methodModel",
				this.methodManager.getMethod(methodId));
	}

	/**
	 * Saving method infos
	 * 
	 * @param calculatorClassMethod as JSON
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/saveMethod", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView saveMethod(
			@RequestBody CalculatorClassMethod calculatorClassMethod) {
		logger.info("Save off : " + calculatorClassMethod);
		return new ModelAndView("methodForm", "methodModel",
				this.methodManager.saveMethod(calculatorClassMethod));
	}

	/**
	 * Getting param edition form
	 * 
	 * @param paramId
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/getParamForm/{paramId}")
	public ModelAndView getParamForm(@PathVariable("paramId") long paramId) {
		return new ModelAndView("paramForm", "paramModel",
				this.paramManager.getParam(paramId));
	}

	/**
	 * Saving param info
	 * 
	 * @param calculatorMethodParam
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/saveParam", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView saveParam(
			@RequestBody CalculatorMethodParam calculatorMethodParam) {
		logger.info("Save off : " + calculatorMethodParam);
		return new ModelAndView("paramForm", "paramModel",
				this.paramManager.saveParam(calculatorMethodParam));
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

	public IMethodManager getMethodManager() {
		return methodManager;
	}

	@Autowired
	@Qualifier(value = "methodManager")
	public void setMethodManager(IMethodManager methodManager) {
		this.methodManager = methodManager;
	}

	public IParamManager getParamManager() {
		return paramManager;
	}

	@Autowired
	@Qualifier(value = "paramManager")
	public void setParamManager(IParamManager paramManager) {
		this.paramManager = paramManager;
	}

}
