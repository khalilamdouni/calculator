package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.calculator.dao.IParamConfigDao;
import org.calculator.models.ParamConfig;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("paramConfigDao")
@Transactional
public class ParamConfigDao implements IParamConfigDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ParamConfig> getParamConfigs(long paramId, int startIndex, int dataCount) {
		TypedQuery<ParamConfig> query = em.createNamedQuery(
				"ParamConfig.getAllParamConfigs", ParamConfig.class);
		query.setParameter("id", paramId);
		if (startIndex >= 0 && dataCount > 0) {
			query.setFirstResult(startIndex);
			query.setMaxResults(dataCount);
		}
		return query.getResultList();
	}

	@Override
	public ParamConfig saveParamConfig(ParamConfig paramConfig) {
		return em.merge(paramConfig);
	}

	@Override
	public void deleteParamConfig(long paramConfigId) {
		em.remove(em.find(ParamConfig.class, paramConfigId));
	}

	@Override
	public int getParamConfigsCount(long paramId) {

		Query query = em.createNamedQuery("ParamConfig.getParamConfigsCount");
		query.setParameter("id", paramId);
		return ((Number) query.getSingleResult()).intValue();
	}

}
