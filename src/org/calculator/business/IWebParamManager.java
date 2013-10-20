package org.calculator.business;

import java.util.List;

import org.calculator.models.WebParam;

/**
 * The interface of the Web request manager which is responsible of saving,
 * editing Web params used in web calculation
 * 
 * @author khalil.amdouni
 * 
 */
public interface IWebParamManager extends IGenericManager<WebParam> {
	public List<WebParam> getWebParamByRequestId(long requestId);
}
