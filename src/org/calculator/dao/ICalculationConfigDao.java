package org.calculator.dao;

import java.util.List;

import org.calculator.models.CalculationConfig;

/**
 * The interface of param config Data Access Object
 * 
 * @author khalil.amdouni
 *
 */
public interface ICalculationConfigDao extends IGenericDao<CalculationConfig> {

	public List<CalculationConfig> getParamConfigs(long paramId, int startIndex, int dataCount);

	public int getParamConfigsCount(long paramId);

	public List<CalculationConfig> getWebScenarioConfigs(long scenarioId, int startIndex,
			int dataCount);

	public int getWebScenarioConfigsCount(long scenarioId);

}
