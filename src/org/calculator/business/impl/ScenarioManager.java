package org.calculator.business.impl;

import org.calculator.business.IScenarioManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.IScenarioDao;
import org.calculator.models.Scenario;

/**
 * @see org.calculator.business.IScenarioManager
 * 
 * @author khalil.amdouni
 *
 */
public class ScenarioManager extends GenericManager<Scenario> implements
		IScenarioManager {

	private IScenarioDao scenarioDao;
	
	@Override
	public IGenericDao<Scenario> getDao() {
		return (IGenericDao<Scenario>) scenarioDao;
	}

	public IScenarioDao getScenarioDao() {
		return scenarioDao;
	}

	public void setScenarioDao(IScenarioDao scenarioDao) {
		this.scenarioDao = scenarioDao;
	}
	
}
