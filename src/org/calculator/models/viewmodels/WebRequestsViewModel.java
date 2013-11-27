package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.models.WebRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * View Model for the Web requests management functionality
 * 
 * @author khalil.amdouni
 *
 */
public class WebRequestsViewModel {
	private List<WebRequest> webRequests;
	private MultipartFile xmlFile;

	public List<WebRequest> getWebRequests() {
		return webRequests;
	}

	public void setWebRequests(List<WebRequest> webRequests) {
		this.webRequests = webRequests;
	}

	public MultipartFile getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(MultipartFile xmlFile) {
		this.xmlFile = xmlFile;
	}

}
