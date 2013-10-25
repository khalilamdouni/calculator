package org.calculator.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * JPA Entity to encapsulate the Jar Scenario to be used in the calculation
 * process
 * 
 * @author khalil.amdouni
 * 
 */
@Entity
@DiscriminatorValue(value = "JAR")
@NamedQueries({
		@NamedQuery(name = "JarScenario.getJarScenarios", query = "SELECT js FROM JarScenario js"),
})
public class JarScenario extends Scenario {

	@Column(name = "NAMES_SEQUENCE")
	private String namesSequence;

	public String getNamesSequence() {
		return namesSequence;
	}

	public void setNamesSequence(String namesSequence) {
		this.namesSequence = namesSequence;
	}

}
