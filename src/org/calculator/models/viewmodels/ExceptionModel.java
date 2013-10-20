package org.calculator.models.viewmodels;

/**
 * View model used by the error page of the application
 * 
 * @author khalil.amdouni
 *
 */
public class ExceptionModel {

	private String title;
	private String message;

	public ExceptionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionModel(String title, String message) {
		super();
		this.title = title;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
