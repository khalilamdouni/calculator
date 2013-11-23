package org.calculator.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.calculator.dao.IWebRequestDao;
import org.calculator.models.WebRequest;

/**
 * @see org.calculator.dao.IWebRequestDao
 * 
 * @author khalil.amdouni
 * 
 */
public class WebRequestDao extends GenericDao<WebRequest> implements
		IWebRequestDao {

	public WebRequestDao() {
		super(WebRequest.class);
	}

	@Override
	public List<WebRequest> getAllWebRequests() {
		TypedQuery<WebRequest> query = em.createNamedQuery(
				"WebRequest.getAllWebRequests", WebRequest.class);
		return query.getResultList();
	}

}
