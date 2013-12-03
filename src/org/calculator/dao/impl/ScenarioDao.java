package org.calculator.dao.impl;

import org.calculator.dao.IScenarioDao;
import org.calculator.models.Scenario;

/**
 * @see org.calculator.dao.IScenarioDao
 * 
 * @author khalil.amdouni
 *
 */
public class ScenarioDao extends GenericDao<Scenario> implements IScenarioDao {

	public ScenarioDao() {
		super(Scenario.class);
	}

}
