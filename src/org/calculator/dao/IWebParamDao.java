package org.calculator.dao;

import java.util.List;

import org.calculator.models.WebParam;

/**
 * The Interface of WebParam data access object
 * 
 * @author khalil.amdouni
 * 
 */
public interface IWebParamDao extends IGenericDao<WebParam> {
	public List<WebParam> getWebParamByRequestId(long requestId, int startIndex, int resultSize);
	public int getWebParamsCount(long requestId);
}
