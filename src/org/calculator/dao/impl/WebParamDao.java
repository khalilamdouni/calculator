package org.calculator.dao.impl;

import java.util.List;

import org.calculator.dao.IWebParamDao;
import org.calculator.models.WebParam;

/**
 * @see org.calculator.dao.IWebParamDao
 * 
 * @author khalil.amdouni
 * 
 */
public class WebParamDao extends GenericDao<WebParam> implements IWebParamDao {

	public WebParamDao(Class<WebParam> type) {
		super(WebParam.class);
	}

	@Override
	public List<WebParam> getWebParamByRequestId(long requestId) {
		// TODO Auto-generated method stub
		return null;
	}

}
