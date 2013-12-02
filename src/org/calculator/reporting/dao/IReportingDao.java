package org.calculator.reporting.dao;

import java.util.List;

import org.calculator.dao.IGenericDao;
import org.calculator.reporting.models.Report;

/**
 * The interface of reports Data access object
 * 
 * @author khalil.amdouni
 * 
 */
public interface IReportingDao extends IGenericDao<Report> {

	public List<Report> getAllReports();
}
