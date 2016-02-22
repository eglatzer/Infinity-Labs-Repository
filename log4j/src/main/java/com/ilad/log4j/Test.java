package com.ilad.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
	private static final Logger logger = LogManager.getLogger(Test.class);
	
	public static void main(String[] args) {
		logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.error("This is an error message");
        logger.warn("This is an warn message");
	}
}