package org.calculator.models.impl;

import org.calculator.models.IAlgorithme;

public class InsertionSortAlgo implements IAlgorithme {

	private String id;
	private String name;

	private Object[] data;
	private double[] sortData;

	public InsertionSortAlgo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public InsertionSortAlgo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

	public void transformData() {
		this.sortData = new double[this.data.length];
		for (int i = 0; i < this.sortData.length; i++) {
			this.sortData[i] = (Double) this.data[i];
		}
	}

	@Override
	public void run() {
		int j;
		double key;
		int i;

		for (i = 1; i < this.sortData.length; i++) {
			key = this.sortData[i];
			for (j = i - 1; (j >= 0) && (this.sortData[j] > key); j--) {
				this.sortData[j + 1] = this.sortData[j];
			}
			this.sortData[j + 1] = key;
		}
	}

	@Override
	public String toString() {
		return "InsertionSort";
	}

}
