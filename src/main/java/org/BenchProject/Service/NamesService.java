package org.BenchProject.Service;

import java.util.List;

import org.BenchProject.Model.Names;

public interface NamesService {

	public void addNames(Names names);

	public List<Names> listAllNames();

}
