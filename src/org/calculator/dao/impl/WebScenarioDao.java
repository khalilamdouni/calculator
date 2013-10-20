package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

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
		TypedQuery<WebScenario> query = em.createNamedQuery(
				"WebScenario.getScenarios", WebScenario.class);
		return query.getResultList();
	}
}
