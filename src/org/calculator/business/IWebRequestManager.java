package org.calculator.business;

import java.util.List;

import org.calculator.models.WebRequest;

/**
 * The interface of the Web request manager which is responsible of saving,
 * editing Web requests used in web calculation
 * 
 * @author khalil.amdouni
 * 
 */
public interface IWebRequestManager extends IGenericManager<WebRequest> {

	public List<WebRequest> getWebRequestsByScenarioId(long scenarioId);
	public void reorderRequests(String requestSequence);
}
