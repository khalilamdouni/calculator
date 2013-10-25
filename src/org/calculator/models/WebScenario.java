package org.calculator.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
	
	@Transient
	private List<WebRequest> webRequests;

	public List<WebRequest> getWebRequests() {
		return webRequests;
	}

	public void setWebRequests(List<WebRequest> webRequests) {
		this.webRequests = webRequests;
	}
	
}
