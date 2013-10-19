package org.calculator.dao;

import java.util.List;

import org.calculator.models.ParamConfig;

/**
 * The interface of param config Data Access Object
 * 
 * @author khalil.amdouni
 *
 */
public interface IParamConfigDao extends IGenericDao<ParamConfig> {

	public List<ParamConfig> getParamConfigs(long paramId, int startIndex, int dataCount);

	public int getParamConfigsCount(long paramId);

}
