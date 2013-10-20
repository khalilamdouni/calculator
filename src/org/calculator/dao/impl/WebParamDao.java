package org.calculator.dao.impl;

import java.util.List;

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
	public List<WebParam> getWebParamByRequestId(long requestId) {
		TypedQuery<WebParam> query = em.createNamedQuery(
				"WebParam.getParamsByRequestId", WebParam.class);
		query.setParameter("requestId", requestId);
		return query.getResultList();
	}

}
