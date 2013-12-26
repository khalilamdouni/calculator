package org.calculator.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.calculator.business.IScenarioManager;
import org.calculator.business.reporting.IReportingManager;
import org.calculator.models.Scenario;
import org.calculator.models.viewmodels.ReportingViewModel;
import org.calculator.reporting.models.Report;
import org.calculator.reporting.models.ReportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Reporting controller
 * 
 * @author khalil.amdouni
 * 
 */
@Controller
public class ReportingController {

	private IReportingManager reportingManager;
	private IScenarioManager scenarioManager;

	private final static Logger logger = Logger
			.getLogger(ReportingController.class);

	@RequestMapping(value = "/getReportingManagerView", method = RequestMethod.GET)
	public ModelAndView getReportingManagerView() {
		return new ModelAndView("reportingManager", "reportingViewModel",
				new ReportingViewModel(reportingManager.getAllReports()));
	}

	@RequestMapping(value = "/saveReport/{scenarioId}/{resultsAsString}", method = RequestMethod.POST)
	public String saveReport(@PathVariable("scenarioId") long scenarioId,
			@PathVariable("resultsAsString") String resultsAsString) {
		String[] results = resultsAsString.split("-");
		List<ReportResult> reportResults = new ArrayList<ReportResult>();
		Scenario scenario = scenarioManager.get(scenarioId);
		String reportName = "Report for scenario " + scenario.getName();
		Report report = new Report();
		report.setTitle(reportName);
		report.setScenario(scenario);
		logger.info("================ >>" + resultsAsString);
		for (int i = 0; i < results.length; i++) {
			ReportResult reportResult = new ReportResult();
			reportResult.setReport(report);
			reportResult.setX(Double.valueOf(results[i].split("_")[0]));
			reportResult.setY(Double.valueOf(results[i].split("_")[1]));
			reportResults.add(reportResult);
		}
		report.setResults(reportResults);
		reportingManager.save(report);
		return "OK";
	}

	@RequestMapping(value = "/getReportView/{reportId}", method = RequestMethod.GET)
	public ModelAndView getReportView(@PathVariable("reportId") long reportId) {
		return new ModelAndView("reportView", "report",
				reportingManager.get(reportId));
	}

	@RequestMapping(value = "/updateReport", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView updateReport(@RequestBody Report report) {
		reportingManager.save(report);
		return getReportView(report.getId());
	}

	@RequestMapping(value = "/deleteReport/{reportId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	String deleteReport(@PathVariable("reportId") long reportId) {
		reportingManager.delete(reportId);
		return "OK";
	}
	
	@RequestMapping(value = "/exportXML/{reportId}", method = RequestMethod.GET)
	public void exportXML(@PathVariable("reportId") long reportId,
			HttpServletResponse response) throws IOException,
			ParserConfigurationException, TransformerConfigurationException,
			TransformerException, TransformerFactoryConfigurationError {
		InputStream inputStream = reportingManager.exportXML(reportId);
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition",
				"attachment; filename=report.xml");
		IOUtils.copy(inputStream, response.getOutputStream());
		response.flushBuffer();
	}

	@RequestMapping(value = "/exportExcel/{reportId}", method = RequestMethod.GET)
	public void exportExcel(@PathVariable("reportId") long reportId,
			HttpServletResponse response) throws IOException {
		 InputStream inputStream = reportingManager.exportExcel(reportId);
         response.setContentType("application/force-download");
         response.setHeader("Content-Disposition", "attachment; filename=report.xlsx"); 
         IOUtils.copy(inputStream, response.getOutputStream());
           response.flushBuffer();
	}

	@RequestMapping(value = "/exportPDF/{reportId}", method = RequestMethod.GET)
	public void exportPDF(@PathVariable("reportId") long reportId,
			HttpServletResponse response) throws IOException {
		 InputStream inputStream = reportingManager.exportPDF(reportId);
         response.setContentType("application/force-download");
         response.setHeader("Content-Disposition", "attachment; filename=report.pdf"); 
         IOUtils.copy(inputStream, response.getOutputStream());
           response.flushBuffer();
	}

	public IReportingManager getReportingManager() {
		return reportingManager;
	}

	@Autowired
	@Qualifier(value = "reportingManager")
	public void setReportingManager(IReportingManager reportingManager) {
		this.reportingManager = reportingManager;
	}

	public IScenarioManager getScenarioManager() {
		return scenarioManager;
	}

	@Autowired
	@Qualifier(value = "scenarioManager")
	public void setScenarioManager(IScenarioManager scenarioManager) {
		this.scenarioManager = scenarioManager;
	}

}
