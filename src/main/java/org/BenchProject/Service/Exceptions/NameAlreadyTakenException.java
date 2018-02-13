package org.BenchProject.Service.Exceptions;

public class NameAlreadyTakenException extends NamesException {

	private static final long serialVersionUID = -5900046809321145908L;

	public NameAlreadyTakenException() {
		super("Name already taken");

	}

}
