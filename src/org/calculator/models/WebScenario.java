package org.calculator.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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

}
