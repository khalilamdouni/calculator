package org.calculator.models.viewmodels;

import org.calculator.models.JarFileModel;
import org.codehaus.jackson.annotate.JsonProperty;

public class JSONJTableResponseModel {
	private String result;

	private JarFileModel record;

	private String message;

	public JSONJTableResponseModel() {
	}

	public JSONJTableResponseModel(String result) {
		this.result = result;
	}

	public JSONJTableResponseModel(String result, JarFileModel record) {
		this.result = result;
		this.record = record;
	}

	@JsonProperty("Result")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@JsonProperty("Record")
	public JarFileModel getRecord() {
		return record;
	}

	public void setRecord(JarFileModel record) {
		this.record = record;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
