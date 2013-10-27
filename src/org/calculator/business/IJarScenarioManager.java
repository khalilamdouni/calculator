package org.calculator.business;

import java.util.List;

import org.calculator.models.JarScenario;

/**
 * The interface of the jar scenario manager which is responsible for managing
 * scenarios of java methods methods
 * 
 * @author khalil.amdouni
 * 
 */
public interface IJarScenarioManager extends IGenericManager<JarScenario> {


	/**
	 * Getting all Jar Scenarios
	 * 
	 * @return List of JarScenarios
	 */
	public List<JarScenario> getJarScenarios();

}
