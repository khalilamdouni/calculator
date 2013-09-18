package org.calculator.business;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IJarManager {
	public String saveJar(MultipartFile jarFile) throws IllegalStateException, IOException;
}
