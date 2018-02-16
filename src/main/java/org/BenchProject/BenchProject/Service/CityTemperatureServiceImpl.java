package org.BenchProject.BenchProject.Service;

import java.net.URI;

import org.BenchProject.BenchProject.CityTemperatureProperties;
import org.BenchProject.BenchProject.Model.CityTemperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

public class CityTemperatureServiceImpl implements CityTemperatureService {

	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";

	private static final Logger logger = LoggerFactory.getLogger(CityTemperatureServiceImpl.class);

	private final RestTemplate restTemplate;

	private final String apiKey;

	public CityTemperatureServiceImpl(RestTemplateBuilder builder, CityTemperatureProperties properties) {
		this.restTemplate = builder.build();
		this.apiKey = properties.getApi().getKey();
	}

	@Cacheable("weather")
	public CityTemperature getTemperature(String country, String city) {
		logger.info("Requesting current weather for {}/{}", country, city);
		URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
		return invoke(url, CityTemperature.class);
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
		return exchange.getBody();
	}

}
