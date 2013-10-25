package org.calculator.business;

import org.calculator.models.WebRequest;
import org.calculator.models.WebScenario;

/**
 * The interface of the Web request manager which is responsible of saving,
 * editing Web requests used in web calculation
 * 
 * @author khalil.amdouni
 * 
 */
public interface IWebRequestManager extends IGenericManager<WebRequest> {
	
	/**
	 * Business method used to populate a web scenario object with attached web
	 * requests
	 * 
	 * @param webScenario
	 */
	public WebScenario populateWebScenario(WebScenario webScenario);
}
