package org.calculator.dao;

import java.io.IOException;
import java.util.List;

import org.calculator.models.JarFileModel;

/**
 * The interface of jars Data Access Object
 * 
 * @author khalil.amdouni
 * 
 */
public interface IJarManagerDao extends IGenericDao<JarFileModel> {

	public String saveJar(JarFileModel jarFile) throws IllegalStateException,
			IOException;

	public List<JarFileModel> getJars(int startIndex, int dataCount);

	/*public JarFileModel updateJar(JarFileModel jarFile);

	public void deleteJar(String jarId);*/

	public int getJarsCount();

	public List<JarFileModel> getUnreflectedJars();

	public List<JarFileModel> getReflectedJars();
}
