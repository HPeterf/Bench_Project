package org.BenchProject.BenchProject;

import org.BenchProject.BenchProject.Model.CityTemperature;
import org.BenchProject.BenchProject.Service.CityTemperatureServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class CityTemperatureApiController {

	private final CityTemperatureServiceImpl citytemperature;

	public CityTemperatureApiController(CityTemperatureServiceImpl citytemperature) {
		this.citytemperature = citytemperature;
	}

	@RequestMapping("/now/{country}/{city}")
	public CityTemperature getTemperature(@PathVariable String country, @PathVariable String city) {
		return this.citytemperature.getTemperature(country, city);
	}

}
