package org.calculator.models.impl;

import org.calculator.models.IAlgorithme;

public class HeapSortAlgo implements IAlgorithme {
	
	private String id;
	private String name;

	private Object[] data;
	private double[] sortData;
	
	public HeapSortAlgo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public HeapSortAlgo() {
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

	
	private void heapify(double[] a, int count) {
		int start = (count - 2) / 2; 

		while (start >= 0) {

			siftDown(a, start, count - 1);
			start--;
		}
	}

	private void siftDown(double[] a, int start, int end) {
		int root = start;

		while ((root * 2 + 1) <= end) {
			int child = root * 2 + 1;
			if (child + 1 <= end && a[child] < a[child + 1])
				child = child + 1;
			if (a[root] < a[child]) {
				double tmp = a[root];
				a[root] = a[child];
				a[child] = tmp;
				root = child;
			} else
				return;
		}
	}
	
	@Override
	public void run() {
		int count = this.sortData.length;
		heapify(this.sortData, count);
		int end = count - 1;
		while(end > 0){

			double tmp = this.sortData[end];
			this.sortData[end] = this.sortData[0];
			this.sortData[0] = tmp;
			siftDown(this.sortData, 0, end - 1);
			end--;
		}
		

	}
	
	@Override
	public String toString() {
		return "HeapSort";
	}

}
