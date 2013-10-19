package org.calculator.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Abstract model used to save creation and update dates of all JPA entities
 * 
 * @author khalil.amdouni
 * 
 */
@MappedSuperclass
public abstract class AbstractModel {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TS_CREATE")
	private Date tsCreate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TS_UPDATE")
	private Date tsUpdate;

	@PrePersist
	protected void onCreate() {
		tsUpdate = tsCreate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		tsUpdate = new Date();
	}

}
