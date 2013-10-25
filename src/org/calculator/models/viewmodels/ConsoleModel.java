package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.models.JarScenario;
import org.calculator.models.JarFileModel;
import org.calculator.models.Result;

/**
 * View model of the console functionality 
 * 
 * @author khalil.amdouni
 *
 */
public class ConsoleModel {

	private List<Result> results;
	
	private List<JarFileModel> jarFiles;
	
	private List<JarScenario> executionPlans;

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

	public List<JarScenario> getExecutionPlans() {
		return executionPlans;
	}

	public void setExecutionPlans(List<JarScenario> executionPlans) {
		this.executionPlans = executionPlans;
	}

}
