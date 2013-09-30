package org.calculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.calculator.enums.CalculatorType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "METHOD_PARAMS")
public class CalculatorMethodParam {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NQME")
	private String name;

	@Column(name = "TYPE")
	@Type(type = "org.calculator.models.usertypes.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "org.calculator.enums.CalculatorType"),
			@Parameter(name = "identifierMethod", value = "name"),
			@Parameter(name = "valueOfMethod", value = "valueOf") })
	private CalculatorType type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "METHOD_ID")
	private CalculatorClassMethod method;

	public CalculatorMethodParam(String name, CalculatorType type) {
		super();
		this.name = name;
		this.type = type;
	}

	public CalculatorMethodParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CalculatorType getType() {
		return type;
	}

	public void setType(CalculatorType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CalculatorClassMethod getMethod() {
		return method;
	}

	public void setMethod(CalculatorClassMethod method) {
		this.method = method;
	}

}