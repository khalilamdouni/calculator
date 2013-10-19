package org.calculator.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JPA entity to encapsulate the web scenario in the WEB calculation process
 * 
 * @author khalil.amdouni
 * 
 */
@Entity
@Table(name = "WEB_SCENARIOS")
public class WebScenario {

	@Column(name = "ID")
	@Id
	private long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "webScenario")
	private List<WebRequest> webRequests;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<WebRequest> getWebRequests() {
		return webRequests;
	}

	public void setWebRequests(List<WebRequest> webRequests) {
		this.webRequests = webRequests;
	}

}
