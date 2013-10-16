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

/**
 * JPA Entity to encapsulate the class method metadata
 * 
 * @author khalil.amdouni
 *
 */
@Entity
@Table(name = "CLASS_METHODS")
@NamedQueries({
	@NamedQuery(name = "CalculatorClassMethod.getMethodById", query = "SELECT m FROM CalculatorClassMethod m WHERE id=:id")
})
public class CalculatorClassMethod {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLASS_ID", nullable = false, updatable = false)
	private CalculatorClass calculatorClass;

	@OneToMany(mappedBy = "method", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<CalculatorMethodParam> params;

	public CalculatorClassMethod() {
		super();
	}

	public CalculatorClassMethod(String name, List<CalculatorMethodParam> params) {
		super();
		this.name = name;
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CalculatorMethodParam> getParams() {
		return params;
	}

	public void setParams(List<CalculatorMethodParam> params) {
		this.params = params;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CalculatorClass getCalculatorClass() {
		return calculatorClass;
	}

	public void setCalculatorClass(CalculatorClass calculatorClass) {
		this.calculatorClass = calculatorClass;
	}

}
