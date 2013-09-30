package org.calculator.business.impl;

import java.io.IOException;
import java.lang.reflect.Method;
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
import org.calculator.enums.CalculatorType;
import org.calculator.models.CalculatorClass;
import org.calculator.models.CalculatorClassMethod;
import org.calculator.models.CalculatorMethodParam;
import org.calculator.models.IAlgorithme;
import org.calculator.models.JarFileModel;

public class JarManager implements IJarManager {

	private IJarManagerDao jarManagerDao;
		
	private static final Logger logger = Logger.getLogger(JarManager.class);

	@Override
	public String saveJar(JarFileModel jarFile) throws IllegalStateException,
			IOException {
		return jarManagerDao.saveJar(jarFile);
	}

	private CalculatorClassMethod createCalculatorClassMethod(Method method) {
		CalculatorClassMethod calculatorClassMethod = null;
		List<CalculatorMethodParam> calculatorMethodParams = new ArrayList<CalculatorMethodParam>();
		Class<?>[] paramTypes = method.getParameterTypes();
		for (int i = 0; i < paramTypes.length; i++) {
			CalculatorMethodParam calculatorMethodParam = new CalculatorMethodParam(
					"arg" + i, CalculatorType.STRING);
			calculatorMethodParams.add(calculatorMethodParam);
		}
		calculatorClassMethod = new CalculatorClassMethod(method.getName(),
				calculatorMethodParams);
		return calculatorClassMethod;
	}
	
	private CalculatorClass createCalculatorClass(Class<?> c, String jarId) {
		CalculatorClass result = new CalculatorClass(jarId,
				c.getCanonicalName());

		List<CalculatorClassMethod> calculatorClassMethods = new ArrayList<CalculatorClassMethod>();
		for (Method method : c.getMethods()) {
			calculatorClassMethods.add(createCalculatorClassMethod(method));
		}
		result.setMethods(calculatorClassMethods);
		return result;
	}

	@Override
	public List<CalculatorClass> reflectJar(String jarFileName)
			throws IOException, ClassNotFoundException {
		String jarPath = "/home/khalil/work/spring/jartest/" + jarFileName;
		List<CalculatorClass> jarClasses = new ArrayList<CalculatorClass>();
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
			Class<?> c = cl.loadClass(className);

			jarClasses.add(createCalculatorClass(c,
					jarFileName.substring(0, jarFileName.indexOf('.'))));
		}
		jarFile.close();
		return jarClasses;
	}
	
	@Override
	public List<JarFileModel> loadJars(int startIndex, int dataCount) {
		return jarManagerDao.getJars(startIndex, dataCount);
	}
	
	public IJarManagerDao getJarManagerDao() {
		return jarManagerDao;
	}

	public void setJarManagerDao(IJarManagerDao jarManagerDao) {
		this.jarManagerDao = jarManagerDao;
	}

	@Override
	public int getJarsCount() {
		return this.jarManagerDao.getJarsCount();
	}

	@Override
	public JarFileModel updateJar(JarFileModel jarFile) {
		return this.jarManagerDao.updateJar(jarFile);
	}

	@Override
	public void deleteJar(String jarId) {
		this.jarManagerDao.deleteJar(jarId);
	}

}
