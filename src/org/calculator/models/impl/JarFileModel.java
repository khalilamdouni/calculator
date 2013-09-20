package org.calculator.models.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "JARS")
public class JarFileModel {

	@Id
	@Column(name = "JAR_ID")
	private String jarId;
	
	@Column(name = "JAR_TITLE")
	private String title;
	
	@Column(name = "JAR_DESC")
	private String description;
	
	@Transient
	private MultipartFile jarFile;

	public String getJarId() {
		return jarId;
	}

	public void setJarId(String jarId) {
		this.jarId = jarId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getJarFile() {
		return jarFile;
	}

	public void setJarFile(MultipartFile jarFile) {
		this.jarFile = jarFile;
	}

}
