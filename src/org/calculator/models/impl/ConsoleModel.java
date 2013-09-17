package org.calculator.models.impl;

import java.util.List;

import org.calculator.models.IAlgorithme;

public class ConsoleModel {

	private List<IAlgorithme> algos;

	private String selectedAlgo;

	private List<Result> results;

	public List<IAlgorithme> getAlgos() {
		return algos;
	}

	public void setAlgos(List<IAlgorithme> algos) {
		this.algos = algos;
	}

	public String getSelectedAlgo() {
		return selectedAlgo;
	}

	public void setSelectedAlgo(String selectedAlgo) {
		this.selectedAlgo = selectedAlgo;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
