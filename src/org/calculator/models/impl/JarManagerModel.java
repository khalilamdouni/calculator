package org.calculator.models.impl;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class JarManagerModel {

	private MultipartFile jarFile;
	private List<Class> calculatorClasses;

	public MultipartFile getJarFile() {
		return jarFile;
	}

	public void setJarFile(MultipartFile jarFile) {
		this.jarFile = jarFile;
	}

	public List<Class> getCalculatorClasses() {
		return calculatorClasses;
	}

	public void setCalculatorClasses(List<Class> calculatorClasses) {
		this.calculatorClasses = calculatorClasses;
	}

}
