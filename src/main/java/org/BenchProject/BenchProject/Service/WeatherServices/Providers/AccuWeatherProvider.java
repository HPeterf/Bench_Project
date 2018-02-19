package org.BenchProject.BenchProject.Service.WeatherServices.Providers;

import org.BenchProject.BenchProject.Service.WeatherServices.Exceptions.CityNotFoundException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccuWeatherProvider extends WeatherProviderBase {

	private static final Logger logger = LoggerFactory.getLogger(AccuWeatherProvider.class);

	private static final String API_KEY = "W7V4AhKA09uXZYgQAgQGv31hvLV4GGXA";
	private static final String MAIN_PAGE = "http://dataservice.accuweather.com";

	private static final String SEARCH_FOR_CITY = "%s/locations/v1/cities/search?apikey=%s&q=%s";
	private static final String SEARCH_FOR_CURRENT_CONDITIONS = "%s/currentconditions/v1/%d?apikey=%s";

	@Override
	public float getTemperatureByCity(String city) throws Exception {
		long cityId = getCityIdFromName(city);
		float temperature = getTemperature(cityId);
		return temperature;
	}

	private static long getCityIdFromName(String name) throws Exception {
		String request = String.format(SEARCH_FOR_CITY, MAIN_PAGE, API_KEY, name);
		String response = getResponseFromRequest(request);

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
		String request = String.format(SEARCH_FOR_CURRENT_CONDITIONS, MAIN_PAGE, cityId, API_KEY);
		String response = getResponseFromRequest(request);

		String tempKey = "Temperature";
		String metricTempKey = "Metric";
		String temperatureTypeValueKey = "Value";

		try {

			JSONObject jsonObject = getJSONObjectFromString(response, true);

			String temperature = jsonObject.get(tempKey).toString();
			logger.info("Temperature: " + temperature);

			String metricTemperature = getStringFromJSONObjectWithKey(temperature, metricTempKey);
			logger.info("Metric temperature: " + metricTemperature);

			String celsiusInString = getStringFromJSONObjectWithKey(metricTemperature, temperatureTypeValueKey);
			logger.info("Celsius: " + celsiusInString);

			float celsius = Float.parseFloat(celsiusInString);
			logger.info("Celsius: " + celsius);

			return celsius;

		} catch (Exception e) {
			throw e;
		}
	}

	private static String formatJSONStringIfInAnotherArray(String jsonString) throws ParseException {
		String formattedJSONString = jsonString;
		if (jsonString.startsWith("[")) {
			formattedJSONString = formattedJSONString.substring(1, jsonString.length() - 1);
			formattedJSONString = formattedJSONString.substring(0, jsonString.length() - 2);
			logger.info("Formatted JSON: " + formattedJSONString);
		} else {
			logger.info("JSON is OK!");
		}
		return formattedJSONString;
	}

	private static JSONObject getJSONObjectFromString(String jsonString) throws ParseException {
		return getJSONObjectFromString(jsonString, false);
	}

	private static JSONObject getJSONObjectFromString(String jsonString, boolean isOuterArrayNotNecessary)
			throws ParseException {
		if (isOuterArrayNotNecessary) {
			jsonString = formatJSONStringIfInAnotherArray(jsonString);
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

	private static String getStringFromJSONObjectWithKey(String jsonObject, String key) throws ParseException {
		JSONObject tempObject = getJSONObjectFromString(jsonObject);
		String result = tempObject.get(key).toString();
		return result;
	}
}
