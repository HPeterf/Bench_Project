package org.BenchProject.BenchProject.Service.WeatherServices.Exceptions;

public class CityNotFoundException extends WeatherException {

	private static final long serialVersionUID = 3511735644392214900L;

	public CityNotFoundException() {
		super("City not found!");
	}

}
