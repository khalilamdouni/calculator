package org.calculator.dao;

import java.util.List;

import org.calculator.models.ParamConfig;

public interface IParamConfigDao {

	public List<ParamConfig> getParamConfigs(long classId, int startIndex, int dataCount);

	public ParamConfig updateParamConfig(ParamConfig paramConfig);

	public void deleteParamConfig(String paramConfigId);

	public int getParamConfigsCount(long classId);

}
