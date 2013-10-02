package org.calculator.business;

import java.io.IOException;
import java.util.List;

import org.calculator.models.CalculatorClass;
import org.calculator.models.JarFileModel;

public interface IJarManager {
	public String saveJar(JarFileModel jarFile) throws IllegalStateException, IOException;
	public List<CalculatorClass> reflectJar(String jarId) throws IOException, ClassNotFoundException;
	public List<JarFileModel> loadJars(int startIndex, int dataCount);
	public JarFileModel updateJar(JarFileModel jarFile);
	public void deleteJar(String jarId);
	public int getJarsCount();
	public void reflectJars() throws IOException, ClassNotFoundException;
	public List<JarFileModel> getReflectedJars();
}
