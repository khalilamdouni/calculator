package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IJarScenarioManager;
import org.calculator.dao.IjarScenarioDao;
import org.calculator.dao.IGenericDao;
import org.calculator.models.JarScenario;

/**
 * @see  org.calculator.business.IJarScenarioManager
 * 
 * @author khalil.amdouni
 *
 */
public class JarScenarioManager extends GenericManager<JarScenario> implements IJarScenarioManager {
	
	private IjarScenarioDao jarScenarioDao;

	@Override
	public List<JarScenario> getJarScenarios() {
		return jarScenarioDao.getJarScenarios();
	}

	public IjarScenarioDao getJarScenarioDao() {
		return jarScenarioDao;
	}

	public void setJarScenarioDao(IjarScenarioDao jarScenarioDao) {
		this.jarScenarioDao = jarScenarioDao;
	}

	@Override
	public IGenericDao<JarScenario> getDao() {
		return (IGenericDao<JarScenario>) jarScenarioDao;
	}

}
