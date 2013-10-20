package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.models.WebScenario;

/**
 * View Model for the WebScenario management functionality
 * 
 * @author khalil.amdouni
 * 
 */
public class WebScenarioViewModel {

	private List<WebScenario> webScenarios;

	public List<WebScenario> getWebScenarios() {
		return webScenarios;
	}

	public void setWebScenarios(List<WebScenario> webScenarios) {
		this.webScenarios = webScenarios;
	}

}
