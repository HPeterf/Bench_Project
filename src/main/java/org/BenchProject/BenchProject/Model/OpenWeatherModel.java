package org.BenchProject.BenchProject.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenWeatherModel extends WeatherModel {

	private static final Logger logger = LoggerFactory.getLogger(OpenWeatherModel.class);

	public class Main {

		private static final float KELVIN_CELSIUS_DIFFERENT = (float) 273.15;

		private float temp;

		public float getTemp() {
			return temp;
		}

		public void setTemp(float temp) {
			this.temp = temp;
		}

		public float getTempInCelsius() {
			logger.info("Kelvin: " + this.temp);
			float celsius = (this.temp - KELVIN_CELSIUS_DIFFERENT);
			logger.info("Celsius: " + celsius);

			return celsius;
		}
	}

	private Main main;

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
