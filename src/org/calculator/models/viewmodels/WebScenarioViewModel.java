package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.models.WebScenario;
import org.springframework.web.multipart.MultipartFile;

/**
 * View Model for the WebScenario management functionality
 * 
 * @author khalil.amdouni
 * 
 */
public class WebScenarioViewModel {

	private List<WebScenario> webScenarios;
	private MultipartFile xmlFile;

	public List<WebScenario> getWebScenarios() {
		return webScenarios;
	}

	public void setWebScenarios(List<WebScenario> webScenarios) {
		this.webScenarios = webScenarios;
	}

	public MultipartFile getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(MultipartFile xmlFile) {
		this.xmlFile = xmlFile;
	}

}
