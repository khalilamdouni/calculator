package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.IConfigManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.ICalculationConfigDao;
import org.calculator.models.CalculationConfig;

/**
 * @see  org.calculator.business.IConfigManager
 * 
 * @author khalil.amdouni
 *
 */
public class ConfigManager extends GenericManager<CalculationConfig> implements IConfigManager {

	private ICalculationConfigDao calculationConfigDao;

	@Override
	public List<CalculationConfig> getParamConfigs(long paramId, int startIndex,
			int dataCount) {
		return calculationConfigDao.getParamConfigs(paramId, startIndex, dataCount);
	}

	@Override
	public int getParamConfigsCount(long paramId) {
		return calculationConfigDao.getParamConfigsCount(paramId);
	}

	@Override
	public List<CalculationConfig> getWebScenarioConfigs(long scenarioId,
			int startIndex, int dataCount) {
		return calculationConfigDao.getWebScenarioConfigs(scenarioId, startIndex, dataCount);
	}

	@Override
	public int getWebScenarioConfigsCount(long scenarioId) {
		return calculationConfigDao.getWebScenarioConfigsCount(scenarioId);
	}

	public ICalculationConfigDao getCalculationConfigDao() {
		return calculationConfigDao;
	}

	public void setCalculationConfigDao(ICalculationConfigDao calculationConfigDao) {
		this.calculationConfigDao = calculationConfigDao;
	}

	@Override
	public IGenericDao<CalculationConfig> getDao() {
		return (IGenericDao<CalculationConfig>) calculationConfigDao;
	}

}
