package org.calculator.business;

import java.util.List;

import org.calculator.models.WebScenario;

/**
 * The interface of the Web scenario manager which is responsible of saving,
 * editing Web scenarios
 * 
 * @author khalil.amdouni
 * 
 */
public interface IWebScenarioManager extends IGenericManager<WebScenario> {

	public List<WebScenario> getWebScenarios();
	
	public void addWebRequestToWebScenario(long scenarioId, long requestId);

}
