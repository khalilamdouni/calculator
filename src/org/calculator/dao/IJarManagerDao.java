package org.calculator.dao;

import java.io.IOException;
import java.util.List;

import org.calculator.models.JarFileModel;

public interface IJarManagerDao {
	
	public String saveJar(JarFileModel jarFile) throws IllegalStateException, IOException;
	public List<JarFileModel> getJars(int startIndex, int dataCount);
	public int getJarsCount();
	
}
