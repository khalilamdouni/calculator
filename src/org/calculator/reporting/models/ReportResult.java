package org.calculator.reporting.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * JPA entity to encapsulate one result to be stored in a report
 * 
 * @author khalil.amdouni
 *
 */
@Entity
@Table(name = "REPORTING_RESULTS")
public class ReportResult {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "X")
	private double x;
	
	@Column(name = "Y")
	private double y;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPORT_ID", nullable = false, updatable = false)
	private Report report;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

}
