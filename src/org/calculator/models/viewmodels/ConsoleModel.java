package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.enums.ConsoleNature;
import org.calculator.models.JarScenario;
import org.calculator.models.JarFileModel;
import org.calculator.models.Result;
import org.calculator.models.WebScenario;

/**
 * View model of the console functionality 
 * 
 * @author khalil.amdouni
 *
 */
public class ConsoleModel {

	private List<Result> results;
	
	private List<JarFileModel> jarFiles;
	
	private List<JarScenario> jarScenarios;
	
	private List<WebScenario> webScenarios;
	
	private ConsoleNature consoleNature;

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

	public List<JarScenario> getJarScenarios() {
		return jarScenarios;
	}

	public void setJarScenarios(List<JarScenario> jarScenarios) {
		this.jarScenarios = jarScenarios;
	}

	public ConsoleNature getConsoleNature() {
		return consoleNature;
	}

	public void setConsoleNature(ConsoleNature consoleNature) {
		this.consoleNature = consoleNature;
	}

	public List<WebScenario> getWebScenarios() {
		return webScenarios;
	}

	public void setWebScenarios(List<WebScenario> webScenarios) {
		this.webScenarios = webScenarios;
	}

}
