package org.BenchProject.BenchProject.Service.WeatherServices.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weather.config")
@Configuration("weatherConfig")
public class WeatherProviderConfig {

	private WeatherProviderEnum weatherConfig;

	public WeatherProviderEnum getWeatherConfig() {
		return weatherConfig;
	}

	public void setWeatherConfig(WeatherProviderEnum weatherConfig) {
		this.weatherConfig = weatherConfig;
	}
}
