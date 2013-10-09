package org.calculator.business;

import java.util.List;

import org.calculator.models.CalculatorMethodParam;

public interface ITypesManager {
	public void detectType(CalculatorMethodParam param);

	public Object[] transformData(List<CalculatorMethodParam> params,
			Object[] datas);

	public <T> T transform(Object data, Class<T> classType);

	public <T> T[] transformToTab(Object data, Class<T> classType);

	public <T> T[][] transformToTabTab(Object data, Class<T> classType);

	public <T> T[][][] transformToTabTabTab(Object data, Class<T> classType);
}
