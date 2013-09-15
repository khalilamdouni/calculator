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
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "MergeSort";
	}

}
