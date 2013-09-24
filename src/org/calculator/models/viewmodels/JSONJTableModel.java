package org.calculator.models.viewmodels;

import java.util.List;

import org.calculator.models.JarFileModel;
import org.codehaus.jackson.annotate.JsonProperty;

public class JSONJTableModel {
	private String Result;

	private List<JarFileModel> Records;

	private int TotalRecordCount;

	private String Message;

	public JSONJTableModel(String Result, List<JarFileModel> Records,
			int TotalRecordCount) {
		this.Result = Result;
		this.Records = Records;
		this.TotalRecordCount = TotalRecordCount;
	}

	public JSONJTableModel(String Result, String Message) {
		this.Result = Result;
		this.Message = Message;
	}

	@JsonProperty("Result")
	public String getResult() {
		return Result;
	}

	public void setResult(String Result) {
		this.Result = Result;
	}

	@JsonProperty("Records")
	public List<JarFileModel> getRecords() {
		return Records;
	}

	public void setRecords(List<JarFileModel> Records) {
		this.Records = Records;
	}

	@JsonProperty("TotalRecordCount")
	public int getTotalRecordCount() {
		return TotalRecordCount;
	}

	public void setTotalRecordCount(int TotalRecordCount) {
		this.TotalRecordCount = TotalRecordCount;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return Message;
	}

	public void setMessage(String Message) {
		this.Message = Message;
	}
}
