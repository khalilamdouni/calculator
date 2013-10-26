package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.calculator.dao.ICalculationConfigDao;
import org.calculator.models.CalculationConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @see org.calculator.dao.ICalculationConfigDao
 * 
 * @author khalil.amdouni
 * 
 */
@Repository("paramConfigDao")
@Transactional
public class CalculationConfigDao extends GenericDao<CalculationConfig> implements
		ICalculationConfigDao {

	public CalculationConfigDao() {
		super(CalculationConfig.class);
	}

	@Override
	public List<CalculationConfig> getParamConfigs(long paramId,
			int startIndex, int dataCount) {
		TypedQuery<CalculationConfig> query = em.createNamedQuery(
				"ParamConfig.getAllConfigs", CalculationConfig.class);
		query.setParameter("id", paramId);
		if (startIndex >= 0 && dataCount > 0) {
			query.setFirstResult(startIndex);
			query.setMaxResults(dataCount);
		}
		return query.getResultList();
	}

	@Override
	public int getParamConfigsCount(long paramId) {

		Query query = em.createNamedQuery("ParamConfig.getConfigsCount");
		query.setParameter("id", paramId);
		return ((Number) query.getSingleResult()).intValue();
	}

	@Override
	public List<CalculationConfig> getWebScenarioConfigs(long scenarioId,
			int startIndex, int dataCount) {
		TypedQuery<CalculationConfig> query = em.createNamedQuery(
				"WebScenarioConfig.getAllConfigs", CalculationConfig.class);
		query.setParameter("id", scenarioId);
		if (startIndex >= 0 && dataCount > 0) {
			query.setFirstResult(startIndex);
			query.setMaxResults(dataCount);
		}
		return query.getResultList();
	}

	@Override
	public int getWebScenarioConfigsCount(long scenarioId) {
		Query query = em.createNamedQuery("WebScenarioConfig.getConfigsCount");
		query.setParameter("id", scenarioId);
		return ((Number) query.getSingleResult()).intValue();
	}

}
