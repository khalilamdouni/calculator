package org.calculator.business;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.calculator.models.WebScenario;
import org.xml.sax.SAXException;

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

	public void convertAndSaveXMLData(InputStream in)
			throws ParserConfigurationException, SAXException, IOException;
}
