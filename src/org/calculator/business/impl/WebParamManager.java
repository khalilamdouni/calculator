package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IWebParamManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.IWebParamDao;
import org.calculator.models.WebParam;

/**
 * @see org.calculator.business.IWebParamManager
 * 
 * @author khalil.amdouni
 * 
 */
public class WebParamManager extends GenericManager<WebParam> implements
		IWebParamManager {

	private IWebParamDao webParamDao;

	@Override
	public IGenericDao<WebParam> getDao() {
		return (IGenericDao<WebParam>) webParamDao;
	}

	@Override
	public List<WebParam> getWebParamByRequestId(long requestId) {
		return webParamDao.getWebParamByRequestId(requestId);
	}

	public IWebParamDao getWebParamDao() {
		return webParamDao;
	}

	public void setWebParamDao(IWebParamDao webParamDao) {
		this.webParamDao = webParamDao;
	}

}
