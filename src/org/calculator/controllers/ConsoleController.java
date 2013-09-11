package org.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * The Controller of the principal functionality of the calculator
 * 
 * @author khalil AMDOUNI
 *
 */
@Controller
public class ConsoleController {
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public ModelAndView calculate() {
		return null;
	}
	
	
	
}
