package org.calculator.business.reporting;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

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

	public InputStream exportXML(long reportId)
			throws ParserConfigurationException,
			TransformerConfigurationException, TransformerException,
			TransformerFactoryConfigurationError, UnsupportedEncodingException;

	public InputStream exportExcel(long reportId);

	public InputStream exportPDF(long reportId);

}
