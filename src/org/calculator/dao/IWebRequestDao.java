package org.calculator.dao;

import java.util.List;

import org.calculator.models.WebRequest;

/**
 * The interface of WebRequest data access object
 * 
 * @author khalil.amdouni
 * 
 */
public interface IWebRequestDao extends IGenericDao<WebRequest> {

	public List<WebRequest> getAllWebRequests();
}
