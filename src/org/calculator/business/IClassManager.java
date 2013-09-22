package org.calculator.business;

import java.io.IOException;

import org.calculator.models.IAlgorithme;

public interface IClassManager {
	public IAlgorithme loadCalculatorClass(long id) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
