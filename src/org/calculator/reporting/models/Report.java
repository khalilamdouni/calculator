package org.calculator.reporting.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.calculator.models.Scenario;

/**
 * JPA entity to encapsulate a calculation report
 * 
 * @author khalil.amdouni
 * 
 */
@Entity
@Table(name = "REPORTING_REPORTS")
@NamedQueries({ @NamedQuery(name = "Report.getAllReports", query = "SELECT r FROM Report r") })
public class Report {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	private List<ReportResult> results;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCENARIO_ID", nullable = false, updatable = false)
	private Scenario scenario;

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

	public List<ReportResult> getResults() {
		return results;
	}

	public void setResults(List<ReportResult> results) {
		this.results = results;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
}
