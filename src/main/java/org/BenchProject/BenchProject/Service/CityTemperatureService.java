package org.BenchProject.BenchProject.Service;

import org.BenchProject.BenchProject.Model.CityTemperature;

public interface CityTemperatureService {

	public CityTemperature getTemperature(String country, String city);

}
