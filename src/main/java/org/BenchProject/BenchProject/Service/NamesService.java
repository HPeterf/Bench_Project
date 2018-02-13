package org.BenchProject.BenchProject.Service;

import java.util.List;

import org.BenchProject.BenchProject.Model.Names;
import org.BenchProject.BenchProject.Service.Exceptions.NamesException;

public interface NamesService {

	public String addNames(Names names) throws NamesException;

	public List<Names> listAllNames();

}
