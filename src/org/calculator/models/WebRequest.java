package org.calculator.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.calculator.enums.CalculatorHttpMethods;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

/**
 * JPA entity to encapsulate the web request in the WEB calculation process
 * 
 * @author khalil.amdouni
 * 
 */
@Entity
@Table(name = "WEB_REQUESTS")
@NamedQueries({ @NamedQuery(name = "WebRequest.getRequestsByScenarioId", query = "SELECT wr FROM WebRequest wr WHERE webScenario.id=:scenarioId") })
public class WebRequest extends AbstractModel {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "url")
	private String url;

	@Column(name = "order")
	private int order;

	@Column(name = "METHOD")
	@Type(type = "org.calculator.models.usertypes.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "org.calculator.enums.CalculatorHttpMethods"),
			@Parameter(name = "identifierMethod", value = "name"),
			@Parameter(name = "valueOfMethod", value = "valueOf") })
	private CalculatorHttpMethods method;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCENARIO_ID", nullable = false, updatable = false)
	private WebScenario webScenario;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "webRequest")
	private List<WebParam> webParams;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public CalculatorHttpMethods getMethod() {
		return method;
	}

	public void setMethod(CalculatorHttpMethods method) {
		this.method = method;
	}

	public WebScenario getWebScenario() {
		return webScenario;
	}

	public void setWebScenario(WebScenario webScenario) {
		this.webScenario = webScenario;
	}

	public List<WebParam> getWebParams() {
		return webParams;
	}

	public void setWebParams(List<WebParam> webParams) {
		this.webParams = webParams;
	}

	public void setScenarioId(long scenarioId) {
		this.webScenario = new WebScenario();
		this.webScenario.setId(scenarioId);
	}

}
