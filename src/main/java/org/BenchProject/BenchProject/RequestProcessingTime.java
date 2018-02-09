package org.BenchProject.BenchProject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestProcessingTime extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(RequestProcessingTime.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);

		return true;
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		long startTime = (Long) request.getAttribute("startTime");

		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;

		logger.info("Request method: " + request.getMethod());
		logger.info("Called URL: " + request.getRequestURL().toString());
		logger.info("Elapsed Time between handle and exit: " + executeTime + " ms");

	}

}
