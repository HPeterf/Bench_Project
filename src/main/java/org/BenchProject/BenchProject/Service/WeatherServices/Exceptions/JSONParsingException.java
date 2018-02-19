package org.BenchProject.BenchProject.Service.WeatherServices.Exceptions;

public class JSONParsingException extends WeatherException {

	private static final long serialVersionUID = 1L;

	public JSONParsingException() {
		super("Problem with JSON Parsing!");
	}

}
