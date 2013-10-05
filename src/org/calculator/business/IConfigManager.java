package org.calculator.business;

import java.util.List;

import org.calculator.models.ParamConfig;

public interface IConfigManager {
	
	public List<ParamConfig> getParamConfigs(long paramId, int startIndex, int dataCount);

	public ParamConfig saveParamConfig(ParamConfig paramConfig);

	public void deleteParamConfig(long paramConfigId);

	public int getParamConfigsCount(long paramId);
	
}
