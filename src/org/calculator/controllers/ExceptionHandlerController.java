package org.calculator.controllers;

import java.io.IOException;

import org.calculator.models.ExceptionModel;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(IOException ex) {
		return new ModelAndView("error", "command", new ExceptionModel(
				"File Error", "Jar file not found or corrupted"));
	}

	@ExceptionHandler(ClassNotFoundException.class)
	public ModelAndView handleClassNotFoundException(ClassNotFoundException ex) {
		return new ModelAndView("error", "command", new ExceptionModel(
				"Class Error", "The class to execute isn't in the jar"));
	}

	@ExceptionHandler(InstantiationException.class)
	public ModelAndView handleInstantiationException(InstantiationException ex) {
		return new ModelAndView("error", "command", new ExceptionModel(
				"Class Error", "The system is enable to instantiate the class"));
	}

	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleDataAccessException(DataAccessException ex) {
		return new ModelAndView("error", "command", new ExceptionModel(
				"Data Error", "The system is enable access to Database"));
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		return new ModelAndView("error", "command", new ExceptionModel("Error",
				"Unknown error..."));
	}

}
