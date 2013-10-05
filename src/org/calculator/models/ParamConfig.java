package org.calculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARAM_CONFIG")
public class ParamConfig {
	
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MIN")
	private int min;
	
	@Column(name = "MAX")
	private int max;
	
	@Column(name = "STEP")
	private int step;
	
	@Column(name = "ACTIVE")
	private boolean active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARAM_ID", nullable = false, updatable = false)
	private CalculatorMethodParam param;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public CalculatorMethodParam getParam() {
		return param;
	}

	public void setParam(CalculatorMethodParam param) {
		this.param = param;
	}

}
