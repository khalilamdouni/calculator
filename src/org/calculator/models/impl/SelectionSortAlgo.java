package org.calculator.models.impl;

import org.calculator.models.IAlgorithme;

public class SelectionSortAlgo implements IAlgorithme {

	
	private String id;
	private String name;

	
	
	public SelectionSortAlgo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SelectionSortAlgo() {
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
		return "SelectionSort";
	}

}
