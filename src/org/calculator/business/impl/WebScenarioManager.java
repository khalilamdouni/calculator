package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IWebScenarioManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.IWebScenarioDao;
import org.calculator.models.WebScenario;

/**
 * @see org.calculator.business.IWebScenarioManager
 * 
 * @author khalil.amdouni
 *
 */
public class WebScenarioManager extends GenericManager<WebScenario> implements
		IWebScenarioManager {

	private IWebScenarioDao webScenarioDao;
	
	@Override
	public IGenericDao<WebScenario> getDao() {
		return (IGenericDao<WebScenario>) webScenarioDao;
	}
	
	@Override
	public List<WebScenario> getWebScenarios() {
		return webScenarioDao.getWebScenarios();
	}

	public IWebScenarioDao getWebScenarioDao() {
		return webScenarioDao;
	}

	public void setWebScenarioDao(IWebScenarioDao webScenarioDao) {
		this.webScenarioDao = webScenarioDao;
	}

}
