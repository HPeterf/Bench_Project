package org.BenchProject.BenchProject.ExceptionLogger;

import org.slf4j.Logger;
import org.springframework.web.client.HttpClientErrorException;

public class DemoExceptionLogger {

	private static final String STANDARD_ERROR = "Error: ";

	public static void exceptionLogger(Logger logger, Exception e) {
		logger.error(STANDARD_ERROR, e);
	}

	public static void exceptionLoggerWithHttpClient(Logger logger, HttpClientErrorException e) {
		logger.error(STANDARD_ERROR, e.getResponseBodyAsString());
		logger.error(STANDARD_ERROR, e);
	}
}
