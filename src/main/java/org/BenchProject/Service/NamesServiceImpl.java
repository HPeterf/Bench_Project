package org.BenchProject.Service;

import org.BenchProject.Model.Names;
import org.BenchProject.Repository.INames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NamesServiceImpl implements NamesService {

	private INames namesRepo;

	@Autowired
	public void setNamesRepo(INames namesRepo) {
		this.namesRepo = namesRepo;
	}

	@Override
	public Iterable<Names> listAllNames() {
		return namesRepo.findAll();
	}

	@Override
	public Names saveNames(Names names) {
		return namesRepo.save(names);
	}

}
