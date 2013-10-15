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

/**
 * Controller to handle Jar files management operations
 * 
 * @author khalil.amdouni
 * 
 */
@Controller
public class JarManagerController {

	private static final Logger logger = Logger
			.getLogger(JarManagerController.class);

	private IJarManager jarManager;
	private IClassManager classManager;

	/**
	 * Getting the jar manager view
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/jarManager", method = RequestMethod.GET)
	public ModelAndView jarManager() {
		JarManagerModel jarManagerModel = new JarManagerModel();
		return new ModelAndView("jarManager", "jarManagerModel",
				jarManagerModel);
	}

	/**
	 * Handle upload jar file query
	 * 
	 * @param jarManagerModel
	 * @param result
	 * @return String; the vies name
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/uploadJar", method = RequestMethod.POST)
	public String uploadJar(
			@ModelAttribute("jarManagerModel") JarManagerModel jarManagerModel,
			BindingResult result) throws IllegalStateException, IOException,
			ClassNotFoundException {

		this.jarManager.saveJar(jarManagerModel.getJarFile());

		return "redirect:jarManager";
	}

	/**
	 * Getting all jar files stored in the database
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @return JSONJTableModel; a model adapted to the JTable framework as JSON
	 */
	@RequestMapping(value = "/getJars", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableModel<JarFileModel> getJars(@RequestParam int jtStartIndex,
			@RequestParam int jtPageSize) {
		return new JSONJTableModel<JarFileModel>("OK",
				this.jarManager.loadJars(jtStartIndex, jtPageSize),
				this.jarManager.getJarsCount());
	}

	/**
	 * Updating jar file metadata
	 * 
	 * @param jarFile
	 * @param result
	 * @return JSONJTableResponseModel; a model adapted to the JTable framework
	 *         as JSON
	 */
	@RequestMapping(value = "/updateJar", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<JarFileModel> updateJar(
			@ModelAttribute JarFileModel jarFile, BindingResult result) {
		return new JSONJTableResponseModel<JarFileModel>("OK",
				this.jarManager.updateJar(jarFile));
	}

	/**
	 * Delete of jar file
	 * 
	 * @param jarId
	 * @return JSONJTableResponseModel; a model adapted to the JTable framework
	 *         as JSON
	 */
	@RequestMapping(value = "/deleteJar", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<JarFileModel> deleteJar(@RequestParam String jarId) {
		this.jarManager.deleteJar(jarId);
		return new JSONJTableResponseModel<JarFileModel>("OK");
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
