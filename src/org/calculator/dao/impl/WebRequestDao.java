package org.calculator.dao.impl;

import java.util.List;

import org.calculator.dao.IWebRequestDao;
import org.calculator.models.WebRequest;

/**
 * @see org.calculator.dao.IWebRequestDao
 * 
 * @author khalil.amdouni
 * 
 */
public class WebRequestDao extends GenericDao<WebRequest> implements
		IWebRequestDao {

	public WebRequestDao() {
		super(WebRequest.class);
	}

	@Override
	public List<WebRequest> getWebRequestsByScenarioId(long scenarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
