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

import org.calculator.business.IJarManager;
import org.calculator.dao.IJarManagerDao;
import org.springframework.web.multipart.MultipartFile;

public class JarManager implements IJarManager {

	private IJarManagerDao jarManagerDao;

	@Override
	public String saveJar(MultipartFile jarFile) throws IllegalStateException,
			IOException {
		return jarManagerDao.saveJar(jarFile);
	}
	
	@Override
	public List<Class> reflectJar(String jarFileName) throws IOException,
			ClassNotFoundException {

		String jarPath = "/home/khalil/work/spring/jartest/" + jarFileName;
		List<Class> jarClasses = new ArrayList<Class>();
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
			jarClasses.add(c);
		}
		return jarClasses;
	}

	public IJarManagerDao getJarManagerDao() {
		return jarManagerDao;
	}

	public void setJarManagerDao(IJarManagerDao jarManagerDao) {
		this.jarManagerDao = jarManagerDao;
	}

}
