package org.calculator.dao;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IJarManagerDao {
	
	public String saveJar(MultipartFile jarFile) throws IllegalStateException, IOException;
	
}
