package org.BenchProject.BenchProject.Service.WeatherServices.Providers;

import org.BenchProject.BenchProject.ExceptionLogger.DemoExceptionLogger;
import org.BenchProject.BenchProject.Model.AccuWeatherCityModel;
import org.BenchProject.BenchProject.Model.AccuWeatherCurrentConditionsModel;
import org.BenchProject.BenchProject.Service.WeatherServices.Exceptions.CityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AccuWeatherProvider extends WeatherProviderBase {

	private static final Logger logger = LoggerFactory.getLogger(AccuWeatherProvider.class);

	private static final String API_KEY = "uriLRgNFXC4YLuhjcu6fivWaKdTRy9l3";
	private static final String MAIN_PAGE = "http://dataservice.accuweather.com";

	private static final String SEARCH_FOR_CITY = "%s/locations/v1/cities/search?apikey=%s&q=%s";
	private static final String SEARCH_FOR_CURRENT_CONDITIONS = "%s/currentconditions/v1/%d?apikey=%s";

	private static final String CITY_NOT_FOUND = "[]";

	@Override
	public float getTemperatureByCity(String city) throws Exception {
		long cityId = getCityIdFromName(city);
		float temperature = getTemperature(cityId);
		return temperature;
	}

	private static long getCityIdFromName(String name) throws Exception {
		String requestString = String.format(SEARCH_FOR_CITY, MAIN_PAGE, API_KEY, name);

		try {
			String response = WeatherProviderBase.getSimpleResponse(requestString);
			if (response.equals(CITY_NOT_FOUND)) {
				throw new CityNotFoundException();
			}

			AccuWeatherCityModel cityModel = WeatherProviderBase
					.getResponseModelFromRequestStringFromArray(requestString, AccuWeatherCityModel[].class);

			logger.info("City model: " + cityModel);
			logger.info("City Key: " + cityModel.getKey());

			return Long.parseLong(cityModel.getKey());

		} catch (Exception e) {
			DemoExceptionLogger.exceptionLogger(logger, e);
			throw e;
		}
	}

	private static float getTemperature(long cityId) {
		String requestString = String.format(SEARCH_FOR_CURRENT_CONDITIONS, MAIN_PAGE, cityId, API_KEY);

		try {

			AccuWeatherCurrentConditionsModel currentConditionsModel = WeatherProviderBase
					.getResponseModelFromRequestStringFromArray(requestString,
							AccuWeatherCurrentConditionsModel[].class);

			logger.info("AccuweatherCurrentConditionsModel: " + currentConditionsModel.toString());
			logger.info(currentConditionsModel.getTemperature().getMetric().getValue());

			float celsius = Float.parseFloat(currentConditionsModel.getTemperature().getMetric().getValue());
			logger.info("Celsius: " + celsius);

			return celsius;

		} catch (Exception e) {
			DemoExceptionLogger.exceptionLogger(logger, e);
			throw e;
		}
	}
}
