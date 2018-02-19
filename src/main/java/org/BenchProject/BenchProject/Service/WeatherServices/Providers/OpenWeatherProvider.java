package org.BenchProject.BenchProject.Service.WeatherServices.Providers;

import org.BenchProject.BenchProject.Service.WeatherServices.Exceptions.CityNotFoundException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenWeatherProvider extends WeatherProviderBase {

	private static final Logger logger = LoggerFactory.getLogger(OpenWeatherProvider.class);

	private static final String API_KEY = "c4b10d6bd0adc8d89ea76d6ed6ad0314";
	private static final String MAIN_PAGE = "http://api.openweathermap.org";

	private static final String SEARCH_FOR_CITY = "api.openweathermap.org/data/2.5/weather?id=%s";
	private static final String CURRENT_CONDITIONS = "api.openweathermap.org/data/2.5/weather?q={city name}";

	@Override
	public float getTemperatureByCity(String city) throws Exception {
		long cityId = getCityIdFromCityName(city);
		float temperature = getTemperature(cityId);
		return temperature;
	}

	private static long getCityIdFromCityName(String cityName) throws Exception {
		String requestString = String.format(SEARCH_FOR_CITY, MAIN_PAGE, API_KEY, cityName);
		String response = getResponseFromRequest(requestString);

		if (response.equals("[]")) {
			throw new CityNotFoundException();
		}

		String cityIdKeyInJSON = "Key";

		try {

			JSONObject jsonObject = getJSONObjectFromString(response, true);
			String cityIdInString = (String) jsonObject.get(cityIdKeyInJSON);
			logger.info("City ID in String: " + cityIdInString);
			long cityId = Long.parseLong(cityIdInString);
			logger.info("City ID in Long: " + cityId);
			return cityId;
		} catch (Exception e) {
			throw e;
		}

	}

	private static float getTemperature(long cityId) throws Exception {
		String requestString = String.format(CURRENT_CONDITIONS, MAIN_PAGE, cityId, API_KEY);

		String response = getResponseFromRequest(requestString);

		String temperatureKey = "Temperature";
		String metricTemperatureKey = "Metric";
		String temperatureTypeValueKey = "Value";

		try {

			JSONObject jsonObject = getJSONObjectFromString(response, true);

			String temperature = jsonObject.get(temperatureKey).toString();
			logger.info("Temperature String: " + temperature);
			String metricTemperature = getStringFromJSONObjectStringWithKey(temperature, metricTemperatureKey);

			logger.info("Metric temperature String: " + metricTemperature);
			String celsiusInString = getStringFromJSONObjectStringWithKey(metricTemperature, temperatureTypeValueKey);

			logger.info("Celsius String: " + celsiusInString);
			float celsius = Float.parseFloat(celsiusInString);
			logger.info("Celsius as number: " + celsius);

			return celsius;

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	private static String formatJSONStringIfInAnAnotherArray(String jsonString) throws ParseException {
		String formattedJSONString = jsonString;
		if (jsonString.startsWith("[")) {
			formattedJSONString = formattedJSONString.substring(1, jsonString.length() - 1);
			formattedJSONString = formattedJSONString.substring(0, jsonString.length() - 2);
			logger.info("formatted JSON String: " + formattedJSONString);

		} else {
			logger.info("The JSON String is ok.");
		}
		return formattedJSONString;

	}

	private static JSONObject getJSONObjectFromString(String jsonString) throws ParseException {
		return getJSONObjectFromString(jsonString, false);

	}

	private static JSONObject getJSONObjectFromString(String jsonString, boolean isOuterArrayNotNecessary)
			throws ParseException {
		if (isOuterArrayNotNecessary) {
			jsonString = formatJSONStringIfInAnAnotherArray(jsonString);
		}

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(jsonString);
			JSONObject jsonObject = (JSONObject) obj;
			return jsonObject;

		} catch (ParseException e) {
			throw e;

		}

	}

	private static String getStringFromJSONObjectStringWithKey(String jsonObjectString, String key) throws Exception {

		JSONObject tempObject = getJSONObjectFromString(jsonObjectString);
		String result = tempObject.get(key).toString();
		return result;

	}
}
