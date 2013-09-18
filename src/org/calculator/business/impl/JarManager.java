package org.calculator.business.impl;

import java.io.IOException;

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

	public IJarManagerDao getJarManagerDao() {
		return jarManagerDao;
	}

	public void setJarManagerDao(IJarManagerDao jarManagerDao) {
		this.jarManagerDao = jarManagerDao;
	}

}
