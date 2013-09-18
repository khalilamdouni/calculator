package org.calculator.models.impl;

import org.springframework.web.multipart.MultipartFile;

public class JarManagerModel {
	
	private MultipartFile jarFile;

	public MultipartFile getJarFile() {
		return jarFile;
	}

	public void setJarFile(MultipartFile jarFile) {
		this.jarFile = jarFile;
	}
	
}
