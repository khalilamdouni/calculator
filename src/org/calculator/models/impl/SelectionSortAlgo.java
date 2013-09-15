package org.calculator.models.impl;

import org.calculator.models.IAlgorithme;

public class SelectionSortAlgo implements IAlgorithme {

	private String id;
	private String name;

	private Object[] data;
	private double[] sortData;

	public SelectionSortAlgo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SelectionSortAlgo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void transformData() {
		this.sortData = new double[this.data.length];
		for (int i = 0; i < this.sortData.length; i++) {
			this.sortData[i] = (Double) this.data[i];
		}
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
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

	@Override
	public void run() {
		int i, j;
		int iMin;

		for (i = 0; i < this.sortData.length - 1; i++) {
			iMin = i;
			for (j = i + 1; j < this.sortData.length; j++) {
				if (this.sortData[j] < this.sortData[iMin]) {
					iMin = j;
				}
			}
			if (iMin != i) {
				this.sortData[i] = this.sortData[i] + this.sortData[iMin];
				this.sortData[iMin] = this.sortData[i] - this.sortData[iMin];
				this.sortData[i] = this.sortData[i] - this.sortData[iMin];
			}
		}
	}

	@Override
	public String toString() {
		return "SelectionSort";
	}

}
