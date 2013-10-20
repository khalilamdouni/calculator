package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IConfigManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.IParamConfigDao;
import org.calculator.models.ParamConfig;

/**
 * @see  org.calculator.business.IConfigManager
 * 
 * @author khalil.amdouni
 *
 */
public class ConfigManager extends GenericManager<ParamConfig> implements IConfigManager {

	private IParamConfigDao paramConfigDao;

	@Override
	public List<ParamConfig> getParamConfigs(long paramId, int startIndex,
			int dataCount) {
		return paramConfigDao.getParamConfigs(paramId, startIndex, dataCount);
	}

	@Override
	public int getParamConfigsCount(long paramId) {
		return paramConfigDao.getParamConfigsCount(paramId);
	}

	public IParamConfigDao getParamConfigDao() {
		return paramConfigDao;
	}

	public void setParamConfigDao(IParamConfigDao paramConfigDao) {
		this.paramConfigDao = paramConfigDao;
	}

	@Override
	public IGenericDao<ParamConfig> getDao() {
		return (IGenericDao<ParamConfig>) paramConfigDao;
	}

}
