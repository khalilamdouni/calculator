package org.calculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * JPA Entity to encapsulate the execution plan
 * 
 * @author khalil.amdouni
 *
 */
@Entity
@Table(name = "EXEC_PLAN")
@NamedQueries({
		@NamedQuery(name = "ExecutionPlan.getExecutionPlans", query = "SELECT ep FROM ExecutionPlan ep"),
		@NamedQuery(name = "ExecutionPlan.getExecutionPlanById", query = "SELECT ep FROM ExecutionPlan ep WHERE id=:id") 
})
public class ExecutionPlan {
	
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "SEQUENCE")
	private String sequence;
	
	@Column(name = "NAMES_SEQUENCE")
	private String namesSequence;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getNamesSequence() {
		return namesSequence;
	}

	public void setNamesSequence(String namesSequence) {
		this.namesSequence = namesSequence;
	}
	
}
