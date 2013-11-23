package org.calculator.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
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
@NamedQueries({
	@NamedQuery(name = "WebRequest.getAllWebRequests", query = "SELECT wr FROM WebRequest wr")
})
public class WebRequest extends AbstractModel {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "URL")
	private String url;

	@Column(name = "METHOD")
	@Type(type = "org.calculator.models.usertypes.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "org.calculator.enums.CalculatorHttpMethods"),
			@Parameter(name = "identifierMethod", value = "name"),
			@Parameter(name = "valueOfMethod", value = "valueOf") })
	private CalculatorHttpMethods method;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "webRequest", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private List<WebParam> webParams;

	public String getHTTPFormatParams() {
		return StringUtils.join(webParams, "&");
	}
	
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

	public CalculatorHttpMethods getMethod() {
		return method;
	}

	public void setMethod(CalculatorHttpMethods method) {
		this.method = method;
	}

	public List<WebParam> getWebParams() {
		return webParams;
	}

	public void setWebParams(List<WebParam> webParams) {
		this.webParams = webParams;
	}

}
