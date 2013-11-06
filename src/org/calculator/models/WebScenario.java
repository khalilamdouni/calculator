package org.calculator.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * JPA entity to encapsulate the web scenario in the WEB calculation process
 * 
 * @author khalil.amdouni
 * 
 */
@Entity
@DiscriminatorValue(value = "WEB")
@NamedQueries({ @NamedQuery(name = "WebScenario.getWebScenarios", query = "SELECT ws FROM WebScenario ws") })
public class WebScenario extends Scenario {
	
	@OneToMany(mappedBy = "webScenario", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<CalculationConfig> configs;
	
	@Transient
	private List<WebRequest> webRequests;

	public List<WebRequest> getWebRequests() {
		return webRequests;
	}

	public void setWebRequests(List<WebRequest> webRequests) {
		this.webRequests = webRequests;
	}

	public List<CalculationConfig> getConfigs() {
		return configs;
	}

	public void setConfigs(List<CalculationConfig> configs) {
		this.configs = configs;
	}
	
	public CalculationConfig getActiveConfig() {
		for (CalculationConfig calculationConfig : configs) {
			if (calculationConfig.isActive())
				return calculationConfig;
		}
		return null;
	}
	
}
