package org.calculator.business.impl;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;
import org.calculator.business.IJarManager;
import org.calculator.dao.ICalculatorClassDao;
import org.calculator.dao.IJarManagerDao;
import org.calculator.models.impl.CalculatorClass;
import org.calculator.models.impl.JarFileModel;

public class JarManager implements IJarManager {

	private IJarManagerDao jarManagerDao;
	
	private ICalculatorClassDao calculatorClassDao;
	
	private static final Logger logger = Logger.getLogger(JarManager.class);

	@Override
	public String saveJar(JarFileModel jarFile) throws IllegalStateException,
			IOException {
		return jarManagerDao.saveJar(jarFile);
	}
	
	@Override
	public List<CalculatorClass> reflectJar(String jarFileName) throws IOException,
			ClassNotFoundException {
		String jarPath = "/home/khalil/work/spring/jartest/" + jarFileName;
		List<CalculatorClass> jarClasses = new ArrayList<CalculatorClass>();
		JarFile jarFile = new JarFile(jarPath);
		Enumeration<JarEntry> e = jarFile.entries();
		URL[] urls = { new URL("jar:file:" + jarPath + "!/") };
		URLClassLoader cl = URLClassLoader.newInstance(urls);
		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith(".class")) {
				continue;
			}
			String className = je.getName().substring(0,
					je.getName().length() - 6);
			className = className.replace('/', '.');
			Class c = cl.loadClass(className);
			jarClasses.add(new CalculatorClass(jarFileName.substring(0, jarFileName.indexOf('.')), c.getCanonicalName()));
		}
		return jarClasses;
	}
	
	
	
	@Override
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses) {
		this.calculatorClassDao.saveCalculatorClasses(calculatorClasses);
	}
	
	@Override
	public List<JarFileModel> loadJars() {
		return jarManagerDao.getJars();
	}
	
	public IJarManagerDao getJarManagerDao() {
		return jarManagerDao;
	}

	public void setJarManagerDao(IJarManagerDao jarManagerDao) {
		this.jarManagerDao = jarManagerDao;
	}

	public ICalculatorClassDao getCalculatorClassDao() {
		return calculatorClassDao;
	}

	public void setCalculatorClassDao(ICalculatorClassDao calculatorClassDao) {
		this.calculatorClassDao = calculatorClassDao;
	}

}
