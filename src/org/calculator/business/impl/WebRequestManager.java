package org.calculator.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.calculator.business.IWebRequestManager;
import org.calculator.dao.IGenericDao;
import org.calculator.dao.IWebRequestDao;
import org.calculator.models.WebRequest;
import org.calculator.models.WebScenario;

/**
 * @see org.calculator.business.IWebRequestManager
 * 
 * @author khalil.amdouni
 * 
 */
public class WebRequestManager extends GenericManager<WebRequest> implements
		IWebRequestManager {

	private IWebRequestDao webRequestDao;

	@Override
	public IGenericDao<WebRequest> getDao() {
		return (IGenericDao<WebRequest>) webRequestDao;
	}

	@Override
	public WebScenario populateWebScenario(WebScenario webScenario) {

		if (webScenario.getSequence() == null || "".equals(webScenario.getSequence())) {
			return webScenario;
		}
		String[] webRequestIds = webScenario.getSequence().split("-");
		List<WebRequest> webRequests = new ArrayList<WebRequest>();
		for (String webRequestId : webRequestIds) {
			webRequests.add(webRequestDao.getById(Long.valueOf(webRequestId)));
		}
		webScenario.setWebRequests(webRequests);
		return webScenario;
	}

	public IWebRequestDao getWebRequestDao() {
		return webRequestDao;
	}

	public void setWebRequestDao(IWebRequestDao webRequestDao) {
		this.webRequestDao = webRequestDao;
	}

}
