package org.BenchProject.BenchProject.Service.WeatherServices.Exceptions;

public class CityNotFoundException extends WeatherException {

	private static final long serialVersionUID = 1L;

	public CityNotFoundException() {
		super("City not found!");
	}

}
