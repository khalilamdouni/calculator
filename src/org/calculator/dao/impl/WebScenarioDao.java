package org.calculator.dao.impl;

import java.util.List;

import org.calculator.dao.IWebScenarioDao;
import org.calculator.models.WebScenario;

/**
 * @see org.calculator.dao.IWebScenarioDao
 * 
 * @author khalil.amdouni
 *
 */
public class WebScenarioDao extends GenericDao<WebScenario> implements
		IWebScenarioDao {

	public WebScenarioDao() {
		super(WebScenario.class);
	}

	@Override
	public List<WebScenario> getWebScenarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
