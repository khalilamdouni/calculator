package org.calculator.business;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface IJarManager {
	public String saveJar(MultipartFile jarFile) throws IllegalStateException, IOException;
	public List<Class> reflectJar(String jarFileName) throws IOException, ClassNotFoundException ;
}
