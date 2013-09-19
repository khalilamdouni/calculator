package org.calculator.models.impl;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class JarManagerModel {

	private MultipartFile jarFile;
	private List<CalculatorClass> calculatorClasses;

	public MultipartFile getJarFile() {
		return jarFile;
	}

	public void setJarFile(MultipartFile jarFile) {
		this.jarFile = jarFile;
	}

	public List<CalculatorClass> getCalculatorClasses() {
		return calculatorClasses;
	}

	public void setCalculatorClasses(List<CalculatorClass> calculatorClasses) {
		this.calculatorClasses = calculatorClasses;
	}

}
