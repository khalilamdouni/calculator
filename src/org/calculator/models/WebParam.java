package org.calculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JPA entity to encapsulate the web http param in the WEB calculation process
 * 
 * @author khalil.amdouni
 * 
 */
@Entity
@Table(name = "WEB_PARAMS")
public class WebParam {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "value")
	private String value;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REQUEST_ID", nullable = false, updatable = false)
	private WebRequest webRequest;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public WebRequest getWebRequest() {
		return webRequest;
	}

	public void setWebRequest(WebRequest webRequest) {
		this.webRequest = webRequest;
	}

}
