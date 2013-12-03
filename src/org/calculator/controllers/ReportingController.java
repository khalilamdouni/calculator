package org.calculator.controllers;

import org.calculator.business.reporting.IReportingManager;
import org.springframework.stereotype.Controller;

/**
 * Reporting controller
 * 
 * @author khalil.amdouni
 *
 */
@Controller
public class ReportingController {
	
	private IReportingManager reportingManager;
	
	public saveReport(long scenarioId, String resultsAsString) {
		String[] results = resultsAsString.split("-");
		
	}
	
}
