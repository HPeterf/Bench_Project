package org.BenchProject.BenchProject.Model;

public class CityTemperatureSummary {

	private String country;
	private String city;
	private Integer code;
	private double temperature;

	public CityTemperatureSummary(String country, String city, CityTemperature citytemperature) {
		this.country = country;
		this.city = city;
		this.code = citytemperature.getWeatherId();
		this.temperature = citytemperature.getTemperature();
	}

	public String getCountry() {
		return this.country;
	}

	public String getCity() {
		return this.city;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getCelsiusTemperature() {
		double celsiusTemp = this.temperature - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}

}
