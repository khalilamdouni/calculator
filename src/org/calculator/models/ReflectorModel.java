package org.calculator.models;

import java.util.List;

public class ReflectorModel {

	private List<JarFileModel> jarFiles;

	public ReflectorModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReflectorModel(List<JarFileModel> jarFiles) {
		super();
		this.jarFiles = jarFiles;
	}

	public List<JarFileModel> getJarFiles() {
		return jarFiles;
	}

	public void setJarFiles(List<JarFileModel> jarFiles) {
		this.jarFiles = jarFiles;
	}

}