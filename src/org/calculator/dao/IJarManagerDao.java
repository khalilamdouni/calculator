package org.calculator.dao;

import java.io.IOException;

import org.calculator.models.impl.JarFileModel;

public interface IJarManagerDao {
	
	public String saveJar(JarFileModel jarFile) throws IllegalStateException, IOException;
	
}
