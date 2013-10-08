package org.calculator.models;

import java.util.List;
import java.util.Map;

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
import javax.persistence.Transient;

import org.calculator.enums.CalculatorType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "METHOD_PARAMS")
@NamedQueries({
	@NamedQuery(name = "CalculatorMethodParam.getParamById", query = "SELECT p FROM CalculatorMethodParam p WHERE id=:id")
})
public class CalculatorMethodParam {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TYPE")
	@Type(type = "org.calculator.models.usertypes.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "org.calculator.enums.CalculatorType"),
			@Parameter(name = "identifierMethod", value = "name"),
			@Parameter(name = "valueOfMethod", value = "valueOf") })
	private CalculatorType type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "METHOD_ID", nullable = false, updatable = false)
	private CalculatorClassMethod method;
	
	@OneToMany(mappedBy = "param", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<ParamConfig> configs;

	@Transient
	private Map generatedDatas;
	
	@Transient
	private Class<?> paramType;
	
	public CalculatorMethodParam(String name, CalculatorType type) {
		super();
		this.name = name;
		this.type = type;
	}

	public CalculatorMethodParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ParamConfig getActiveConfig(){
		for (ParamConfig paramConfig : this.getConfigs()) {
			if (paramConfig.isActive()) {
				return paramConfig;
			}
		}
		return null;
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
	
	public CalculatorType[] getTypes() {
		return CalculatorType.values();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ParamConfig> getConfigs() {
		return configs;
	}

	public void setConfigs(List<ParamConfig> configs) {
		this.configs = configs;
	}

	public Map getGeneratedDatas() {
		return generatedDatas;
	}

	public void setGeneratedDatas(Map generatedDatas) {
		this.generatedDatas = generatedDatas;
	}

	public Class<?> getParamType() {
		return paramType;
	}

	public void setParamType(Class<?> paramType) {
		this.paramType = paramType;
	}

}
