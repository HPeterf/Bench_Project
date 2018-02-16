package org.BenchProject.BenchProject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.BenchProject.BenchProject.Model.CityTemperature;
import org.BenchProject.BenchProject.Model.CityTemperatureSummary;
import org.BenchProject.BenchProject.Service.CityTemperatureServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/varos")
public class CityTemperatureController {

	private final CityTemperatureServiceImpl citytempservice;
	private final CityTemperatureProperties properties;

	public CityTemperatureController(CityTemperatureServiceImpl citytempservice, CityTemperatureProperties properties) {
		this.citytempservice = citytempservice;
		this.properties = properties;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView cityTemp() {
		Map<String, Object> model = new LinkedHashMap<>();
		model.put("summary", getSummary());
		return new ModelAndView("summary", model);
	}

	private Object getSummary() {
		List<CityTemperatureSummary> summary = new ArrayList<>();
		for (String location : this.properties.getLocations()) {
			String country = location.split("/")[0];
			String city = location.split("/")[1];
			CityTemperature temperature = this.citytempservice.getTemperature(country, city);
			summary.add(createWeatherSummary(country, city, temperature));
		}
		return summary;
	}

	private CityTemperatureSummary createWeatherSummary(String country, String city, CityTemperature temp) {
		return new CityTemperatureSummary(country, city, temp);
	}
}
