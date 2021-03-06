package org.calculator.business;

import java.util.List;

import org.calculator.models.WebRequest;
import org.calculator.models.WebScenario;
import org.w3c.dom.NodeList;

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
	
	/**
	 * Business Method to get all WebRequests
	 * 
	 * @return List of WebRequests
	 */
	public List<WebRequest> getAllWebRequests();
	
	/**
	 * Business method used to convert and save XML to webRequests
	 * 
	 * 
	 * @param in
	 *            the inputStrem from the XML file
	 */
	public String convertAndSaveXMLRequests(NodeList requestsNodeList);
}
