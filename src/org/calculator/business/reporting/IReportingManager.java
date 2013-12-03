package org.calculator.business.reporting;

import java.util.List;

import org.calculator.business.IGenericManager;
import org.calculator.reporting.models.Report;

/**
 * Business interface of the reporting module
 * 
 * @author khalil.amdouni
 *
 */
public interface IReportingManager extends IGenericManager<Report> {

	public List<Report> getAllReports();
}
