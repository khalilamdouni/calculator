package org.calculator.business.reporting.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.calculator.business.impl.GenericManager;
import org.calculator.business.reporting.IReportingManager;
import org.calculator.dao.IGenericDao;
import org.calculator.reporting.dao.IReportingDao;
import org.calculator.reporting.models.Report;
import org.calculator.reporting.models.ReportResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @see org.calculator.business.reporting.IReportingManager
 * 
 * @author khalil.amdouni
 *
 */
public class ReportingManager extends GenericManager<Report> implements
		IReportingManager {

	private IReportingDao reportingDao;
	
	@Override
	public IGenericDao<Report> getDao() {
		return (IGenericDao<Report>) reportingDao;
	}

	@Override
	public List<Report> getAllReports() {
		return reportingDao.getAllReports();
	}

	@Override
	public InputStream exportXML(long reportId)
			throws ParserConfigurationException,
			TransformerConfigurationException, TransformerException,
			TransformerFactoryConfigurationError, UnsupportedEncodingException {
		Report report = reportingDao.getById(reportId);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document document = db.newDocument();
		Element reportElement = document.createElement("report");
		document.appendChild(reportElement);

		Attr reportAttrId = document.createAttribute("id");
		reportAttrId.setValue(String.valueOf((report.getId())));
		reportElement.setAttributeNode(reportAttrId);

		Element descriptionElement = document.createElement("description");
		descriptionElement.appendChild(document.createTextNode(report
				.getDescription()));
		reportElement.appendChild(descriptionElement);

		Element results = document.createElement("results");

		for (ReportResult result : report.getResults()) {
			Element resultElement = document.createElement("result");
			Attr xAttr = document.createAttribute("x");
			xAttr.setValue(String.valueOf(result.getX()));
			Attr yAttr = document.createAttribute("y");
			yAttr.setValue(String.valueOf(result.getY()));

			resultElement.setAttributeNode(xAttr);
			resultElement.setAttributeNode(yAttr);

			results.appendChild(resultElement);
		}

		reportElement.appendChild(results);
		DOMSource source = new DOMSource(document);
		StringWriter xmlAsWriter = new StringWriter();
		StreamResult result = new StreamResult(xmlAsWriter);
		TransformerFactory.newInstance().newTransformer()
				.transform(source, result);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlAsWriter
				.toString().getBytes("UTF-8"));
		return inputStream;
	}

	@Override
	public InputStream exportExcel(long reportId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream exportPDF(long reportId) {
		// TODO Auto-generated method stub
		return null;
	}

	public IReportingDao getReportingDao() {
		return reportingDao;
	}

	public void setReportingDao(IReportingDao reportingDao) {
		this.reportingDao = reportingDao;
	}
	
}
