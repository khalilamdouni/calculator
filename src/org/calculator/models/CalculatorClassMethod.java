package org.calculator.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_METHODS")
public class CalculatorClassMethod {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLASS_ID")
	private CalculatorClass calculatorClass;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "method")
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

	public CalculatorClass getCalculatorClass() {
		return calculatorClass;
	}

	public void setCalculatorClass(CalculatorClass calculatorClass) {
		this.calculatorClass = calculatorClass;
	}

}
