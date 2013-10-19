package org.calculator.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

/**
 * JPA Entity to encapsulate Jar file metadata
 * 
 * @author khalil.amdouni
 *
 */
@Entity
@Table(name = "JARS")
@NamedQueries({
		@NamedQuery(name = "JarFileModel.getAllJars", query = "SELECT j FROM JarFileModel j"),
		@NamedQuery(name = "JarFileModel.getJarsCount", query = "SELECT COUNT(j) FROM JarFileModel j"),
		@NamedQuery(name = "JarFileModel.getJars", query = "SELECT j FROM JarFileModel j WHERE j.reflected=:reflected")})
public class JarFileModel extends AbstractModel {

	@Id
	@Column(name = "JAR_ID")
	@JsonProperty("jarId")
	private String jarId;

	@Column(name = "JAR_TITLE")
	@JsonProperty("title")
	private String title;

	@Column(name = "JAR_DESC")
	@JsonProperty("description")
	private String description;

	@OneToMany(mappedBy = "jarFile", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<CalculatorClass> calculatorClasses;

	@Column(name = "REFLECTED")
	private boolean reflected;
	
	@Transient
	private MultipartFile jarFile;

	@JsonProperty("jarId")
	public String getJarId() {
		return jarId;
	}

	public void setJarId(String jarId) {
		this.jarId = jarId;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("description")
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

	@JsonIgnore
	public List<CalculatorClass> getCalculatorClasses() {
		return calculatorClasses;
	}

	public void setCalculatorClasses(List<CalculatorClass> calculatorClasses) {
		this.calculatorClasses = calculatorClasses;
	}
	
	public boolean isReflected() {
		return reflected;
	}

	public void setReflected(boolean reflected) {
		this.reflected = reflected;
	}

	@Override
	public String toString() {
		return this.jarId + " | " + this.title;
	}

}
