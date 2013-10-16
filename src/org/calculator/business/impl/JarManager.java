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

/**
 * @see org.calculator.business.IJarManager
 * 
 * @author khalil.amdouni
 *
 */
public class JarManager implements IJarManager {

	private IJarManagerDao jarManagerDao;
	private ICalculatorClassDao calculatorClassDao;

	private static final Logger logger = Logger.getLogger(JarManager.class);

	@Override
	public String saveJar(JarFileModel jarFile) throws IllegalStateException,
			IOException {
		return jarManagerDao.saveJar(jarFile);
	}

	private CalculatorClassMethod createCalculatorClassMethod(Method method) {
		CalculatorClassMethod calculatorClassMethod = new CalculatorClassMethod();
		List<CalculatorMethodParam> calculatorMethodParams = new ArrayList<CalculatorMethodParam>();
		Class<?>[] paramTypes = method.getParameterTypes();
		for (int i = 0; i < paramTypes.length; i++) {
			CalculatorMethodParam calculatorMethodParam = new CalculatorMethodParam(
					"arg" + i, CalculatorType.STRING);
			calculatorMethodParam.setMethod(calculatorClassMethod);
			calculatorMethodParams.add(calculatorMethodParam);
		}
		calculatorClassMethod.setName(method.getName());
		calculatorClassMethod.setParams(calculatorMethodParams);
		return calculatorClassMethod;
	}

	private CalculatorClass createCalculatorClass(Class<?> c, String jarId) {
		CalculatorClass result = new CalculatorClass(jarId,
				c.getCanonicalName());

		List<CalculatorClassMethod> calculatorClassMethods = new ArrayList<CalculatorClassMethod>();
		for (Method method : c.getMethods()) {
			CalculatorClassMethod calculatorClassMethod = createCalculatorClassMethod(method);
			calculatorClassMethod.setCalculatorClass(result);
			calculatorClassMethods.add(calculatorClassMethod);
		}
		result.setMethods(calculatorClassMethods);
		return result;
	}

	@Override
	public List<CalculatorClass> reflectJar(String jarId) throws IOException,
			ClassNotFoundException {
		String jarPath = "/home/khalil/work/spring/jartest/" + jarId + ".jar";
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

			jarClasses.add(createCalculatorClass(c, jarId));
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

	@Override
	public void reflectJars() throws IOException, ClassNotFoundException {
		List<JarFileModel> unreflectedJars = jarManagerDao.getUnreflectedJars();
		for (JarFileModel jarFileModel : unreflectedJars) {
			calculatorClassDao.saveCalculatorClasses(reflectJar(jarFileModel
					.getJarId()));
			jarFileModel.setReflected(true);
			jarManagerDao.updateJar(jarFileModel);
		}
	}

	public ICalculatorClassDao getCalculatorClassDao() {
		return calculatorClassDao;
	}

	public void setCalculatorClassDao(ICalculatorClassDao calculatorClassDao) {
		this.calculatorClassDao = calculatorClassDao;
	}

	@Override
	public List<JarFileModel> getReflectedJars() {
		return jarManagerDao.getReflectedJars();

	}

	@Override
	public Class<?> loadClassesAndGetInstance(String jarId, String className)
			throws IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		String jarPath = "/home/khalil/work/spring/jartest/" + jarId + ".jar";
		JarFile jarFile = new JarFile(jarPath);
		Enumeration<JarEntry> e = jarFile.entries();
		Class<?> objectClass = null;
		URL[] urls = { new URL("jar:file:" + jarPath + "!/") };
		ClassLoader loader = IAlgorithme.class.getClassLoader();
		URLClassLoader cl = URLClassLoader.newInstance(urls, loader);

		while (e.hasMoreElements()) {
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith(".class")) {
				continue;
			}
			String currentClassName = je.getName().substring(0,
					je.getName().length() - 6);
			currentClassName = currentClassName.replace('/', '.');
			Class<?> c = cl.loadClass(currentClassName);

			if (currentClassName.equalsIgnoreCase(className)) {
				objectClass = c;
			}
		}
		jarFile.close();
		return objectClass;
	}

}
