package org.calculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * JPA Entity used to encapsulate Param config element
 * 
 * @author khalil.amdouni
 *
 */
@Entity
@Table(name = "CORE_CALCULATION_CONFIG")
@NamedQueries({
	@NamedQuery(name = "ParamConfig.getAllConfigs", query = "SELECT cc FROM CalculationConfig cc WHERE param.id=:id"),
	@NamedQuery(name = "ParamConfig.getConfigsCount", query = "SELECT COUNT(cc) FROM CalculationConfig cc WHERE param.id=:id"),
	@NamedQuery(name = "WebScenarioConfig.getAllConfigs", query = "SELECT cc FROM CalculationConfig cc WHERE webScenario.id=:id"),
	@NamedQuery(name = "WebScenarioConfig.getConfigsCount", query = "SELECT COUNT(cc) FROM CalculationConfig cc WHERE webScenario.id=:id")
})
public class CalculationConfig extends AbstractModel {
	
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
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARAM_ID", nullable = true, updatable = false)
	private CalculatorMethodParam param;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCENARIO_ID", nullable = true, updatable = false)
	private WebScenario webScenario;
	
	public CalculationConfig() {
		super();
	}

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
	
	public WebScenario getWebScenario() {
		return webScenario;
	}

	public void setWebScenario(WebScenario webScenario) {
		this.webScenario = webScenario;
	}

	public void setParamId(long id) {
		this.param = new CalculatorMethodParam();
		this.param.setId(id);
	}
	
	public void setScenarioId(long id) {
		this.webScenario = new WebScenario();
		this.webScenario.setId(id);
	}

}
