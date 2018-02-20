package org.BenchProject.BenchProject.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccuWeatherCurrentConditionsModel extends WeatherModel {

	public class Temperature {

		public class Metric {

			@JsonProperty("Value")
			private String Value;

			@JsonProperty("Unit")
			private String Unit;

			@JsonProperty("UnitType")
			private String UnitType;

			public String getValue() {
				return Value;
			}

			public void setValue(String value) {
				Value = value;
			}

			public String getUnit() {
				return Unit;
			}

			public void setUnit(String unit) {
				Unit = unit;
			}

			public String getUnitType() {
				return UnitType;
			}

			public void setUnitType(String unitType) {
				UnitType = unitType;
			}
		}

		@JsonProperty("Metric")
		private Metric metric;

		public Metric getMetric() {
			return metric;
		}

		public void setMetric(Metric metric) {
			this.metric = metric;
		}
	}

	@JsonProperty("Temperature")
	private Temperature temperature;

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
}
