package org.calculator.business;

import java.io.IOException;
import java.util.List;

import org.calculator.models.impl.CalculatorClass;
import org.calculator.models.impl.JarFileModel;

public interface IJarManager {
	public String saveJar(JarFileModel jarFile) throws IllegalStateException, IOException;
	public List<CalculatorClass> reflectJar(String jarFileName) throws IOException, ClassNotFoundException;
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses);
	public List<JarFileModel> loadJars();
}
