package org.BenchProject.BenchProject.Service.WeatherServices.Implementation;

import org.BenchProject.BenchProject.Service.WeatherService;
import org.BenchProject.BenchProject.Service.WeatherServices.Config.WeatherProviderConfig;
import org.BenchProject.BenchProject.Service.WeatherServices.Exceptions.ProviderEnumNotExistsException;
import org.BenchProject.BenchProject.Service.WeatherServices.Providers.AccuWeatherProvider;
import org.BenchProject.BenchProject.Service.WeatherServices.Providers.OpenWeatherProvider;
import org.BenchProject.BenchProject.Service.WeatherServices.Providers.WeatherProviderBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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

		WeatherProviderBase weatherProvider = null;

		switch (weatherConfig.getWeatherConfig()) {
		case PROVIDER_1:
			weatherProvider = accuweatherProvider;
			break;
		case PROVIDER_2:
			weatherProvider = openweatherProvider;
			break;
		default:
			throw new ProviderEnumNotExistsException();
		}

		logger.info(String.format("Implementation of %s is initialized as %s.", "WeatherProvider",
				weatherProvider.toString()));

		return weatherProvider.getTemperatureByCity(city);
	}
}
