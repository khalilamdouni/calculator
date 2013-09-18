package org.calculator.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.calculator.dao.IJarManagerDao;
import org.springframework.web.multipart.MultipartFile;

public class JarManagerDao implements IJarManagerDao {

	@Override
	public String saveJar(MultipartFile jarFile) throws IllegalStateException,
			IOException {

		File jarLocalFile = new File("/home/khalil/work/spring/jartest/"
				+ UUID.randomUUID().toString() + ".jar");
		jarFile.transferTo(jarLocalFile);

		return jarLocalFile.getName();
	}

}
