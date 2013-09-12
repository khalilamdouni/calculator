package org.calculator.models.impl;

import java.util.List;

import org.calculator.models.IAlgorithme;

public class ConsoleModel {

	private List<IAlgorithme> algos;

	private IAlgorithme algo;

	private List<Result> results;

	public List<IAlgorithme> getAlgos() {
		return algos;
	}

	public void setAlgos(List<IAlgorithme> algos) {
		this.algos = algos;
	}

	public IAlgorithme getAlgo() {
		return algo;
	}

	public void setAlgo(IAlgorithme algo) {
		this.algo = algo;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
