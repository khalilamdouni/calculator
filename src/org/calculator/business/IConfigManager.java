package org.calculator.business;

import java.util.List;

import org.calculator.models.ParamConfig;

/**
 * The interface of the config manager which is responsible of java methods
 * param configuration, after configuring all method params the method will be
 * ready for calculation process
 * 
 * @author khalil.amdouni
 * 
 */
public interface IConfigManager {

	/**
	 * Getting the list of param configs by param id
	 * 
	 * @param paramId
	 * @param startIndex
	 * @param dataCount
	 * @return List of ParamConfig
	 */
	public List<ParamConfig> getParamConfigs(long paramId, int startIndex,
			int dataCount);

	/**
	 * Saving param config
	 * 
	 * @param paramConfig
	 * @return ParamConfig
	 */
	public ParamConfig saveParamConfig(ParamConfig paramConfig);

	/**
	 * Delete of param config
	 * 
	 * @param paramConfigId
	 */
	public void deleteParamConfig(long paramConfigId);

	/**
	 * getting the number of param configs by param id
	 * 
	 * @param paramId
	 * @return int
	 */
	public int getParamConfigsCount(long paramId);

}
