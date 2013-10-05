package org.calculator.business;

import java.util.List;

import org.calculator.models.ParamConfig;

public interface IConfigManager {
	
	public List<ParamConfig> getParamConfigs(long classId, int startIndex, int dataCount);

	public ParamConfig saveParamConfig(ParamConfig paramConfig);

	public void deleteParamConfig(String paramConfigId);

	public int getParamConfigsCount(long classId);
	
}
