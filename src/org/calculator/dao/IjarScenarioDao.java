package org.calculator.dao;

import java.util.List;

import org.calculator.models.JarScenario;

/**
 * The interface of Jar scenario Data Access Object
 * 
 * @author khalil.amdouni
 *
 */
public interface IjarScenarioDao extends IGenericDao<JarScenario> {

	public List<JarScenario> getJarScenarios();

}
