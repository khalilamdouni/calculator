package org.calculator.business;

import java.io.IOException;
import java.util.List;

import org.calculator.models.impl.CalculatorClass;
import org.springframework.web.multipart.MultipartFile;

public interface IJarManager {
	public String saveJar(MultipartFile jarFile) throws IllegalStateException, IOException;
	public List<CalculatorClass> reflectJar(String jarFileName) throws IOException, ClassNotFoundException;
	public void saveCalculatorClasses(List<CalculatorClass> calculatorClasses);
}
