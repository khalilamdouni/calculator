package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.calculator.dao.IjarScenarioDao;
import org.calculator.models.JarScenario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see org.calculator.dao.IjarScenarioDao
 * 
 * @author khalil.amdouni
 * 
 */
@Repository(value = "executionPlanDao")
@Transactional
public class JarScenarioDao extends GenericDao<JarScenario> implements
		IjarScenarioDao {

	public JarScenarioDao() {
		super(JarScenario.class);
	}

	@Override
	public List<JarScenario> getJarScenarios() {

		TypedQuery<JarScenario> query = em.createNamedQuery(
				"JarScenario.getJarScenarios", JarScenario.class);
		return query.getResultList();
	}

}
