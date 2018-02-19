package org.BenchProject.BenchProject.Service.WeatherServices.Providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public abstract class WeatherProviderBase {

	private static final Logger logger = LoggerFactory.getLogger(WeatherProviderBase.class);

	public abstract float getTemperatureByCity(String city) throws Exception;

	protected static String getResponseFromRequest(String request) {
		logger.info("Request String sent: " + request);

		RestTemplate template = new RestTemplate();
		String response = template.getForObject(request, String.class);

		logger.info("Response: " + response);

		return response;
	}
}
