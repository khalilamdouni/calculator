package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IConfigManager;
import org.calculator.dao.IParamConfigDao;
import org.calculator.models.ParamConfig;

public class ConfigManager implements IConfigManager {

	private IParamConfigDao paramConfigDao;

	@Override
	public List<ParamConfig> getParamConfigs(long paramId, int startIndex,
			int dataCount) {
		return paramConfigDao.getParamConfigs(paramId, startIndex, dataCount);
	}

	@Override
	public ParamConfig saveParamConfig(ParamConfig paramConfig) {
		return paramConfigDao.saveParamConfig(paramConfig);
	}

	@Override
	public void deleteParamConfig(long paramConfigId) {
		paramConfigDao.deleteParamConfig(paramConfigId);
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

}
