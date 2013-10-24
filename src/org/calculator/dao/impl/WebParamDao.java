package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.calculator.dao.IWebParamDao;
import org.calculator.models.WebParam;

/**
 * @see org.calculator.dao.IWebParamDao
 * 
 * @author khalil.amdouni
 * 
 */
public class WebParamDao extends GenericDao<WebParam> implements IWebParamDao {

	public WebParamDao() {
		super(WebParam.class);
	}

	@Override
	public List<WebParam> getWebParamByRequestId(long requestId,
			int startIndex, int resultSize) {
		TypedQuery<WebParam> query = em.createNamedQuery(
				"WebParam.getParamsByRequestId", WebParam.class);
		query.setParameter("requestId", requestId);
		if (startIndex >= 0 && resultSize > 0) {
			query.setFirstResult(startIndex);
			query.setMaxResults(resultSize);
		}
		return query.getResultList();
	}

	@Override
	public int getWebParamsCount(long requestId) {
		Query query = em.createNamedQuery("WebParam.getParamsCount");
		query.setParameter("requestId", requestId);
		return ((Number) query.getSingleResult()).intValue();
	}

}
