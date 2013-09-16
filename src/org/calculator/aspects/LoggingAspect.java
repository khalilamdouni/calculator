package org.calculator.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	private static final Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("within(org.calculator.controllers.*)")
	public void logBeforeController(JoinPoint joinPoint) {
		logger.info("*********** Before call of " + joinPoint.getSignature().getName());
	}
	
	@After("within(org.calculator.controllers.*)")
	public void logAfterController(JoinPoint jointPoint) {
		logger.info("*********** After call of " + jointPoint.getSignature().getName());
	}
	
	
}
