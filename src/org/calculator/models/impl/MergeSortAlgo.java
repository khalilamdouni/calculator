package org.calculator.models.impl;

import org.calculator.models.IAlgorithme;

public class MergeSortAlgo implements IAlgorithme {

	private String id;
	private String name;

	private Object[] data;
	private double[] sortData;

	public MergeSortAlgo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public MergeSortAlgo() {
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

	private void merge(double[] data, int first, int n1, int n2) {

		double[] temp = new double[n1 + n2];
		int copied = 0;
		int copied1 = 0;
		int copied2 = 0;
		int i;

		while ((copied1 < n1) && (copied2 < n2)) {
			if (data[first + copied1] < data[first + n1 + copied2])
				temp[copied++] = data[first + (copied1++)];
			else
				temp[copied++] = data[first + n1 + (copied2++)];
		}

		while (copied1 < n1)
			temp[copied++] = data[first + (copied1++)];
		while (copied2 < n2)
			temp[copied++] = data[first + n1 + (copied2++)];

		for (i = 0; i < n1 + n2; i++)
			data[first + i] = temp[i];
	}

	private void mergesort(double[] data, int first, int n) {
		int n1;
		int n2;

		if (n > 1) {
			n1 = n / 2;
			n2 = n - n1;

			mergesort(data, first, n1);
			mergesort(data, first + n1, n2);

			merge(data, first, n1, n2);
		}
	}

	@Override
	public void run() {
		mergesort(this.sortData, 0, this.sortData.length);
	}

	@Override
	public String toString() {
		return "MergeSort";
	}

}
