package org.calculator.business.impl;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.calculator.business.IClassManager;
import org.calculator.dao.ICalculatorClassDao;
import org.calculator.models.CalculatorClass;
import org.calculator.models.IAlgorithme;

public class ClassManager implements IClassManager {

	private ICalculatorClassDao calculatorClassDao;
	
	@Override
	public IAlgorithme loadCalculatorClass(long id) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		CalculatorClass calculatorClass = this.calculatorClassDao
				.getClassById(id);
		String jarPath = "/home/khalil/work/spring/jartest/"
				+ calculatorClass.getJarFile().getJarId() + ".jar";
		JarFile jarFile = new JarFile(jarPath);
		Enumeration<JarEntry> e = jarFile.entries();
		URL[] urls = { new URL("jar:file:" + jarPath + "!/") };
		ClassLoader loader = IAlgorithme.class.getClassLoader();
		URLClassLoader cl = URLClassLoader.newInstance(urls, loader);
		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith(".class")) {
				continue;
			}
			String className = je.getName().substring(0,
					je.getName().length() - 6);
			className = className.replace('/', '.');
			if (calculatorClass.getName().equalsIgnoreCase(className)) {
				Class<?> c = cl.loadClass(className);
				return (IAlgorithme)c.newInstance();
			}
		}
		return null;
	}

	public ICalculatorClassDao getCalculatorClassDao() {
		return calculatorClassDao;
	}

	public void setCalculatorClassDao(ICalculatorClassDao calculatorClassDao) {
		this.calculatorClassDao = calculatorClassDao;
	}

}
