package org.calculator.dao;

import java.util.List;

import org.calculator.models.WebScenario;

/**
 * Interface for WebScenario Data access object
 * 
 * @author khalil.amdouni
 * 
 */
public interface IWebScenarioDao extends IGenericDao<WebScenario> {

	public List<WebScenario> getWebScenarios();

}
