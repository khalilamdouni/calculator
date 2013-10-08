package org.calculator.business;

import java.util.List;

import org.calculator.models.CalculatorMethodParam;

public interface ITypesManager {
	public void detectType(CalculatorMethodParam param);
	public Object[] transformData(List<CalculatorMethodParam> params, Object[] datas);
	public double transformToNumber(Object data);
	public double[] transformToTabNumber(Object data);
	public double[][] transformToTabTabNumber(Object data);
	public double[][][] transformToTabTabTabNumber(Object data);
	public String transformToString(Object data);
	public String[] transformToTabString(Object data);
	public String[][] transformToTabTabString(Object data);
	public String[][][] transformToTabTabTabString(Object data);
}
