package org.calculator.models.impl;

import java.util.UUID;

public class CalculatorClass {

	private String jarId;
	private String name;
	private String description;
	private boolean algo = true;
	
	public CalculatorClass(String jarId, String name) {
		super();
		this.jarId = jarId;
		this.name = name;
	}

	public CalculatorClass() {
		super();
	}

	public String getJarId() {
		return jarId;
	}

	public void setJarId(String jarId) {
		this.jarId = jarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getAlgo() {
		return algo;
	}

	public void setAlgo(boolean algo) {
		this.algo = algo;
	}
	
	@Override
	public String toString() {
		return this.jarId + " | " + this.name + " | " + this.algo
				+ " | " + this.description;
	}

}
