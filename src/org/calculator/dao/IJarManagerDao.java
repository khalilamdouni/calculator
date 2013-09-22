package org.calculator.dao;

import java.io.IOException;
import java.util.List;

import org.calculator.models.impl.JarFileModel;

public interface IJarManagerDao {
	
	public String saveJar(JarFileModel jarFile) throws IllegalStateException, IOException;
	public List<JarFileModel> getJars();
	
}
