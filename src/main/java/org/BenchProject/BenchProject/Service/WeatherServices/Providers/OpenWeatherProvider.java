package org.BenchProject.BenchProject.Service.WeatherServices.Providers;

import org.BenchProject.BenchProject.ExceptionLogger.DemoExceptionLogger;
import org.BenchProject.BenchProject.Model.OpenWeatherModel;
import org.BenchProject.BenchProject.Service.WeatherServices.Exceptions.CityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class OpenWeatherProvider extends WeatherProviderBase {
	public OpenWeatherProvider() {
		super(PROVIDER_NAME);
	}

	private static final Logger logger = LoggerFactory.getLogger(OpenWeatherProvider.class);
	private static final String API_KEY = "c4b10d6bd0adc8d89ea76d6ed6ad0314";
	private static final String SEARCH_PATTERN = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
	private static final String CITY_NOT_FOUND = "City not found";
	private static final String PROVIDER_NAME = "OpenWeather";

	@Override
	public float getTemperatureByCity(String city) throws Exception {
		String requestString = String.format(SEARCH_PATTERN, city, API_KEY);

		try {

			OpenWeatherModel model = getResponseModelFromRequestString(requestString, OpenWeatherModel.class);

			float celsius = model.getMain().getTempInCelsius();
			return celsius;

		} catch (HttpClientErrorException e) {
			DemoExceptionLogger.exceptionLoggerWithHttpClient(logger, e);

			if (e.getResponseBodyAsString().contains(CITY_NOT_FOUND)) {
				throw new CityNotFoundException();
			} else {
				throw e;
			}
		} catch (Exception e) {
			DemoExceptionLogger.exceptionLogger(logger, e);
			throw e;
		}
	}
}
