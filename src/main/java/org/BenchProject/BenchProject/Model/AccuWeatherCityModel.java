package org.BenchProject.BenchProject.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccuWeatherCityModel extends WeatherModel {

	@JsonProperty("Key")
	private String Key;

	@JsonProperty("LocalizedName")
	private String LocalizedName;

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public String getLocalizedName() {
		return LocalizedName;
	}

	public void setLocalizedName(String localizedName) {
		LocalizedName = localizedName;
	}

	@Override
	public String toString() {
		return "City model; name : " + this.getLocalizedName() + " key: " + this.getKey();
	}

}
