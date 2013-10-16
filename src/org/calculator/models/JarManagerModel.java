package org.calculator.models;

import java.util.List;

/**
 * View model of the JarManager functionality
 * 
 * @author khalil.amdouni
 *
 */
public class JarManagerModel {

	private JarFileModel jarFile;
	private List<CalculatorClass> calculatorClasses;

	public JarFileModel getJarFile() {
		return jarFile;
	}

	public void setJarFile(JarFileModel jarFile) {
		this.jarFile = jarFile;
	}

	public List<CalculatorClass> getCalculatorClasses() {
		return calculatorClasses;
	}

	public void setCalculatorClasses(List<CalculatorClass> calculatorClasses) {
		this.calculatorClasses = calculatorClasses;
	}

}
