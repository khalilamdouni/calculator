package org.calculator.business;

import java.io.IOException;
import java.util.List;

import org.calculator.models.CalculatorClass;
import org.calculator.models.JarFileModel;

/**
 * The interface of the jar manager which is responsible of managing jar files
 * and jars infos
 * 
 * @author khalil.amdouni
 * 
 */
public interface IJarManager extends IGenericManager<JarFileModel> {

	/**
	 * saving jar file and jar info in the database
	 * 
	 * @param jarFile
	 * @return String; the jar id
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String saveJar(JarFileModel jarFile) throws IllegalStateException,
			IOException;

	/**
	 * Getting all classes within a jar file
	 * 
	 * @param jarId
	 * @return List of CalculatorClass
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<CalculatorClass> reflectJar(String jarId) throws IOException,
			ClassNotFoundException;

	/**
	 * Getting jars in the database
	 * 
	 * @param startIndex
	 * @param dataCount
	 * @return List JarFileModel
	 */
	public List<JarFileModel> loadJars(int startIndex, int dataCount);

	/**
	 * Getting jars number
	 * 
	 * @return int
	 */
	public int getJarsCount();

	/**
	 * Loading all classes in all jar files
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void reflectJars() throws IOException, ClassNotFoundException;

	/**
	 * Getting the list of reflected jar files
	 * 
	 * @return List JarFileModel
	 */
	public List<JarFileModel> getReflectedJars();

	/**
	 * getting instance of class in a specified jar file
	 * 
	 * @param jarId
	 * @param className
	 * @return Class object
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Class<?> loadClassesAndGetInstance(String jarId, String className)
			throws IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException;

}
