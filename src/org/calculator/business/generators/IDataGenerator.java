package org.calculator.business.generators;

import java.util.List;

public interface IDataGenerator {
	public List<Object> generateData(long x, long y, long z);
}
