package org.calculator.business.impl;

import java.util.List;

import org.calculator.business.ITypesManager;
import org.calculator.enums.CalculatorType;
import org.calculator.models.CalculatorMethodParam;

public class TypesManager implements ITypesManager {

	private Class<?> getClassType(CalculatorType type) {
		if (type == CalculatorType.NUMBER)
			return double.class;
		if (type == CalculatorType.STRING)
			return String.class;
		if (type == CalculatorType.TAB_NUMBER)
			return double[].class;
		if (type == CalculatorType.TAB_STRING)
			return String[].class;
		if (type == CalculatorType.TAB_TAB_NUMBER)
			return double[][].class;
		if (type == CalculatorType.TAB_TAB_STRING)
			return String[][].class;
		if (type == CalculatorType.TAB_TAB_TAB_NUMBER)
			return double[][][].class;
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
				result[i] = transformToNumber(datas[i]);
			} else if (params.get(i).getType() == CalculatorType.STRING) {
				result[i] = transformToString(datas[i]);

			} else if (params.get(i).getType() == CalculatorType.TAB_NUMBER) {
				result[i] = transformToTabNumber(datas[i]);

			} else if (params.get(i).getType() == CalculatorType.TAB_STRING) {
				result[i] = transformToTabString(datas[i]);

			} else if (params.get(i).getType() == CalculatorType.TAB_TAB_NUMBER) {
				result[i] = transformToTabTabNumber(datas[i]);

			} else if (params.get(i).getType() == CalculatorType.TAB_TAB_STRING) {
				result[i] = transformToTabTabString(datas[i]);

			} else if (params.get(i).getType() == CalculatorType.TAB_TAB_TAB_NUMBER) {
				result[i] = transformToTabTabTabNumber(datas[i]);

			} else if (params.get(i).getType() == CalculatorType.TAB_TAB_TAB_STRING) {
				result[i] = transformToTabTabTabString(datas[i]);
			}
		}

		return result;
	}

	@Override
	public double transformToNumber(Object data) {
		return (Double) data;
	}

	@Override
	public double[] transformToTabNumber(Object data) {
		double[] result = new double[((Object[]) data).length];
		for (int i = 0; i < result.length; i++) {
			result[i] = (Double) ((Object[]) data)[i];
		}
		return result;
	}

	@Override
	public double[][] transformToTabTabNumber(Object data) {
		double[][] result = new double[((Object[]) data).length][];
		for (int i = 0; i < result.length; i++) {
			result[i] = new double[((Object[]) ((Object[]) data)[i]).length];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = (Double) ((Object[]) ((Object[]) data)[i])[j];
			}
		}
		return result;
	}

	@Override
	public double[][][] transformToTabTabTabNumber(Object data) {
		double[][][] result = new double[((Object[]) data).length][][];
		for (int i = 0; i < result.length; i++) {
			result[i] = new double[((Object[]) ((Object[]) data)[i]).length][];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = new double[((Object[]) ((Object[]) ((Object[]) data)[i])[j]).length];
				for (int k = 0; k < result[i][j].length; k++) {
					result[i][j][k] = (Double) ((Object[]) ((Object[]) ((Object[]) data)[i])[j])[k];
				}
			}
		}
		return result;
	}

	@Override
	public String transformToString(Object data) {
		return (String) data;
	}

	@Override
	public String[] transformToTabString(Object data) {
		String[] result = new String[((Object[]) data).length];
		for (int i = 0; i < result.length; i++) {
			result[i] = (String) ((Object[]) data)[i];
		}
		return result;
	}

	@Override
	public String[][] transformToTabTabString(Object data) {
		String[][] result = new String[((Object[]) data).length][];
		for (int i = 0; i < result.length; i++) {
			result[i] = new String[((Object[]) ((Object[]) data)[i]).length];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = (String) ((Object[]) ((Object[]) data)[i])[j];
			}
		}
		return result;
	}

	@Override
	public String[][][] transformToTabTabTabString(Object data) {
		String[][][] result = new String[((Object[]) data).length][][];
		for (int i = 0; i < result.length; i++) {
			result[i] = new String[((Object[]) ((Object[]) data)[i]).length][];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = new String[((Object[]) ((Object[]) ((Object[]) data)[i])[j]).length];
				for (int k = 0; k < result[i][j].length; k++) {
					result[i][j][k] = (String) ((Object[]) ((Object[]) ((Object[]) data)[i])[j])[k];
				}
			}
		}
		return result;
	}

}
