package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.models.CalculatorClass;
import org.calculator.models.JarFileModel;

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
