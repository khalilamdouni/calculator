package org.calculator.models;

import java.util.List;

import org.calculator.models.IAlgorithme;

public class ConsoleModel {

	private String selectedAlgo;

	private List<Result> results;
	
	private List<JarFileModel> jarFiles;

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

	public List<JarFileModel> getJarFiles() {
		return jarFiles;
	}

	public void setJarFiles(List<JarFileModel> jarFiles) {
		this.jarFiles = jarFiles;
	}

}
