package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.models.WebRequest;

/**
 * View Model for the Web requests management functionality
 * 
 * @author khalil.amdouni
 *
 */
public class WebRequestsViewModel {
	private List<WebRequest> webRequests;

	public List<WebRequest> getWebRequests() {
		return webRequests;
	}

	public void setWebRequests(List<WebRequest> webRequests) {
		this.webRequests = webRequests;
	}

}
