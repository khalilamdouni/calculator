package org.calculator.reporting.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.calculator.dao.impl.GenericDao;
import org.calculator.reporting.dao.IReportingDao;
import org.calculator.reporting.models.Report;

/**
 * @see org.calculator.reporting.dao.IReportingDao
 * 
 * @author khalil.amdouni
 * 
 */
public class ReportingDao extends GenericDao<Report> implements IReportingDao {

	public ReportingDao() {
		super(Report.class);
	}

	@Override
	public List<Report> getAllReports() {
		TypedQuery<Report> query = em.createNamedQuery("Report.getAllReports",
				Report.class);
		return query.getResultList();
	}

}
