package org.BenchProject.BenchProject.Service.WeatherServices.Implementation;

import org.BenchProject.BenchProject.Service.WeatherService;
import org.BenchProject.BenchProject.Service.WeatherServices.Config.WeatherProviderConfig;
import org.BenchProject.BenchProject.Service.WeatherServices.Exceptions.ProviderEnumNotExistsException;
import org.BenchProject.BenchProject.Service.WeatherServices.Providers.AccuWeatherProvider;
import org.BenchProject.BenchProject.Service.WeatherServices.Providers.OpenWeatherProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherServiceImpl implements WeatherService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

	@Autowired
	private WeatherProviderConfig weatherConfig;

	@Autowired
	private AccuWeatherProvider accuweatherProvider;

	@Autowired
	private OpenWeatherProvider openweatherProvider;

	@Override
	public float getTemperatureFromCity(String city) throws Exception {

		switch (weatherConfig.getWeatherConfig()) {
		case PROVIDER_1:
			return accuweatherProvider.getTemperatureByCity(city);
		case PROVIDER_2:
			return openweatherProvider.getTemperatureByCity(city);
		default:
			throw new ProviderEnumNotExistsException();
		}
	}
}
