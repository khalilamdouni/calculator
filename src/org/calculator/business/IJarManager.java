package org.calculator.business;

import java.io.IOException;
import java.net.URLClassLoader;
import java.util.List;

import org.calculator.models.CalculatorClass;
import org.calculator.models.JarFileModel;

public interface IJarManager {
	public String saveJar(JarFileModel jarFile) throws IllegalStateException, IOException;
	public List<CalculatorClass> reflectJar(String jarFileName) throws IOException, ClassNotFoundException;
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses);
	public List<JarFileModel> loadJars();
}
