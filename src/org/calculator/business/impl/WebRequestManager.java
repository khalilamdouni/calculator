package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IWebRequestManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.IWebRequestDao;
import org.calculator.models.WebRequest;

/**
 * @see org.calculator.business.IWebRequestManager
 * 
 * @author khalil.amdouni
 *
 */
public class WebRequestManager extends GenericManager<WebRequest> implements
		IWebRequestManager {

	private IWebRequestDao webRequestDao;
	
	@Override
	public IGenericDao<WebRequest> getDao() {
		return (IGenericDao<WebRequest>) webRequestDao;
	}

	@Override
	public List<WebRequest> getWebRequestsByScenarioId(long scenarioId) {
		return webRequestDao.getWebRequestsByScenarioId(scenarioId);
	}

	public IWebRequestDao getWebRequestDao() {
		return webRequestDao;
	}

	public void setWebRequestDao(IWebRequestDao webRequestDao) {
		this.webRequestDao = webRequestDao;
	}
	
}
