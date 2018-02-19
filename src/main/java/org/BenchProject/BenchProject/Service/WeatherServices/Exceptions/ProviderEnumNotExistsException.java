package org.BenchProject.BenchProject.Service.WeatherServices.Exceptions;

public class ProviderEnumNotExistsException extends WeatherException {

	private static final long serialVersionUID = 1L;

	public ProviderEnumNotExistsException() {
		super("Provider ENUM does not exists!");
	}

}
