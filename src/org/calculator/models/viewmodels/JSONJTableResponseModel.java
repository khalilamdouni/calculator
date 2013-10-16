package org.calculator.models.viewmodels;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Generic adapter model used by the JTable javascript framework
 * 
 * @author khalil.amdouni
 *
 * @param <T>
 */
public class JSONJTableResponseModel<T> {
	private String result;

	private T record;

	private String message;

	public JSONJTableResponseModel() {
	}

	public JSONJTableResponseModel(String result) {
		this.result = result;
	}

	public JSONJTableResponseModel(String result, T record) {
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
	public T getRecord() {
		return record;
	}

	public void setRecord(T record) {
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
