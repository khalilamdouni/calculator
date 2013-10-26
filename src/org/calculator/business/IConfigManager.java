package org.calculator.business;

import java.util.List;

import org.calculator.models.CalculationConfig;

/**
 * The interface of the config manager which is responsible of java methods
 * param configuration, after configuring all method params the method will be
 * ready for calculation process
 * 
 * @author khalil.amdouni
 * 
 */
public interface IConfigManager extends IGenericManager<CalculationConfig> {

	/**
	 * Getting the list of param configs by param id
	 * 
	 * @param paramId
	 * @param startIndex
	 * @param dataCount
	 * @return List of ParamConfig
	 */
	public List<CalculationConfig> getParamConfigs(long paramId, int startIndex,
			int dataCount);

	/**
	 * getting the number of param configs by param id
	 * 
	 * @param paramId
	 * @return int
	 */
	public int getParamConfigsCount(long paramId);
	
	/**
	 * Getting the list of web scenario configs by scenario id
	 * 
	 * @param scenarioId
	 * @param startIndex
	 * @param dataCount
	 * @return List of Web Scenario Configs
	 */
	public List<CalculationConfig> getWebScenarioConfigs(long scenarioId, int startIndex,
			int dataCount);

	/**
	 * getting the number of param configs by param id
	 * 
	 * @param scenarioId
	 * @return int
	 */
	public int getWebScenarioConfigsCount(long scenarioId);

}
