package org.calculator.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CALCULATOR_CLASSES")
@NamedQueries({
	@NamedQuery(name = "CalculatorClass.getClassById", query = "SELECT c FROM CalculatorClass c WHERE c.id = :id")
})
public class CalculatorClass {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CLASS_NAME")
	private String name;

	@Column(name = "CLASS_DESC")
	private String description;

	@Column(name = "IS_ALGO")
	private boolean algo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JAR_ID", nullable = false)
	private JarFileModel jarFile;
	
	@OneToMany(mappedBy = "calculatorClass", cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<CalculatorClassMethod> methods;

	public CalculatorClass(String jarId, String name) {
		super();
		this.jarFile = new JarFileModel();
		this.jarFile.setJarId(jarId);
		this.name = name;
	}

	public CalculatorClass() {
		super();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JarFileModel getJarFile() {
		return jarFile;
	}

	public void setJarFile(JarFileModel jarFile) {
		this.jarFile = jarFile;
	}
	
	public List<CalculatorClassMethod> getMethods() {
		return methods;
	}

	public void setMethods(List<CalculatorClassMethod> methods) {
		this.methods = methods;
	}

	@Override
	public String toString() {
		return  this.id + " | " + this.name + " | " + this.algo + " | "
				+ this.description;
	}

}
