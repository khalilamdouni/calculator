package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.reporting.models.Report;

/**
 * Reporting management View Model
 * 
 * @author khalil.amdouni
 * 
 */
public class ReportingViewModel {

	private List<Report> reports;

	public ReportingViewModel() {
		super();
	}

	public ReportingViewModel(List<Report> reports) {
		super();
		this.reports = reports;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

}
