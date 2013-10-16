package org.calculator.business.impl;

import java.lang.reflect.Array;
import java.util.List;

import org.calculator.business.ITypesManager;
import org.calculator.enums.CalculatorType;
import org.calculator.models.CalculatorMethodParam;

/**
 * @see org.calculator.business.ITypesManager
 * 
 * @author khalil.amdouni
 *
 */
public class TypesManager implements ITypesManager {

	private Class<?> getClassType(CalculatorType type) {
		if (type == CalculatorType.NUMBER)
			return Double.class;
		if (type == CalculatorType.STRING)
			return String.class;
		if (type == CalculatorType.TAB_NUMBER)
			return Double[].class;
		if (type == CalculatorType.TAB_STRING)
			return String[].class;
		if (type == CalculatorType.TAB_TAB_NUMBER)
			return Double[][].class;
		if (type == CalculatorType.TAB_TAB_STRING)
			return String[][].class;
		if (type == CalculatorType.TAB_TAB_TAB_NUMBER)
			return Double[][][].class;
		return String[][][].class;
	}

	@Override
	public void detectType(CalculatorMethodParam param) {
		param.setParamType(getClassType(param.getType()));
	}

	@Override
	public Object[] transformData(List<CalculatorMethodParam> params,
			Object[] datas) {
		Object[] result = new Object[params.size()];

		for (int i = 0; i < result.length; i++) {

			if (params.get(i).getType() == CalculatorType.NUMBER) {
				result[i] = transform(datas[i], Double.class);
			} else if (params.get(i).getType() == CalculatorType.STRING) {
				result[i] = transform(datas[i], String.class);

			} else if (params.get(i).getType() == CalculatorType.TAB_NUMBER) {
				result[i] = transformToTab(datas[i], Double.class);

			} else if (params.get(i).getType() == CalculatorType.TAB_STRING) {
				result[i] = transformToTab(datas[i], String.class);

			} else if (params.get(i).getType() == CalculatorType.TAB_TAB_NUMBER) {
				result[i] = transformToTabTab(datas[i], Double.class);

			} else if (params.get(i).getType() == CalculatorType.TAB_TAB_STRING) {
				result[i] = transformToTabTab(datas[i], String.class);

			} else if (params.get(i).getType() == CalculatorType.TAB_TAB_TAB_NUMBER) {
				result[i] = transformToTabTabTab(datas[i], Double.class);

			} else if (params.get(i).getType() == CalculatorType.TAB_TAB_TAB_STRING) {
				result[i] = transformToTabTabTab(datas[i], String.class);
			}
		}

		return result;
	}

	@Override
	public <T> T transform(Object data, Class<T> classType) {
		return (T) data;
	}

	@Override
	public <T> T[] transformToTab(Object data, Class<T> classType) {

		T[] result = (T[]) Array.newInstance(classType,
				((Object[]) data).length);
		for (int i = 0; i < result.length; i++) {
			result[i] = (T) ((Object[]) data)[i];
		}
		return result;
	}

	@Override
	public <T> T[][] transformToTabTab(Object data, Class<T> classType) {
		T[][] result = (T[][]) Array.newInstance(classType,
				((Object[]) data).length, 0);
		for (int i = 0; i < result.length; i++) {

			result[i] = (T[]) Array.newInstance(classType,
					((Object[]) ((Object[]) data)[i]).length);
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = (T) ((Object[]) ((Object[]) data)[i])[j];
			}
		}
		return result;
	}

	@Override
	public <T> T[][][] transformToTabTabTab(Object data,
			Class<T> classType) {
		T[][][] result = (T[][][]) Array.newInstance(classType,
				((Object[]) data).length, 0, 0);
		for (int i = 0; i < result.length; i++) {
			result[i] = (T[][]) Array.newInstance(classType,
					((Object[]) ((Object[]) data)[i]).length, 0);
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = (T[]) Array
						.newInstance(
								classType,
								((Object[]) ((Object[]) ((Object[]) data)[i])[j]).length);
				for (int k = 0; k < result[i][j].length; k++) {
					result[i][j][k] = (T) ((Object[]) ((Object[]) ((Object[]) data)[i])[j])[k];
				}
			}
		}
		return result;
	}

}
