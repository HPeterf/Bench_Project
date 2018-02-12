package org.BenchProject.Service;

import org.BenchProject.Model.Names;

public interface NamesService {

	public Iterable<Names> listAllNames();

	public Names saveNames(Names names);

}
