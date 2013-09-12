package org.calculator.models.impl;

import org.calculator.models.IAlgorithme;

public class InsertionSortAlgo implements IAlgorithme {

	
	private String id;
	private String name;

	
	
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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "InsertionSort";
	}

}
