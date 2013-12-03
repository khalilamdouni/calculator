package org.calculator.business.reporting.impl;

import java.util.List;

import org.calculator.business.impl.GenericManager;
import org.calculator.business.reporting.IReportingManager;
import org.calculator.dao.IGenericDao;
import org.calculator.reporting.dao.IReportingDao;
import org.calculator.reporting.models.Report;

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

	public IReportingDao getReportingDao() {
		return reportingDao;
	}

	public void setReportingDao(IReportingDao reportingDao) {
		this.reportingDao = reportingDao;
	}
	
}
